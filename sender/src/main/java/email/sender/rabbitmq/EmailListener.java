package email.sender.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import email.sender.enums.StatusEmail;
import email.sender.payload.EmailRequest;
import email.sender.repository.EmailRepository;
import email.sender.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmailListener {

    private final EmailRepository emailRepository;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;


    @RabbitListener(queues = "${app-config.rabbit.queue.mail}")
    public void receiveEmail(@Payload EmailRequest request) throws JsonProcessingException {
        var email = request.toEntity ( request );
        email.setStatusEmail( StatusEmail.SENT );
        email.setSendDateTime( LocalDateTime.now() );
        emailRepository.save ( email );
        emailService.SendEmail();
        log.info ( "Email: {}", objectMapper.writeValueAsString ( request ) );
    }

}

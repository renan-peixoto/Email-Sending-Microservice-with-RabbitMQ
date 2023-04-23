package email.sender.rabbitmq;


import com.fasterxml.jackson.databind.ObjectMapper;
import email.sender.enums.StatusEmail;
import email.sender.payload.EmailRequest;
import email.sender.repository.EmailsRepository;
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

    private final EmailsRepository emailsRepository;
    private final ObjectMapper objectMapper;



    @RabbitListener(queues = "${app-config.rabbit.queue.mail}")
    public void receiveEmail(@Payload EmailRequest request) {
        try {
            var email = request.toEntity( request );
            email.setId(email.getId());
            email.setStatusEmail( StatusEmail.SENT );
            email.setSendDateTime( LocalDateTime.now() );
            emailsRepository.save(email);
            log.info( "Email: {}", objectMapper.writeValueAsString( request ) );
        } catch (Exception ex) {
            log.error( "Was not possible to receive the email" );
            log.error(ex.getMessage());
        }
    }

}

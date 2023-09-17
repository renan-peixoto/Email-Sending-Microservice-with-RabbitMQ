package email.sender.infra.rabbitmq;


import com.fasterxml.jackson.databind.ObjectMapper;
import email.sender.adapters.Listener;
import email.sender.adapters.repository.EmailDAO;
import email.sender.core.enums.StatusEmail;
import email.sender.core.payload.EmailRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmailListener implements Listener {

    private final EmailDAO emailDAO;
    private final ObjectMapper objectMapper;

    @Override
    @RabbitListener(queues = "${app-config.rabbit.queue.mail}")
    public void receiveEmail(@Payload EmailRequest request) {
        try {
            var email = request.toEntity( request );
            email.setId(email.getId());
            email.setStatusEmail( StatusEmail.SENT );
            email.setSendDateTime( LocalDateTime.now() );
            emailDAO.saveEmail(email);
            log.info( "Email: {}", objectMapper.writeValueAsString( request ) );
        } catch (Exception ex) {
            log.error( "Was not possible to receive the email" );
            log.error(ex.getMessage());
        }
    }

}

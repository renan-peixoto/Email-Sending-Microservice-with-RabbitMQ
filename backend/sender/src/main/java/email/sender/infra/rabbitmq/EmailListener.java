package email.sender.infra.rabbitmq;


import com.fasterxml.jackson.databind.ObjectMapper;
import email.sender.adapters.Listener;
import email.sender.adapters.MessageFormat;
import email.sender.adapters.SendEmail;
import email.sender.adapters.repository.EmailDAO;
import email.sender.core.enums.EmailStrategy;
import email.sender.core.enums.StatusEmail;
import email.sender.core.payload.EmailRequest;
import email.sender.useCases.GMAILStrategy;
import email.sender.useCases.MailTrapStrategy;
import email.sender.useCases.SendEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
//@RequiredArgsConstructor
@Slf4j
public class EmailListener implements Listener {

    private final EmailDAO emailDAO;
    private final ObjectMapper objectMapper;

    private final SendEmailService sendEmailService;


    private final MessageFormat messageFormat;

    private final SendEmail sendEmail;

    public EmailListener(
            EmailDAO emailDAO,
            ObjectMapper objectMapper,
            SendEmailService sendEmailService,
            MessageFormat messageFormat,
            SendEmail sendEmail) {
        this.emailDAO = emailDAO;
        this.objectMapper = objectMapper;
        this.sendEmailService = sendEmailService;
        this.messageFormat = messageFormat;
        this.sendEmail = sendEmail;
    }


    @Override
    @RabbitListener(queues = "${app-config.rabbit.queue.mail}")
    public void receiveEmail(@Payload EmailRequest request) {
        try {
            var email = request.toEntity( request );
            email.setId(email.getId());
            email.setStatusEmail( StatusEmail.SENT );
            email.setSendDateTime( LocalDateTime.now() );
            email.setStrategy( request.getStrategy() );
            emailDAO.saveEmail(email);

            if (EmailStrategy.MAIL_TRAP.equals( email.getStrategy() )) {

                sendEmailService.setStrategy( new MailTrapStrategy( emailDAO, objectMapper, messageFormat, sendEmail ) );
                sendEmailService.sendMailTrap();
                log.info( "sending by MailTrap" );
            } else if(EmailStrategy.GMAIL.equals( email.getStrategy() )) {
                sendEmailService.setStrategy( new GMAILStrategy() );
                sendEmailService.sendGmail();
            } else {
                Exception ex = new Exception();
                log.error( "Something went wrong" );
                log.error(ex.getMessage());
            }
        } catch (Exception ex) {
            log.error( "Was not possible to receive the email" );
            log.error(ex.getMessage());
        }
    }



}

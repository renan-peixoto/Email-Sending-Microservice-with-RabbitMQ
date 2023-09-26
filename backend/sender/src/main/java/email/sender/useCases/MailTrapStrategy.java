package email.sender.useCases;

import com.fasterxml.jackson.databind.ObjectMapper;
import email.sender.adapters.MessageFormat;
import email.sender.adapters.SendEmail;
import email.sender.adapters.repository.EmailDAO;
import email.sender.core.enums.EmailStrategy;
import email.sender.core.interfaces.SendEmailStrategy;
import email.sender.core.enums.StatusEmail;
import email.sender.core.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Primary
public class MailTrapStrategy implements SendEmailStrategy {

    private  final EmailDAO emailRepositoryImpl;

    private final  ObjectMapper objectMapper;

    private final MessageFormat messageFormat;

    private final SendEmail sendEmail;

    public MailTrapStrategy(EmailDAO emailRepositoryImpl, ObjectMapper objectMapper, MessageFormat messageFormat, SendEmail sendEmail) {
        this.emailRepositoryImpl = emailRepositoryImpl;
        this.objectMapper = objectMapper;
        this.messageFormat = messageFormat;
        this.sendEmail = sendEmail;
    }



    @Override
    public void sendEmail() {
        try {
            var emails = emailRepositoryImpl.findAllEmails ();
            if (!emails.isEmpty()) {
                for (Email email: emails) {
                    SimpleMailMessage message = messageFormat.formatMessage(email);
                    if (email.getStatusEmail() == StatusEmail.SENT && email.getStrategy() == EmailStrategy.MAIL_TRAP) {
                        sendEmail.send( message );
                        email.setStatusEmail( StatusEmail.DELETED );
                        emailRepositoryImpl.saveEmail( email );
                        log.info("Sending email to: {}", objectMapper.writeValueAsString( message.getTo() ));
                    }
                }
            }
        } catch (Exception ex) {
            log.error( "Not possible to send the email.", ex );
        }

    }

}

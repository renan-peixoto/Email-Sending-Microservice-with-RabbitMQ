package email.sender.useCases;

import com.fasterxml.jackson.databind.ObjectMapper;
import email.sender.adapters.MessageFormat;
import email.sender.adapters.SendEmail;
import email.sender.adapters.repository.EmailDAO;
import email.sender.core.EmailService;
import email.sender.core.enums.StatusEmail;
import email.sender.core.model.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {
    
    private final EmailDAO emailRepositoryImpl;
    private final ObjectMapper objectMapper;
    private final MessageFormat messageFormat;
    private final SendEmail sendEmail;


    @Override
    @Scheduled(fixedDelay = 10000)
    public void sendEmail() {


        try {
            var emails = emailRepositoryImpl.findAllEmails ();
            if (!emails.isEmpty()) {
                for (Email email: emails) {
                    SimpleMailMessage message = messageFormat.formatMessage(email);
                    if (email.getStatusEmail() == StatusEmail.SENT) {
                        sendEmail.send( message );
                        log.info("Sending email to: {}", objectMapper.writeValueAsString( message.getTo() ));
                        email.setStatusEmail( StatusEmail.DELETED );
                        emailRepositoryImpl.saveEmail( email );
                    }
                }
            }
        } catch (Exception ex) {
            log.error( "Not possible to send the email." );
        }
    }
}

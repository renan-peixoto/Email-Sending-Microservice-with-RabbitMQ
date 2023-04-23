package email.sender.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import email.sender.enums.StatusEmail;
import email.sender.model.Email;
import email.sender.repository.EmailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    
    private final EmailsRepository emailsRepository;
    private final JavaMailSender javaMailSender;
    private final ObjectMapper objectMapper;


    @Scheduled(fixedDelay = 10000)
    public void sendEmail() {


        try {
            var emails = emailsRepository.findAll ();
            if (!emails.isEmpty()) {
                for (Email email: emails) {

                    var message = new SimpleMailMessage();
                    message.setFrom( email.getEmailFrom() );
                    message.setTo( email.getEmailTo() );
                    message.setSubject( email.getSubject() );
                    message.setText( email.getText() );
                    if (email.getStatusEmail() == StatusEmail.SENT) {
                        javaMailSender.send( message );
                        log.info("Sending email to: {}", objectMapper.writeValueAsString( message.getTo() ));
                        email.setStatusEmail( StatusEmail.DELETED );
                        emailsRepository.save( email );
                    }
                }
            }
        } catch (Exception ex) {
            log.error( "Not possible to send the email." );
        }
    }
}

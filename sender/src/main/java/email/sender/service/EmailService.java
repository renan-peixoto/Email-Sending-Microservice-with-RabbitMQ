package email.sender.service;

import email.sender.model.Email;
import email.sender.payload.EmailRequest;
import email.sender.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    
    private final EmailRepository emailRepository;
    private final JavaMailSender javaMailSender;



    public void SendEmail() {

        var emails = emailRepository.findAll ();
        if (emails.isEmpty()) {
            log.error( "There is no email to be sent" );
        }

        for (Email email: emails) {
            var message = new SimpleMailMessage();
            message.setFrom( email.getEmailFrom() );
            message.setTo( email.getEmailTo() );
            message.setSubject( email.getSubject() );
            message.setText( email.getText() );
            javaMailSender.send( message );
        }
    }
}

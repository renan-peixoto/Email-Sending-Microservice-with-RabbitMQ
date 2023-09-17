package email.sender.infra;

import email.sender.adapters.MessageFormat;
import email.sender.adapters.SendEmail;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SendEmailImpl implements SendEmail {

    private final JavaMailSender javaMailSender;

    public SendEmailImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void send(SimpleMailMessage message) {
        javaMailSender.send(message);
    }
}

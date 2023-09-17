package email.sender.adapters;

import org.springframework.mail.SimpleMailMessage;

public interface SendEmail {

    public void send(SimpleMailMessage message);
}

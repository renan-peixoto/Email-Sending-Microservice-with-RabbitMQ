package email.sender.adapters;

import email.sender.core.model.Email;
import org.springframework.mail.SimpleMailMessage;

public interface MessageFormat {

    public SimpleMailMessage formatMessage(Email request);
}

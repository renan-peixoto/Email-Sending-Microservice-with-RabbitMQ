package email.sender.infra;

import email.sender.adapters.MessageFormat;
import email.sender.core.model.Email;
import email.sender.core.payload.EmailRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MessageFormatImpl implements MessageFormat {
    @Override
    public SimpleMailMessage formatMessage(Email email) {
        var message = new SimpleMailMessage();
        message.setFrom(email.getEmailFrom());
        message.setTo(email.getEmailTo());
        message.setSubject(email.getSubject());
        message.setText(email.getText());
        return message;
    }
}

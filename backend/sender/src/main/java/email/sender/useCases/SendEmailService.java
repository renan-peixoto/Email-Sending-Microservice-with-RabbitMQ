package email.sender.useCases;

import email.sender.core.interfaces.SendEmailStrategy;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class SendEmailService {
    private SendEmailStrategy mailTrapStrategy;
    private SendEmailStrategy gmailStrategy;

    public SendEmailService(
            @Qualifier("mailTrap") SendEmailStrategy mailTrapStrategy,
            @Qualifier("gmail") SendEmailStrategy gmailStrategy
    ) {
        this.mailTrapStrategy = mailTrapStrategy;
        this.gmailStrategy = gmailStrategy;
    }
    @NotNull
    public void setStrategy(SendEmailStrategy newStrategy) {
        this.mailTrapStrategy = newStrategy;
        this.gmailStrategy = newStrategy;
    }

    public void sendMailTrap() {
        mailTrapStrategy.sendEmail( );
    }
    public void sendGmail() {
        gmailStrategy.sendEmail( );
    }

}

package email.sender.useCases;

import email.sender.core.interfaces.SendEmailStrategy;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
    private SendEmailStrategy currentStrategy;

    public SendEmailService(SendEmailStrategy currentStrategy) {
        this.currentStrategy = currentStrategy;
    }
    @NotNull
    public void setStrategy(SendEmailStrategy newStrategy) {
        this.currentStrategy = newStrategy;
    }

    public void sendEmail() {
        currentStrategy.sendEmail( );
    }
}

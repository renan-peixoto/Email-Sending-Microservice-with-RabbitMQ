package email.sender.useCases;

import email.sender.core.interfaces.SendEmailStrategy;
import email.sender.core.enums.EmailStrategy;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Slf4j
public class GMAILStrategy implements SendEmailStrategy {
    @Override
    public void sendEmail() {
        log.info( "Try again later..." );
    }


}

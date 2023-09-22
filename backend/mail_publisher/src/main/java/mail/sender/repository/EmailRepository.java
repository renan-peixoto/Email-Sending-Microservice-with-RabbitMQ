package mail.sender.repository;

import java.util.List;
import java.util.UUID;
import mail.sender.model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
}

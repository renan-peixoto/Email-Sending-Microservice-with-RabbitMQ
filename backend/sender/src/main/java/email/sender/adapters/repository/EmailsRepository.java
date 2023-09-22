package email.sender.adapters.repository;

import email.sender.core.model.Email;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmailsRepository extends MongoRepository<Email, String> {
}

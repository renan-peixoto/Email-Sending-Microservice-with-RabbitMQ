package email.sender.repository;

import email.sender.model.Email;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmailsRepository extends MongoRepository<Email, String> {
}

package email.sender.infra.repository;

import email.sender.adapters.repository.EmailDAO;
import email.sender.core.model.Email;
import email.sender.adapters.repository.EmailsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmailRepositoryImpl implements EmailDAO {

    public final EmailsRepository emailsRepository;

    public EmailRepositoryImpl(EmailsRepository emailsRepository) {
        this.emailsRepository = emailsRepository;
    }

    @Override
    public List<Email> findAllEmails() {
        return emailsRepository.findAll();
    }

    @Override
    public void saveEmail(Email email) {
        emailsRepository.save(email);
    }
}

package email.sender.adapters.repository;

import email.sender.core.model.Email;

import java.util.List;

public interface EmailDAO {

    public List<Email> findAllEmails();

    public void saveEmail(Email email);
}

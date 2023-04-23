package mail.sender.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mail.sender.dto.EmailConfirmationDTO;
import mail.sender.dto.EmailRequest;
import mail.sender.dto.EmailResponse;
import mail.sender.enuns.StatusEmail;
import mail.sender.model.EmailModel;
import mail.sender.repository.EmailRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {

  private final EmailRepository emailRepository;
  private final RabbitTemplate rabbitTemplate;
  private final ObjectMapper objectMapper;

  @Value("${app-config.rabbit.exchange.mail}")
  private String mailFanoutExchange;

  public EmailResponse sendEmail(EmailRequest request)
    throws JsonProcessingException {
    try {
      var message = new SimpleMailMessage();
      message.setFrom(request.getEmailFrom());
      message.setTo(request.getEmailTo());
      message.setSubject(request.getSubject());
      message.setText(request.getText());
      log.info("Info {}", objectMapper.writeValueAsString(request));
      request.setStatusEmail(StatusEmail.SENT);

      rabbitTemplate.convertAndSend(mailFanoutExchange, "", request);
    } catch (MailException e) {
      request.setStatusEmail(StatusEmail.ERROR);
    }
    var email = emailRepository.save(EmailModel.of(request));
    return EmailResponse.of(email);
  }


  public void emailConfirmation(EmailConfirmationDTO confirmation)
    throws JsonProcessingException {
    if (confirmation.getStatus() == null) {
      log.error(
        "Email could not be deliverd.",
        objectMapper.writeValueAsString(confirmation.getEmailTo())
      );
    } else {
      log.info(
        "Email to {} was sent with success.",
        objectMapper.writeValueAsString(confirmation.getEmailTo())
      );
    }
  }
}

package mail.sender.rabbitmq.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mail.sender.dto.EmailConfirmationDTO;
import mail.sender.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmailConsumer {

  private final EmailService emailService;
  private final ObjectMapper objectMapper;

  @RabbitListener(queues = "${app-config.rabbit.queue.mail}")
  public void receiveEmails(EmailConfirmationDTO confirmation)
    throws JsonProcessingException {
    emailService.emailConfirmation(confirmation);
  }
}

package mail.sender.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mail.sender.dto.EmailRequest;
import mail.sender.dto.EmailResponse;
import mail.sender.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email/")
@RequiredArgsConstructor
public class EmailController {

  private final EmailService emailService;

  @PostMapping("create-email")
  @ResponseStatus(code = HttpStatus.CREATED)
  public EmailResponse createEmail(@RequestBody @Valid EmailRequest request)
    throws JsonProcessingException {
    return emailService.sendEmail(request);
  }

}

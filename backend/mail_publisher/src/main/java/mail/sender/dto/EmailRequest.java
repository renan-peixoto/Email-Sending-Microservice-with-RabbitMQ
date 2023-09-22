package mail.sender.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import mail.sender.enuns.StatusEmail;

@Data
public class EmailRequest {


  @NotBlank
  private String ownerRef;


  @NotBlank
  private String emailFrom;


  @NotBlank
  private String emailTo;

  @NotBlank
  private String subject;

  @NotBlank
  private String text;

  private StatusEmail statusEmail;
}

package mail.sender.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mail.sender.enuns.StatusEmail;
import mail.sender.model.EmailModel;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailResponse {

  @JsonProperty("email_id")
  private UUID emailId;

  @JsonProperty("owner_ref")
  private String ownerRef;

  @JsonProperty("email_from")
  private String emailFrom;

  @JsonProperty("email_to")
  private String emailTo;

  private String subject;

  private String text;

  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  private LocalDateTime sendDateTime;

  private StatusEmail statusEmail;

  public static EmailResponse of(EmailModel emailModel) {
    var response = new EmailResponse();
    BeanUtils.copyProperties(emailModel, response);
    return response;
  }
}

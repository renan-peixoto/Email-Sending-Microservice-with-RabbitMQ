package mail.sender.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mail.sender.enuns.StatusEmail;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailConfirmationDTO {

  private String emailTo;
  private StatusEmail status;
}

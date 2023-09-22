package mail.sender.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mail.sender.dto.EmailRequest;
import mail.sender.enuns.StatusEmail;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmailModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID emailId;

  private String ownerRef;
  private String emailFrom;
  private String emailTo;
  private String subject;

  @Column(columnDefinition = "TEXT")
  private String text;

  private LocalDateTime sendDateTime;

  private StatusEmail StatusEmail;

  @PrePersist
  public void prePersist() {
    sendDateTime = LocalDateTime.now();
  }

  public static EmailModel of(EmailRequest request) {
    var email = new EmailModel();
    BeanUtils.copyProperties(request, email);
    return email;
  }
}

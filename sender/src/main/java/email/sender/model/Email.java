package email.sender.model;

import email.sender.enums.StatusEmail;
import email.sender.payload.EmailResponse;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String text;

    private LocalDateTime sendDateTime;

    @Enumerated(value = EnumType.STRING)
    private StatusEmail statusEmail;


    public EmailResponse toResponse(Email email) {
        var response = new EmailResponse();
        BeanUtils.copyProperties(email, response);
        return response;
    }


}

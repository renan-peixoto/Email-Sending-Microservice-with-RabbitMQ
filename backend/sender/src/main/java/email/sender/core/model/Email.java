package email.sender.core.model;

import email.sender.core.enums.StatusEmail;
import email.sender.core.payload.EmailResponse;

import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "email")
public class Email {

    @Id
    private String id;

    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;


    private String text;

    private LocalDateTime sendDateTime;


    private StatusEmail statusEmail;


    public EmailResponse toResponse(Email email) {
        var response = new EmailResponse();
        BeanUtils.copyProperties(email, response);
        return response;
    }


}

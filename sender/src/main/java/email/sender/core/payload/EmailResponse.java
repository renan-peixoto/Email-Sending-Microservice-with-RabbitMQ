package email.sender.core.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import email.sender.core.enums.StatusEmail;


import email.sender.core.model.Email;
import lombok.Data;
import org.springframework.beans.BeanUtils;


import java.time.LocalDateTime;


@Data
public class EmailResponse {
    @JsonProperty("email_id")
    private String id;

    @JsonProperty("owner_ref")
    private String ownerRef;
    @JsonProperty("email_from")
    private String emailFrom;
    @JsonProperty("email_to")
    private String emailTo;

    private String subject;

    private String text;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty("send_date_time")
    private LocalDateTime sendDateTime;

    @JsonProperty("status_email")
    private StatusEmail statusEmail;

    public Email toEntity(EmailResponse response) {
        var email = new Email();
        BeanUtils.copyProperties(response, email);
        return email;
    }

}

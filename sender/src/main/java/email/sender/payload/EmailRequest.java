package email.sender.payload;

import email.sender.model.Email;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class EmailRequest {

    @NotNull
    private String ownerRef;
    @NotNull
    private String emailFrom;
    @NotNull
    private String emailTo;
    @NotNull
    private String subject;
    @NotNull
    private String text;

    public Email toEntity(EmailRequest request) {
        var email = new Email();
        BeanUtils.copyProperties(request, email);
        return email;
    }
}

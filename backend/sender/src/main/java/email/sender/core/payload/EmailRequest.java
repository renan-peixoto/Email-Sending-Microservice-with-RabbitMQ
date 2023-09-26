package email.sender.core.payload;

import email.sender.core.enums.EmailStrategy;
import email.sender.core.model.Email;
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
@NotNull
    private EmailStrategy strategy;

    public Email toEntity(EmailRequest request) {
        var email = new Email();
        BeanUtils.copyProperties(request, email);
        return email;
    }
}

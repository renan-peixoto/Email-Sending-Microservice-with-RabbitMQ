package email.sender.adapters;

import email.sender.core.payload.EmailRequest;

public interface Listener {

    public void receiveEmail(EmailRequest request);
}

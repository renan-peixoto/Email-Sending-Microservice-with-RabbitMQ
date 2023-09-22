import { Component } from '@angular/core';
import { EmailRequest } from 'src/app/app/models/EmailRequest';
import { EmailSendingService } from 'src/app/services/email-sending.service';

@Component({
  selector: 'app-send-email-form',
  templateUrl: './send-email-form.component.html',
  styleUrls: ['./send-email-form.component.scss'],
})
export class SendEmailFormComponent {
  email: EmailRequest = {};

  errorMsg: string = '';
  successMsg: string = '';

  constructor(private emailService: EmailSendingService) {}

  sendEmail() {
    this.errorMsg = '';
    this.successMsg = '';

    this.emailService.sendEmail(this.email).subscribe({
      next: (response) => {
        console.log(response);
        if (response.statusEmail === 'SENT') {
          this.successMsg = 'Email sent successfully';
        }
      },
      error: (err) => {
        if (err.statusEmail !== 'SENT') {
          this.errorMsg = 'Email not sent';
        }
      },
    });
  }
}

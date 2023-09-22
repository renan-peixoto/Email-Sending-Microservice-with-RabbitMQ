import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EmailRequest } from '../app/models/EmailRequest';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EmailSendingService {
  constructor(private http: HttpClient) {}

  sendEmail(emailRequest: EmailRequest): Observable<any> {
    return this.http.post(
      'http://localhost:8080/email/create-email',
      emailRequest
    );
  }
}

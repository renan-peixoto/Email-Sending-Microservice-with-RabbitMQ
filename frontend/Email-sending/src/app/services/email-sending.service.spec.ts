import { TestBed } from '@angular/core/testing';

import { EmailSendingService } from './email-sending.service';

describe('EmailSendingService', () => {
  let service: EmailSendingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmailSendingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SendEmailFormComponent } from './send-email-form.component';

describe('SendEmailFormComponent', () => {
  let component: SendEmailFormComponent;
  let fixture: ComponentFixture<SendEmailFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SendEmailFormComponent]
    });
    fixture = TestBed.createComponent(SendEmailFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

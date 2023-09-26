import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SendEmailComponent } from './app/components/send-email/send-email.component';

import { FormsModule } from '@angular/forms';
import { SendEmailFormComponent } from './app/components/send-email/send-email-form/send-email-form.component';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { HttpClientModule } from '@angular/common/http';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { DropdownModule } from 'primeng/dropdown';

@NgModule({
  declarations: [AppComponent, SendEmailComponent, SendEmailFormComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ButtonModule,
    InputTextModule,
    InputTextareaModule,
    HttpClientModule,
    MessagesModule,
    MessageModule,
    DropdownModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}

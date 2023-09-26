
export interface EmailRequest {
  ownerRef: string;
  emailFrom: string;
  emailTo: string;
  subject: string;
  text: string;
  strategy: string
}

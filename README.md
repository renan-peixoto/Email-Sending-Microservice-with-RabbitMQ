# Email Sending Microservice with RabbitMQ 
This project proposes a solution to the problem of relying on a single email service in a microservices-based architecture. The solution involves creating a new microservice responsible for receiving messages from a RabbitMQ queue and handling email sending using an email service.

## Technologies Used
- Spring Boot 3
- MongoDB
- RabbitMQ
- JavaMail
- Docker Compose
- PostgreSQL

## Features

- Creation of a new microservice for email sending, reducing the dependency on a single email service in a microservices-based architecture.
- Utilization of RabbitMQ to ensure communication between microservices.
- Utilization of MailTrap email service as a testing tool to validate email sending before going into production.
- Creation of a producer microservice to simulate email sending to the microservice responsible for sending emails.
- Usage of Docker Compose to create and manage containers for the project's technologies.

## Pre requisites

Before getting started, make sure you have the following installed on your machine:


- Docker
- Docker Compose
## Installation and Setup
1. Clone the repository to your machine:

   ```bash
   git clone https://github.com/your-username/repository-name.git
   ```
2. Navigate to the project folder:

   ```bash
   cd repository-name
   ```
3. Start Docker Compose:

   ```bash
   docker-compose up
   ```
4. Create an free account on [MailTrap](https://mailtrap.io/) to use it as a testing tool.
5. Create an inbox and in the credentials copy the SMTP host, one of the ports, username and password.
6. Change the configurations in the applications.yml in the resources package, like username and password.


## How to Use
Access RabbitMQ at http://localhost:15672 and log in with credentials guest and guest.

Access the mail_publisher API with Postman or Insomnia at  http://localhost:8080/email/create-email and send a POST HTTP
request to simulate email sending to the microservice responsible for sending emails.
   Example:
   ```json
   {
    "ownerRef": "Test",
    "emailFrom": "test@test.com",
    "emailTo": "email_mensager@gmail.com",
    "subject": "email test",
    "text": "Success"
    }
   ```

The email sending microservice will receive messages from the RabbitMQ queue and process them to send emails using the MailTrap email service.


## License
This project is licensed under the MIT License. Please see the LICENSE file for more information.
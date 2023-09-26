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
   cd ./Email-Sending-Microservice-with-RabbitMQ
   ```

4. Create a free account on [MailTrap](https://mailtrap.io/) to use it as a testing tool.
5. Create an inbox and in the credentials copy the SMTP host, one of the ports, username and password.

      ![credentials.png](assets%2Fcredentials.png)

6. Change the sender-api configurations in the applications.yml in the resources package, like username and password.
7. Start Docker Compose:
   ```bash
   docker-compose up -d
   ```
8. Open and run the sender-api


## How to Use

Access the frontend aplication with the url: http://localhost:3000 and enter the fields and select the shipping strategy and send.

![frontend-emailSender.png](assets%2Ffrontend-emailSender.png)

The email sending microservice will receive messages from the RabbitMQ and process them to send emails using the MailTrap email service.



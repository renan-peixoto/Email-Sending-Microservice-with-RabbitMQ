# Email Sending Microservice with RabbitMQ 
## Description 📖
This project proposes a solution so that all applications that need to send emails do not need to have such a service within the application itself. The solution would be for the applications that wish to send emails (publishers) to send the email to an exchange, and from there, the microservice responsible for sending emails would listen to the queue and send the email to the recipient. This way, several other producing applications would not need to have this service within their code; they would only need to send the email to the exchange.
Up to this point, the application has only been using a test email sending service like MailTrap. However, with the implementation of the strategy pattern, it is possible to implement another real email sending service in the future.

## Technologies Used 💻
- `Spring Boot 3`
- `MongoDB`
- `RabbitMQ`
- `JavaMail`
- `Docker Compose`
- `PostgreSQL`

## Features 🔩

- Creation of a new microservice for email sending, reducing the dependency on a single email service in a microservices-based architecture.
- Utilization of RabbitMQ to ensure communication between microservices.
- Utilization of MailTrap email service as a testing tool to validate email sending before going into production.
- Creation of a producer microservice to simulate email sending to the microservice responsible for sending emails.
- Usage of Docker Compose to create and manage containers for the project's technologies.

## How it works ❓
- Receives email data from a RabbitMQ queue
   - OwnerRef (name), emailFrom (from), emailTo (to), subject, text, status and strategy.
   - The strategy property is to select which email sending service to use.
- Saves this data to a MongoDB database
- Send the email to the recipient
- Changes the status of the email saved in the database from SENT to DELETED,indicating that the email no longer needs to be sent.

## Pre requisites 🔧

Before getting started, make sure you have the following installed on your machine:


- Docker
- Docker Compose
## Installation and Setup 🛠
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


## How to Use ❔

Access the frontend aplication with the url: http://localhost:3000 and enter the fields and select the shipping strategy and send.

![frontend-emailSender.png](assets%2Ffrontend-emailSender.png)

The email sending microservice will receive messages from the RabbitMQ and process them to send emails using the MailTrap email service.

## Future implementations 🚧
- Functional email sending service



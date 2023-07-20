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
4. Create an account on MailTrap to use it as a testing tool.

5. Access RabbitMQ at http://localhost:15672 and log in with credentials guest and guest.

6. Access the producer microservice at http://localhost:8080 and send an HTTP request to simulate email sending to the microservice responsible for sending emails.

7. The email sending microservice will receive messages from the RabbitMQ queue and process them to send emails using the MailTrap email service.

## How to Use
The producer microservice can be used to simulate email sending to the microservice responsible for sending emails. To do this, simply send an HTTP request to the URL http://localhost:8080/api/send with the email data in the request body.

The email sending microservice will receive messages from the RabbitMQ queue and process them to send emails using the MailTrap email service.

## License
This project is licensed under the MIT License. Please see the LICENSE file for more information.
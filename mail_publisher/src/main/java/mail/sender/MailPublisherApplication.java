package mail.sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MailPublisherApplication {

  public static void main(String[] args) {
    SpringApplication.run(MailPublisherApplication.class, args);
  }
}

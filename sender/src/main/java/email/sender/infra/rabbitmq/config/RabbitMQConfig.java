package email.sender.infra.rabbitmq.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
    @Value("${app-config.rabbit.exchange.mail}")
    private String mailFanoutExchange;

    @Value("${app-config.rabbit.routingKey.mail}")
    private String mailConfirmationKey;

    @Value("${app-config.rabbit.queue.mail}")
    private String mailConfirmationMq;

    @Bean
    public FanoutExchange mailExchange() {
        return new FanoutExchange(mailFanoutExchange);
    }


    @Bean
    public Queue mailConfirmationMq() {
        return new Queue(mailConfirmationMq, true);
    }

    @Bean
    public Binding mailConfirmationMqBinding(FanoutExchange fanoutExchange) {
        return BindingBuilder
                .bind(mailConfirmationMq())
                .to(fanoutExchange);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
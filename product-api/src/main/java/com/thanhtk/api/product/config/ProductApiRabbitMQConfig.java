package com.thanhtk.api.product.config;

import lombok.Getter;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
@Getter
public class ProductApiRabbitMQConfig {

    private static ProductApiRabbitMQConfig instanceRef;

    private final String exchange;
    private final String queue;
    private final String exclusiveQueue;
    private final String[] queues;
    private final String productEvent;

    public ProductApiRabbitMQConfig(@Value("${rabbitmq.exchange}") String exchange,
                                    @Value("${rabbitmq.queue}") String queue,
                                    @Value("${rabbitmq.routing-key.product-event}") String productEvent) {
        this.exchange = exchange;
        this.queue = queue;
        this.exclusiveQueue = String.format("%s.node.%s", queue, UUID.randomUUID().toString());
        this.queues = new String[]{queue, this.exclusiveQueue};
        this.productEvent = productEvent;
        initConstructor(this);
    }

    private static void initConstructor(ProductApiRabbitMQConfig t) {
        instanceRef = t;
    }

    public static ProductApiRabbitMQConfig getInstanceRef() {
        return instanceRef;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory rabbitConnFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(rabbitConnFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Declarables bindings() {
        DirectExchange ex = new DirectExchange(this.exchange);
        Queue q = new Queue(this.queue);
        Queue eq = new Queue(this.exclusiveQueue, true, true, true);


        return new Declarables(
                ex,
                q,
                eq,
                BindingBuilder.bind(q).to(ex).with(this.productEvent)
        );
    }
}

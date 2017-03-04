package com.cqrs.complains.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

/**
 * Created by mradul on 03/03/17.
 */
@Configuration
@ComponentScan({"com.cqrs.complains"})
@EnableJpaRepositories("com.cqrs.complains.query.repositories")
@EntityScan(basePackages = {"com.cqrs.complains.query.entities",
        "org.axonframework.eventsourcing.eventstore.jpa",
        "org.axonframework.eventhandling.saga.repository.jpa",
        "org.axonframework.eventhandling.tokenstore.jpa"})
public class ComplainsConfig {



        @Autowired
        public void configure(AmqpAdmin admin){
            admin.declareExchange(exchange());
            admin.declareQueue(queue());
            admin.declareBinding(binding());
        }

        @Bean
        public Exchange exchange()
        {
           return ExchangeBuilder.fanoutExchange("ComplaintEvents").build();
        }

        @Bean
        public Queue queue(){
            return QueueBuilder.durable("ComplaintEvents").build();
        }

        @Bean
        public Binding binding(){
            return BindingBuilder.bind(queue()).to(exchange()).with("*").noargs();
        }

}

package com.cqrs.statistics.config;

import com.rabbitmq.client.Channel;
import org.axonframework.amqp.eventhandling.DefaultAMQPMessageConverter;
import org.axonframework.amqp.eventhandling.spring.SpringAMQPMessageSource;
import org.axonframework.serialization.Serializer;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mradul on 03/03/17.
 */

@Configuration
@ComponentScan({"com.cqrs.statistics"})
public class StatisticsConfig {

        @Bean("complaintEvents")
        public SpringAMQPMessageSource complaintEvents(Serializer serializer)
        {
            return new SpringAMQPMessageSource(new DefaultAMQPMessageConverter(serializer)){

                @RabbitListener(queues = "ComplaintEvents")
                @Override
                public void onMessage(Message message, Channel channel) throws Exception {
                    super.onMessage(message, channel);
                }
            };
        }
}

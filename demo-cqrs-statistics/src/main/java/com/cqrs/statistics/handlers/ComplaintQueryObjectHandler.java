package com.cqrs.statistics.handlers;

import com.cqrs.statistics.controllers.StatisticsController;
import com.cqrs.complains.events.ComplaintFiledEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by mradul on 03/03/17.
 */

@ProcessingGroup("amqpEvents")
@Component
public class ComplaintQueryObjectHandler {

    @EventHandler
    public void on(ComplaintFiledEvent event){
        StatisticsController.statistics.computeIfAbsent(event.getCompany(), k -> new AtomicLong()).incrementAndGet();
    }

}

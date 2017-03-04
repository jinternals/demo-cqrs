package com.cqrs.complains.query.handlers;

import com.cqrs.complains.events.ComplaintFiledEvent;
import com.cqrs.complains.query.entities.ComplainQueryObject;
import com.cqrs.complains.query.repositories.ComplainQueryObjectRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mradul on 03/03/17.
 */

@Component
public class ComplaintQueryObjectHandler {

    private final ComplainQueryObjectRepository repository;

    @Autowired
    ComplaintQueryObjectHandler(ComplainQueryObjectRepository repository){
        this.repository = repository;
    }

    @EventHandler
    public void on(ComplaintFiledEvent event){
        repository.save(new ComplainQueryObject(event.getId(),event.getCompany(),event.getDescription()));
    }
}

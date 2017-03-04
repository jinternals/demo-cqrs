package com.cqrs.complains.aggrigates;

import com.cqrs.complains.commands.FileComplaintCommand;
import com.cqrs.complains.events.ComplaintFiledEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateRoot;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * Created by mradul on 03/03/17.
 */
@Aggregate
public class Complaint {

    @AggregateIdentifier
    String id;

    Complaint(){}

    @CommandHandler
    public Complaint(FileComplaintCommand command){
        Assert.hasLength(command.getCompany());
        apply(new ComplaintFiledEvent(command.getId(),command.getCompany(),command.getDescription()));
    }

    /*
     * Will be invoked by apply method or during replay
     */
    @EventSourcingHandler
    public void  on(ComplaintFiledEvent event){
        //rehydrate state of the aggregate
        this.id = event.getId();
    }
}

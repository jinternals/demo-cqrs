package com.cqrs.complains.query.controllers;

import com.cqrs.complains.commands.FileComplaintCommand;
import com.cqrs.complains.query.entities.ComplainQueryObject;
import com.cqrs.complains.query.repositories.ComplainQueryObjectRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mradul on 03/03/17.
 */
@RestController
public class ComplainController {

  private final ComplainQueryObjectRepository repository;
  private final CommandGateway commandGateway;

    @Autowired
    public ComplainController(ComplainQueryObjectRepository repository,CommandGateway commandGateway){
        this.repository = repository;
        this.commandGateway = commandGateway;
    }

    @GetMapping
    public List<ComplainQueryObject> findAll(){
        return repository.findAll();
    }


    @GetMapping("/{id}")
    public ComplainQueryObject findOne(@PathVariable(value = "id",required = true)String id){
        return repository.findOne(id);
    }

    @PostMapping
    public void fileCompalint(@RequestBody Map<String,String> request){
        String id = UUID.randomUUID().toString();
        commandGateway.send(new FileComplaintCommand(id,request.get("company"),request.get("description")));
    }

}

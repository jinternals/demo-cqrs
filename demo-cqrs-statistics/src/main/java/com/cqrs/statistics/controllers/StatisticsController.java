package com.cqrs.statistics.controllers;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by mradul on 04/03/17.
 */
@RestController
public class StatisticsController {


    public static ConcurrentMap<String , AtomicLong> statistics = Maps.newConcurrentMap();


    @GetMapping
    public ConcurrentMap<String , AtomicLong> getStatistics(){
        return statistics;
    }

}

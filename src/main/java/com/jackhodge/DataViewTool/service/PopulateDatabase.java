package com.jackhodge.DataViewTool.service;

import com.jackhodge.DataViewTool.DataViewToolApplication;
import com.jackhodge.DataViewTool.model.Truckload;
import com.jackhodge.DataViewTool.repository.TruckloadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class PopulateDatabase {
    TruckloadRepository repository;

    @Autowired
    public PopulateDatabase(TruckloadRepository repository) {
        this.repository = repository;
    }

    private static final Logger log = LoggerFactory.getLogger(DataViewToolApplication.class);

    // commandline runner interface runs immediately after program start
    // this is a method returning an implementation of a CommandLineRunner that implements the "run" method
    // we RETURN a commandLineRunner
    // @Bean makes it run at start; registers the object returned by this method as a bean to be run at startup
    /*
    @Bean
    public CommandLineRunner populate(){
        return (args) -> {

            repository.save(new Truckload("Jack", "Hodge"));
            repository.save(new Truckload("Miles", "Davis"));
            repository.save(new Truckload("Hellen", "Davis"));
            repository.save(new Truckload("John", "Doe"));
            repository.save(new Truckload("Johnny", "Doe"));
            repository.save(new Truckload("Jennifer", "Doe"));
            repository.save(new Truckload("Bill", "Doe"));
            repository.save(new Truckload("Parsons", "Project"));

            log.info("Default Data Inserted by PopulateDatabase Service: ");

            // findAll returns an iterable,
            // foreach is defined in the iterable interface, and has a default
            // implementaion which consumes a Consumer interface

            repository.findAll().forEach(person -> {
                log.info("Database Added: " + person.toString());
            });

        };
    }
    */
}

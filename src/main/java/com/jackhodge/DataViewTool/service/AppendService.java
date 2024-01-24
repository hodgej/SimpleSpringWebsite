package com.jackhodge.DataViewTool.service;

import com.jackhodge.DataViewTool.DataViewToolApplication;
import com.jackhodge.DataViewTool.model.Person;
import com.jackhodge.DataViewTool.repository.PersonRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppendService {
    PersonRepository repository;
    private static final Logger log = LoggerFactory.getLogger(DataViewToolApplication.class);

    public AppendService(PersonRepository repository){
        this.repository = repository;
    }

    // TODO: accurate response codes
    // Returns 1 by default regardless of state
    public int addToDatabase(Person p){
        repository.save(p);
        log.info("Saved Person to Database: " + p);

        return 1;
    }


    // Deletion Actions complete by the Service either report "1" (success) or "0" (failure)
    @Transactional
    public int removeFromDatabaseByLastname(String lastName){
        long responseCode = repository.deleteByLastName(lastName);
        return responseCode > 0 ? 1 : 0;
    }

    @Transactional
    public int removeFromDatabaseByFullName(String firstName, String lastName){
        long responseCode = repository.deleteByFirstNameAndLastName(firstName, lastName);
        return responseCode > 0 ? 1 : 0;
    }


}

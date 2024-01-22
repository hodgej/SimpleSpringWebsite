package com.jackhodge.DataViewTool.service;

import com.jackhodge.DataViewTool.DataViewToolApplication;
import com.jackhodge.DataViewTool.model.Person;
import com.jackhodge.DataViewTool.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AppendService {
    PersonRepository repository;
    private static final Logger log = LoggerFactory.getLogger(DataViewToolApplication.class);

    public AppendService(PersonRepository repository){
        this.repository = repository;
    }

    public void addToDatabase(Person p){
        repository.save(p);
        log.info("Saved Person to Database: " + p);
    }
}

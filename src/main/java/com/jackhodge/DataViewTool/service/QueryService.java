package com.jackhodge.DataViewTool.service;

import com.jackhodge.DataViewTool.model.Person;
import com.jackhodge.DataViewTool.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QueryService {

    PersonRepository repository;

    public QueryService(PersonRepository repository){
        this.repository = repository;
    }
    public ArrayList<Person> performSearch(String query){
        ArrayList<Person> result = new ArrayList<>();
        // Business logic
        if(query.equals("*")){
            repository.findAll().forEach(result::add);
        } else {
            result.addAll(repository.findByLastName(query));
        }
        return result;
    }
}

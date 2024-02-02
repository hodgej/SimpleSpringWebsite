package com.jackhodge.DataViewTool.service;

import com.jackhodge.DataViewTool.model.Truckload;
import com.jackhodge.DataViewTool.repository.TruckloadRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QueryService {

    TruckloadRepository repository;

    public QueryService(TruckloadRepository repository){
        this.repository = repository;
    }
    public ArrayList<Truckload> performSearch(String query){
        ArrayList<Truckload> result = new ArrayList<>();
        // Business logic
        if(query.equals("*")){
            repository.findAll().forEach(result::add);
        } else {
            result.addAll(repository.findBySource(query));
        }
        return result;
    }
}

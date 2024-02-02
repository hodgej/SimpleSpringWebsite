package com.jackhodge.DataViewTool.service;

import com.jackhodge.DataViewTool.DataViewToolApplication;
import com.jackhodge.DataViewTool.model.Truckload;
import com.jackhodge.DataViewTool.repository.TruckloadRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppendService {
    TruckloadRepository repository;
    private static final Logger log = LoggerFactory.getLogger(DataViewToolApplication.class);

    public AppendService(TruckloadRepository repository){
        this.repository = repository;
    }

    // TODO: accurate response codes
    // Returns 1 by default regardless of state
    public int addToDatabase(Truckload t){
        repository.save(t);
        log.info("Saved Truckload to Database: " + t);

        return 1;
    }


    // Deletion Actions complete by the Service either report "1" (success) or "0" (failure)
    @Transactional
    public int removeFromDatabaseByDestination(String destination){
        long responseCode = repository.deleteByDestination(destination);
        return responseCode > 0 ? 1 : 0;
    }

    @Transactional
    public int removeFromDatabaseBySourceAndDestination(String source, String destination){
        long responseCode = repository.deleteBySourceAndDestination(source, destination);
        return responseCode > 0 ? 1 : 0;
    }


}

package com.jackhodge.DataViewTool.repository;

import com.jackhodge.DataViewTool.model.Truckload;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Spring automatically implements this during runtime


public interface TruckloadRepository extends CrudRepository<Truckload, Long> {

    // derived query
    List<Truckload> findBySource(String lastName);

    long deleteByDestination(String destination);
    long deleteBySourceAndDestination(String source, String destination);

    Truckload findById(long id);
}

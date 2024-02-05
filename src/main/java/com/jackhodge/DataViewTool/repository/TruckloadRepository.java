package com.jackhodge.DataViewTool.repository;

import com.jackhodge.DataViewTool.model.Truckload;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Spring automatically implements this during runtime


public interface TruckloadRepository extends CrudRepository<Truckload, Long> {

    // derived query
    @Transactional
    List<Truckload> findBySource(String lastName);

    @Transactional
    long deleteByDestination(String destination);
    @Transactional
    long deleteBySource(String source);
    @Transactional
    long deleteBySourceAndDestination(String source, String destination);

    Truckload findById(long id);
}

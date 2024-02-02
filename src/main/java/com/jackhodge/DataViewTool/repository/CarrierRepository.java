package com.jackhodge.DataViewTool.repository;

import com.jackhodge.DataViewTool.model.Carrier;
import org.springframework.data.repository.CrudRepository;

public interface CarrierRepository extends CrudRepository<Carrier, Long> {
    public Carrier findCarrierByCarrierid(Long id);
}

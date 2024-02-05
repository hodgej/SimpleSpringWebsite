package com.jackhodge.DataViewTool.service;

import com.jackhodge.DataViewTool.DataViewToolApplication;
import com.jackhodge.DataViewTool.model.Carrier;
import com.jackhodge.DataViewTool.model.PostTruckloadUpdateForm;
import com.jackhodge.DataViewTool.model.Truckload;
import com.jackhodge.DataViewTool.repository.CarrierRepository;
import com.jackhodge.DataViewTool.repository.TruckloadRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TruckloadAppendService {
    TruckloadRepository truckloadRepository;
    CarrierRepository carrierRepository;
    private static final Logger log = LoggerFactory.getLogger(DataViewToolApplication.class);

    public TruckloadAppendService(TruckloadRepository truckloadRepository, CarrierRepository carrierRepository){
        this.truckloadRepository = truckloadRepository;
        this.carrierRepository = carrierRepository;
    }

    // TODO: accurate response codes
    // Returns 1 by default regardless of state
    public String processTruckloadUpdateForm(PostTruckloadUpdateForm form){

        String responseDetails = "";
        int responseCode = 0;

        // Insert new Truckload
        if(form.getSelectUpdateMethod().equals("insert")){

            Optional<Carrier> associatedCarrierObject = Optional.of(carrierRepository.findCarrierByCarrierid(form.getCarrierid()));

            // TODO: Crashes if Carrier object not found
            if(associatedCarrierObject.isPresent()) {
                responseCode = addToDatabase(new Truckload(form.getSource(), form.getDestination(), associatedCarrierObject.get()));

            } else {
                responseDetails += "Error: No Such Carrier with carrierid" + form.getCarrierid() + " found. ";
            }

        } else { // Remove by...
            if(form.getDeleteby().equals("fullroute"))
                responseCode = removeFromDatabaseBySourceAndDestination(form.getSource(), form.getDestination());
                // Remove by source
            else responseCode = removeFromDatabaseByDestination(form.getDestination());
        }

        String statusText = responseCode == 1 ?
                "Database Action Successful. " : "Error: Failed to complete action. " + responseDetails;

        return statusText;
    }

    @Transactional
    public int addToDatabase(Truckload t){
        truckloadRepository.save(t);
        log.info("Saved Truckload to Database: " + t);

        return 1;
    }

    // Deletion Actions complete by the Service either report "1" (success) or "0" (failure)
    @Transactional
    public int removeFromDatabaseByDestination(String destination){
        long responseCode = truckloadRepository.deleteByDestination(destination);
        return responseCode > 0 ? 1 : 0;
    }

    @Transactional
    public int removeFromDatabaseBySourceAndDestination(String source, String destination){
        long responseCode = truckloadRepository.deleteBySourceAndDestination(source, destination);
        return responseCode > 0 ? 1 : 0;
    }


}

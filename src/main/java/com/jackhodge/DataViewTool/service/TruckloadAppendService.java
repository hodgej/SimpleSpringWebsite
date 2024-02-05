package com.jackhodge.DataViewTool.service;

import com.jackhodge.DataViewTool.DataViewToolApplication;
import com.jackhodge.DataViewTool.model.Carrier;
import com.jackhodge.DataViewTool.model.PostTruckloadUpdateForm;
import com.jackhodge.DataViewTool.model.Truckload;
import com.jackhodge.DataViewTool.repository.CarrierRepository;
import com.jackhodge.DataViewTool.repository.TruckloadRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.dao.DataAccessException;
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
            try {
                Carrier foundCarrier = carrierRepository.findCarrierByCarrierid(form.getCarrierid());
                if (foundCarrier != null) {
                    Optional<Carrier> associatedCarrierObject = Optional.of(foundCarrier);
                    Truckload truckloadObject = new Truckload(form.getSource(), form.getDestination(), associatedCarrierObject.get());
                    responseCode = addToDatabase(truckloadObject);
                } else {
                    responseDetails += "Warning: No Such Carrier with carrierid" + form.getCarrierid() + " found. ";
                }
            }
            catch (DataAccessException e){
                responseDetails += "DataAccessException Error: Truckload With Carrier ID " + form.getCarrierid() + ". Error log: " + e;
                }
        } else { // Remove by...
            String deleteBy = form.getDeleteby();
            responseCode = switch (deleteBy) {
                case "fullroute" -> removeFromDatabaseBySourceAndDestination(form.getSource(), form.getDestination());
                case "destination" -> removeFromDatabaseByDestination(form.getDestination());
                case "source" -> removeFromDatabaseBySource(form.getSource());
                default -> responseCode;
            };
        }

        String statusText = responseCode == 1 ?
                "Database Action Successful. " : "Error: Failed to complete action. " + responseDetails;

        log.info(statusText);
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


    @Transactional
    public int removeFromDatabaseBySource(String source){
        long responseCode = truckloadRepository.deleteBySource(source);
        return responseCode > 0 ? 1 : 0;
    }


}

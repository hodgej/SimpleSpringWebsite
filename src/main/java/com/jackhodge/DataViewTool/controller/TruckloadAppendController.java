package com.jackhodge.DataViewTool.controller;


import com.jackhodge.DataViewTool.DataViewToolApplication;
import com.jackhodge.DataViewTool.model.Carrier;
import com.jackhodge.DataViewTool.model.Truckload;
import com.jackhodge.DataViewTool.model.PostTruckloadUpdateForm;
import com.jackhodge.DataViewTool.repository.CarrierRepository;
import com.jackhodge.DataViewTool.service.AppendService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Controller
public class TruckloadAppendController {

    AppendService service;
    CarrierRepository carrierRepository;

    @Autowired
    public TruckloadAppendController(AppendService service, CarrierRepository carrierRepository){
        this.service = service;
        this.carrierRepository = carrierRepository;
    }

    @RequestMapping("/updatehub")
    public String updateHub(){
        return "updatehub";
    }

    @PostMapping("/update")
    public String append(@ModelAttribute PostTruckloadUpdateForm form, Model model){
        Logger log = LoggerFactory.getLogger(DataViewToolApplication.class);
        log.info(form.toString());

        String responseDetails = "";
        int responseCode = 0;

        // Insert new Truckload
        if(form.getSelectupdatemethod().equals("insert")){

            Optional<Carrier> associatedCarrierObject = Optional.of(carrierRepository.findCarrierByCarrierid(form.getCarrierid()));

            if(associatedCarrierObject.isPresent()) {
                responseCode = service.addToDatabase(new Truckload(form.getSource(), form.getDestination(), associatedCarrierObject.get()));
            } else {
                responseDetails += "Error: No Such Carrier with carrierid" + form.getCarrierid() + " found. ";
            }

        } else { // Remove by...
            if(form.getDeleteby().equals("fullroute"))
                responseCode = service.removeFromDatabaseBySourceAndDestination(form.getSource(), form.getDestination());
            // Remove by source
            else responseCode = service.removeFromDatabaseByDestination(form.getDestination());
        }

        String statusText = responseCode == 1 ?
                            "Database Action Successful. " : "Error: Failed to complete action. " + responseDetails;

        model.addAttribute("statusResponse", statusText);
        return "updatehub";
    }


}

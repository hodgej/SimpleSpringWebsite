package com.jackhodge.DataViewTool.controller;


import com.jackhodge.DataViewTool.DataViewToolApplication;
import com.jackhodge.DataViewTool.model.Carrier;
import com.jackhodge.DataViewTool.model.Truckload;
import com.jackhodge.DataViewTool.model.PostTruckloadUpdateForm;
import com.jackhodge.DataViewTool.repository.CarrierRepository;
import com.jackhodge.DataViewTool.service.TruckloadAppendService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Controller
public class TruckloadAppendController {

    TruckloadAppendService service;
    CarrierRepository carrierRepository;

    @Autowired
    public TruckloadAppendController(TruckloadAppendService service, CarrierRepository carrierRepository){
        this.service = service;
        this.carrierRepository = carrierRepository;
    }

    @RequestMapping("/updatehub")
    public String updateHub(){
        return "updatehub";
    }

    @PostMapping("/update")
    public String append(@ModelAttribute PostTruckloadUpdateForm form, Model model){
        String statusText = service.processTruckloadUpdateForm(form);
        model.addAttribute("statusResponse", statusText);
        return "updatehub";
    }


}

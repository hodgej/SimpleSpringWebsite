package com.jackhodge.DataViewTool.controller;


import com.jackhodge.DataViewTool.DataViewToolApplication;
import com.jackhodge.DataViewTool.model.Person;
import com.jackhodge.DataViewTool.model.PostUpdateForm;
import com.jackhodge.DataViewTool.service.AppendService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class AppendController {

    AppendService service;

    @Autowired
    public AppendController(AppendService service){
        this.service = service;
    }


    @RequestMapping("/updatehub")
    public String updateHub(){
        return "updatehub";
    }

    @PostMapping("/update")
    public String append(@ModelAttribute PostUpdateForm form, Model model){
        Logger log = LoggerFactory.getLogger(DataViewToolApplication.class);
        log.info(form.toString());

        Integer responseCode = 0;

        // Insert new Person
        if(form.selectupdatemethod.equals("insert")){
            responseCode = service.addToDatabase(new Person(form.firstName, form.lastName));
        } else { // Remove by...
            if(form.deleteby.equals("fulln")) // remove by fullname
                responseCode = service.removeFromDatabaseByFullName(form.firstName, form.lastName);
            // Remove by Last Name
            else responseCode = service.removeFromDatabaseByLastname(form.lastName);
        }

        String statusText = responseCode == 1 ?
                            "Database Action Successful" : "Failed to complete action";

        model.addAttribute("statusResponse", statusText);
        return "updatehub";
    }


}

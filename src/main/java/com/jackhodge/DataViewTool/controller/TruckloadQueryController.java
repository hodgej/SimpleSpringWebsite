package com.jackhodge.DataViewTool.controller;

import com.jackhodge.DataViewTool.model.Truckload;
import com.jackhodge.DataViewTool.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;


@Controller
public class TruckloadQueryController {


    QueryService service;

    // Autowire query service to be injected here
    @Autowired
    public TruckloadQueryController(QueryService queryService){
        this.service = queryService;
    }


    @GetMapping("/queryhub")
    public String queryHub(){
        return "queryhub";
    }

    @GetMapping("/query")
    public String search(@RequestParam String query, @RequestParam Optional<String> showui, Model model){
        ArrayList<Truckload> queryResult = service.performSearch(query);
        model.addAttribute("items", queryResult);
        model.addAttribute("orig_query", query);

        // Adjust UI based on request
        if(showui.isPresent()){
            model.addAttribute("ui_status", false);
        } else model.addAttribute("ui_status", true);

        return "query_result";
    }
}

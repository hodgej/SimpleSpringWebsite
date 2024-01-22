package com.jackhodge.DataViewTool.controller;


import com.jackhodge.DataViewTool.model.Person;
import com.jackhodge.DataViewTool.service.AppendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AppendController {

    AppendService service;

    @Autowired
    public AppendController(AppendService service){
        this.service = service;
    }

    @RequestMapping("/append")
    public String append(@RequestParam String firstName, @RequestParam String lastName){
        service.addToDatabase(new Person(firstName, lastName));
        return "redirect:/";
    }


}

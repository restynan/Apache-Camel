package com.example.simplespringapi.controller;

import com.example.simplespringapi.Service.CurrentTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrentTimeController {
    @Autowired
    CurrentTimeService currentTimeService;

@RequestMapping(value = "/currentDateTime")
    public String getCurrentTime(){

        return currentTimeService.getCurrentDateAndTime();
    }
}

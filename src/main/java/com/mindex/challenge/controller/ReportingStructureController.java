package com.mindex.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.service.ReportingStructureService;
import com.mindex.challenge.data.ReportingStructure;;

@RestController
public class ReportingStructureController {
    @Autowired
    private ReportingStructureService ReportingStructureService;


    @GetMapping("/reportingStructure/{id}")
    public ReportingStructure read(@PathVariable String id) {
        System.out.println("DO THIS SHIT RIGHT HERE");
        return ReportingStructureService.read(id);
    }
}

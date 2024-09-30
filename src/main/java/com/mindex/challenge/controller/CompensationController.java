/**
 * @author Akhil Devarapalli
 * This is the compensation controller class. This class
 * has methods to interact with request sent to the spring
 * server and uses the service classes in order to create
 * new compensation objects and store compensation information
 * in the MongoDB database. 
 */
package com.mindex.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private CompensationService compService;

    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation) {
        LOG.debug("Received compensation create request for [{}]", compensation);
        return  compService.create(compensation);
    }

    @GetMapping("/compensation/{employeeID}")
    public Compensation read(@PathVariable String employeeID) {
        LOG.debug("Getting the compensation infomration of ", employeeID);
        return compService.read(employeeID);
    }
}

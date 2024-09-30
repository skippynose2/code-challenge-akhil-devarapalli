/**
 * @author Akhil Devarapalli
 * This is the reporting structure controller class. It has
 * the ability to interact with the reporting strucutre pathing,
 * create a reporting structure class using the reporting structure
 * service and be able to return the reporting structure along with
 * total reports. 
 */
package com.mindex.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);



    @GetMapping("/reportingStructure/{id}")
    public ReportingStructure read(@PathVariable String id) {
        LOG.debug("Creating the reporting structure for ", id);
        return ReportingStructureService.read(id);
    }
}

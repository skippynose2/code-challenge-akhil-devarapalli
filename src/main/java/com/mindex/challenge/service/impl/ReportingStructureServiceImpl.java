/**
 * @author Akhil Devarapalli
 * This is the reporting structure service class. It implements the
 * ReportingStructure interface. It has the implementation to communicate
 * with the reporting strucutre class and also get infomration from the
 * employee service class.
 */
package com.mindex.challenge.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ReportingStructureService reportingStructureService;

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public ReportingStructure read(String employeeId) {

        LOG.debug("Reading the reporting strcuture for ", employeeId);

        Employee employee = employeeService.read(employeeId);

        int totalReports = employeeService.numberOfReports(employeeId);

        ReportingStructure reports = new ReportingStructure(employee, totalReports);

        return reports;

    }
    
}

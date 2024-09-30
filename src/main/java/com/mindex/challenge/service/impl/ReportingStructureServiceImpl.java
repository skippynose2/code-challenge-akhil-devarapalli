package com.mindex.challenge.service.impl;

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

    @Override
    public ReportingStructure read(String employeeId) {

        Employee employee = employeeService.read(employeeId);

        int totalReports = employeeService.numberOfReports(employeeId);

        ReportingStructure reports = new ReportingStructure(employee, totalReports);

        return reports;

    }
    
}

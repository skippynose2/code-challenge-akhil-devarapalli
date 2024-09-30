package com.mindex.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;

@Service
public class CompensationServiceImpl implements CompensationService{
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompensationRepository compRepository;

    @Override
    public Compensation create(Compensation compensation) {
        Employee employee = employeeService.read(compensation.getEmployee().getEmployeeId());
        compensation.setEmployee(employee);
        compRepository.insert(compensation);

        return compensation;
    }


    @Override
    public Compensation read(String employeeID) {
        Employee employee = employeeService.read(employeeID);

        Compensation compensation = compRepository.findByEmployee(employee);

        if (compensation == null) {
            throw new RuntimeException("No compensation record found for employeeID: " + employeeID);
        }


        return compensation;
    }

}
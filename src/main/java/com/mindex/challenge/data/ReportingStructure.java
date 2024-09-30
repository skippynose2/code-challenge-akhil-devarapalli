/**
 * @author Akhil Devarapalli
 * This is the Reporting structure class. It has getter and setter methods
 * for the different fields of the reporting structure. It also has a equals
 * method and a hash method to determine if a different instance of the class
 * is equal to the current one. 
 */
package com.mindex.challenge.data;

import java.util.Objects;

import org.springframework.data.annotation.Id;

public class ReportingStructure {
    @Id
    private Employee employee;
    private int numberOfReports;
    
    public ReportingStructure (Employee currentEmployee, int numberOfReports) {
        this.employee = currentEmployee;
        this.numberOfReports = numberOfReports;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee newEmployee) {
        this.employee = newEmployee;
    }

    public int getReports() {
        return this.numberOfReports;
    }

    public void setReports(int newNumberOfReports) {
        this.numberOfReports = newNumberOfReports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // If both references point to the same object
        if (o == null || getClass() != o.getClass()) return false;  // Check class type
        
        ReportingStructure that = (ReportingStructure) o;  // Cast to the proper type
        
        // Compare fields for equality
        return numberOfReports == that.numberOfReports &&
               Objects.equals(employee, that.employee);  // Use equals() on employee (which should also override equals())
    }

    @Override
    public int hashCode() {
        // Generate hash code using fields
        return Objects.hash(employee, numberOfReports);
    }

}

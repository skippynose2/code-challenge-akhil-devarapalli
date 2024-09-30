/**
 * @author Akhil Devarapalli
 * This is the compensation class. It has getter and setter methods
 * for the different fields of the compensation strcuture. It also has a equals
 * method and a hash method to determine if a different instance of the class
 * is equal to the current one. 
 */
package com.mindex.challenge.data;

import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class Compensation {

    @DBRef(lazy = true)
    private Employee employee;
    private double salary;
    private String effectiveDate;

    public Compensation() {

    }

    public void setSalary (double salary) {
        this.salary = salary;
    }

    public void setEffectiveDate (String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public void setEmployee (Employee employee) {
        this.employee = employee;
    }

    public double getSalary () {
        return this.salary;
    }

    public String getEffectiveDate () {
        return this.effectiveDate;
    }

    public Employee getEmployee () {
        return this.employee;
    }    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // If both references point to the same object
        if (o == null || getClass() != o.getClass()) return false;  // Check class type
        
        Compensation that = (Compensation) o;  // Cast to the proper type
        
        // Compare fields for equality
        return salary == that.salary &&
               Objects.equals(employee, that.employee);  // Use equals() on employee (which should also override equals())
    }

    @Override
    public int hashCode() {
        // Generate hash code using fields
        return Objects.hash(employee, salary);
    }

}

package com.practice.dataTest.web.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddNewEmployeeCred {
    private String firstName;
    private String lastName;
    private String middleName;
    private String employeeId;

    @Override
    public String toString() {
        return "AddNewEmployeeCred{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}

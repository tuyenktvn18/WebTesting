package com.practice.dataTest.web.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdatePersonalDetailsCred {
    private String firstName;
    private String lastName;
    private String middleName;
    private String employeeId;
    private String nationality;
    private String maritalStatus;
    private String dateOfBirth;
    private String smoker;
    private String gender;

}

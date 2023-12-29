package com.practice.dataTest.web.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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

    public List<String> getVerifyUIList(){
        List<String> verifyUIList = new ArrayList<>();
        verifyUIList.add(getFirstName());
        verifyUIList.add(getMiddleName());
        verifyUIList.add(getLastName());
        verifyUIList.add(getNationality());
        return verifyUIList;
    }
}

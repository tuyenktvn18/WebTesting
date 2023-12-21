package com.practice.enums.pages;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum LeftMenuEnums {
    ADMIN("Admin"),
    PIM("PIM"),
    LEAVE("Leave"),
    TIME("Time"),
    RECRUITMENT("Recruitment"),
    MY_INFO("My Info"),
    PERFORMANCE("Performance"),
    DASHBOARD("Dashboard"),
    DIRECTORY("Directory"),
    MAINTENANCE("Maintenance"),
    CLAIM("Claim"),
    BUZZ("Buzz");


    private final String name;

    public String getName() {
        return name;
    }

    LeftMenuEnums(String name) {
        this.name = name;
    }

    public static final List<String> MenuTypeNames = Collections.unmodifiableList(Arrays
            .stream(LeftMenuEnums.values())
            .map(LeftMenuEnums::getName)
            .collect(Collectors.toList()));
}

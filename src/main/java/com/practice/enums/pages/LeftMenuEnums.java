package com.practice.enums.pages;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum LeftMenuTypeEnums {
    ADMIN("Admin"),
    PIM("PIM"),
    LEAVE("Leave"),
    TIME("Time"),
    RECRUITMENT("Recruitment"),
    MY_INFO("My Info"),
    DASHBOARD("Dashboard");

    private final String name;

    public String getName() {
        return name;
    }

    LeftMenuTypeEnums(String name) {
        this.name = name;
    }

    public static final List<String> MenuTypeNames = Collections.unmodifiableList(Arrays
            .stream(LeftMenuTypeEnums.values())
            .map(LeftMenuTypeEnums::getName)
            .collect(Collectors.toList()));
}

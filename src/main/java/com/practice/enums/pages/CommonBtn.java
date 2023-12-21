package com.practice.enums.pages;

public enum CommonBtn {
    SAVE("Save"),
    ADD("Add"),
    CANCEL("Cancel"),
    SEARCH("Search");

    private final String btnName;

    public String getBtnName() {
        return btnName;
    }

    CommonBtn(String btnName) {
        this.btnName = btnName;
    }
}

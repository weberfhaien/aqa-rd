package com.epam.enumeration;

public enum ControllerPath {

    GET_BASE_URL("https://reqres.in"),
    GET_LIST_USERS("/api/users"),
    GET_SINGLE_USER("/api/users/{user_id}");

    private String path;

    ControllerPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}

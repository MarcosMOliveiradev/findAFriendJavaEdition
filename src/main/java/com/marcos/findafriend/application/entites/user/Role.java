package com.marcos.findafriend.application.entites.user;

public enum Role {
    USER("user"),
    ADMIN("admin"),
    ONG("ong");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

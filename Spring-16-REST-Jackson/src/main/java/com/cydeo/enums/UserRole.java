package com.cydeo.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserRole {

    @JsonProperty("Admin")
    ADMIN,
    @JsonProperty("User")
    USER
}

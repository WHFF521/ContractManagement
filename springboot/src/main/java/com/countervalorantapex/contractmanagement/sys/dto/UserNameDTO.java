package com.countervalorantapex.contractmanagement.sys.dto;

import lombok.Data;

@Data
public class UserNameDTO {
    private String name;

    public UserNameDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package com.countervalorantapex.contractmanagement.sys.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String userAccount;
    private String userName;
    private int userRole;
    private String token;
}
package com.countervalorantapex.contractmanagement.sys.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_account", nullable = false)
    private String userAccount;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_phone", nullable = false)
    private String userPhone;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_role", nullable = false)
    private int userRole;

    public Users() {
    }

    public Users(String userAccount, String userPassword, String userName, String userPhone, String userEmail, int userRole) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userRole = userRole;
    }

    // Getters and Setters

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

}
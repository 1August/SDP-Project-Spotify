package com.company.FacadePattern;

public class AccountPasswordChecker {
    private String password = "1234";

    public String getAccountPassword(){
        return password;
    }

    public boolean accountPasswordCorrect(String passwordToCheck) {
        if(passwordToCheck==getAccountPassword()){
            return true;
        }
        else{
            return false;
        }
    }
}

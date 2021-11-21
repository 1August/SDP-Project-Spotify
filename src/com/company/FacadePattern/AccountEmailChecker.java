package com.company.FacadePattern;

import com.company.Entities.Subscriber;

public class AccountEmailChecker {

    private String email = "User1@gmail.com";


    public String getAccountEmail() {
        return email;
    }
    public boolean accountEmailValid(String emailToCheck) {
        if(emailToCheck==getAccountEmail()){
            return true;
        }
        else{
            return false;
        }
    }
}

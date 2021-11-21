package com.company.FacadePattern;

public class SpotifyAccount {
    private String email;
    private String password;

    AccountEmailChecker emailChecker;
    AccountPasswordChecker passwordChecker;
    AccountBalanceChecker balanceChecker;

    public SpotifyAccount(String newEmail, String newPassword){
        email = newEmail;
        password = newPassword;

        emailChecker = new AccountEmailChecker();
        passwordChecker = new AccountPasswordChecker();
        balanceChecker = new AccountBalanceChecker();
    }

    public String getEmail(){return email;}
    public String getPassword(){return password;}

    public void purchaseMoney(double moneyToBuy){
        if(emailChecker.accountEmailValid(getEmail())
                && passwordChecker.accountPasswordCorrect(getPassword())
                && balanceChecker.haveEnoughMoney(moneyToBuy)){
            System.out.println("Purchase complete\n");
        }
        else{
            System.out.println("Purchase failed\n");
        }
    }
    public void addMoney(double moneyToAdd){
        if(emailChecker.accountEmailValid(getEmail())&&passwordChecker.accountPasswordCorrect(getPassword())){
            balanceChecker.addMoneyToAccount(moneyToAdd);
            System.out.println("Transaction complete\n");
        }
        else{
            System.out.println("Transaction failed\n");
        }
    }
}

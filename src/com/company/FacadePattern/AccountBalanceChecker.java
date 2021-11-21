package com.company.FacadePattern;

public class AccountBalanceChecker {
    private double money = 10;
    public double getMoney() { return money; }
    public void decreaseMoney(double moneyToPurchase){
        money -= moneyToPurchase;
    }
    public void increaseMoney(double moneyForInserting){
        money += moneyForInserting;
    }

    public boolean haveEnoughMoney(double purchaseMoney) {
        if(purchaseMoney > getMoney()){
            System.out.println("You do not have enough money");
            System.out.println("Current balance: $" + getMoney());
            return false;
        }
        else{
            decreaseMoney(purchaseMoney);
            System.out.println("Purchase completed successfully! Enjoy:)");
            System.out.println("Your current balance: $" + getMoney());
            return true;
        }
    }
    public void addMoneyToAccount(double moneyToInsert){
        increaseMoney(moneyToInsert);
        System.out.println("You successfully added $"+ moneyToInsert + " into your balance!");
        System.out.println("Your current balance: $" + getMoney());
    }
}

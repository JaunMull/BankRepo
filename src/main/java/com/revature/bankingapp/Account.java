package com.revature.bankingapp;

public class Account {
    public int id;
    public int savAcc;
    public int checkAcc;
    public int accNum;
    int deposit;
    int withdraw;

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(int withdraw) {
        this.withdraw = withdraw;
    }

    public Account() {
    }

    public Account(int id, int savAcc, int checkAcc, int accNum) {
        this.id = id;
        this.savAcc = savAcc;
        this.checkAcc = checkAcc;
        this.accNum = accNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSavAcc() {
        return savAcc;
    }

    public void setSavAcc(int savAcc) {
        this.savAcc = savAcc;
    }

    public int getCheckAcc() {
        return checkAcc;
    }

    public void setCheckAcc(int checkAcc) {
        this.checkAcc = checkAcc;
    }

    public int getAccNum() {
        return accNum;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public Account(int checkAcc) {
        this.checkAcc = checkAcc;
    }
}

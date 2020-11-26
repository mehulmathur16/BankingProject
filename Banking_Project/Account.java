package banking;

abstract class Account{

    float balance;
    private String accountNo;

    Account(float balance,String accountNo){
        this.balance = balance;
        this.accountNo = accountNo;
    }

    void setBalance(float balance){
        this.balance = balance;
    }

    float getBalance(){
        return balance;
    }

    void setAccountNo(String accountNo){
        this.accountNo = accountNo;
    }

    String getAccountNo(){
        return accountNo;
    }

    abstract void debit(float amount);
    abstract void credit(float amount);

    void display(){
        System.out.println("Account Number: " + accountNo);
        System.out.println("Account Balance: " + balance);
    }
}
package banking;

class SavingAccount extends Account{

    static float interest = 4f;

    SavingAccount(){
        super(0,"");
    }

    SavingAccount(float balance, String accountNo){
        super(balance,accountNo);
    }

    static void setInterest(float inter){
        interest = inter;
    }

    float getInterest(){
        return interest;
    }

    public void credit(float amount){
        System.out.println("Amount to be credited: " + amount);
        System.out.println("Old balance: " + balance);
        balance += amount; 
        System.out.println("New balance: " + balance);
    }

    public void debit(float amount){
        System.out.println("Amount to be debited: " + amount);
        System.out.println("Old balance: " + balance);

        if(amount > balance)
            System.out.println("Request Denied.");
        else{
            balance -= amount;
            System.out.println("New balance: " + balance);
        }
    }

    public void creditInterest(){
        float interestPaid = balance * interest / 100;
        System.out.println("Interest Paid: " + interestPaid);
        balance += interestPaid; 
        System.out.println("New balance: " + balance);
    }

    public String toString(){
        return "Saving Account No." + getAccountNo() + " balance is : " + balance;
    }
    
}
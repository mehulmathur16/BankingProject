package banking;

class CurrentAccount extends Account{

    float overDraftBorrowed;
    float overDraftLimit;

    CurrentAccount(){
        super(0,"");
    }

    CurrentAccount(float balance, String accountNo , float overDraftBorrowed){
        super(balance,accountNo);
        this.overDraftBorrowed = overDraftBorrowed;
    }

    void setOverDraftBorrowed(float overDraftBorrowed){
        this.overDraftBorrowed = overDraftBorrowed;
    }

    float getOverDraftBorrowed(){
        return overDraftBorrowed;
    }

    void setOverDraftLimit(float overDraftLimit){
        this.overDraftLimit = overDraftLimit;
    }

    float getOverDraftLimit(){
        return overDraftLimit;
    }

    public void credit(float amount){
        System.out.println("Amount to be credited: " + amount);
        System.out.println("Old balance: " + balance);
        System.out.println("Overdraft Borrowed: " + overDraftBorrowed);

        if(amount > overDraftBorrowed){
            amount -= overDraftBorrowed;
            overDraftBorrowed = 0;
            balance += amount;
        }
        else if(overDraftBorrowed > amount){
            overDraftBorrowed -= amount;
        }
         
        System.out.println("New Overdraft Borrowed: " + overDraftBorrowed);
        System.out.println("New balance: " + balance);       
    }

    public void debit(float amount){
        System.out.println("Amount to be debited: " + amount);
        System.out.println("Old balance: " + balance);

        if(amount <= balance){
            balance -= amount;
        }
        else if((balance < amount) && ((balance + overDraftBorrowed) > amount)){
            overDraftBorrowed = amount - balance;
            balance = 0;
            System.out.println("Overdraft Borrowed: " + overDraftBorrowed);    
        }
        else
            System.out.println("Request Denied.");
         
        System.out.println("Overdraft Borrowed: " + overDraftBorrowed);
        System.out.println("New balance: " + balance);
    }

    public void display(){
        super.display();
        System.out.println("Overdraft Limit: " + overDraftLimit);
    }

    public String toString(){
        return "Current Account No." + getAccountNo() + " balance is : " + balance + " overdraft limit: " + overDraftLimit;
    }
}
package banking;

class Customer{
    String customerName;
    String customerId;

    private Account account;

    Customer(String customerName , String customerId , Account account){
        this.customerName = customerName;
        this.customerId = customerId;
        this.account = account;
    }

    public void deposit(float amount){

        if(account instanceof SavingAccount)
        {
            ((SavingAccount)account).credit(amount);
        }
        else if(account instanceof CurrentAccount){
            ((CurrentAccount)account).credit(amount);
        }
    }

    public void depositInterest()
    {
        System.out.println("Deposit Interest in: " + customerId);

        if(account instanceof SavingAccount)
            ((SavingAccount)account).creditInterest();
    }

    public void withdrawal(float amount)
    {
        if(account instanceof SavingAccount)
        {
            ((SavingAccount)account).debit(amount);
        }
        else if(account instanceof CurrentAccount)
        {
            ((CurrentAccount)account).debit(amount);
        }
    }

    public void display()
    {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer ID: " + customerId);
        account.display();
        System.out.println(account);
    }

    float returnBalance() {
		return account.balance;
	}
}
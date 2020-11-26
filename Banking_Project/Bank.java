package banking;

import java.util.Scanner;

public class Bank {

    static Scanner sc = new Scanner(System.in);
    private static Customer savAccount[] = new Customer[100];
    private static Customer currAccount[] = new Customer[100];
    static int size1 = 0;
    static int size2 = 0;

    static void changeInterestRate(float interest)
    {
         SavingAccount.setInterest(interest);
    }

    public static void isExcceding(float A, float B) throws WithdrawAmountExceedBalance {
		
		if(A > B) {
			throw new WithdrawAmountExceedBalance();
		}
	}

    public static void main(String[] args) {
        
        //Bank bank = new Bank();
        mainmenu();
    }

    static void mainmenu(){
        String acc = "current";
        
        while(true)
        {   
            System.out.println();
            System.out.println("***** MAIN MENU *****");
            System.out.println("1. Current Account");
            System.out.println("2. Saving Account");
            System.out.println("3. Exit");
            System.out.println();
            
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            System.out.println();

            switch(choice)
            {
                case 1 :    System.out.println("**** Creating Current Account ****");
                            innerMenu(acc);
                            break;

                case 2 :    System.out.println("**** Creating Saving Account ****");
                            acc = "saving";            
                            innerMenu(acc);
                            break;
                
                case 3 :    System.exit(0);
                default:    System.out.println("Invalid Choice Entered.");
            }
        }
    }

    static void getAccountDetails(String acc){
        
        System.out.println("---- Enter the details of Customer ----");
        System.out.print("Enter Customer Name : ");
        String customerName = sc.next();
        System.out.print("Enter Customer Id : ");
        String customerId = sc.next();
        System.out.print("Enter Balance : ");
        float balance = sc.nextFloat();
        System.out.print("Enter Account Number : ");
        String accountNo = sc.next();

        if(acc == "current")
        {
            System.out.print("Enter OverDraft Amount : ");
            float overdraftAmount = sc.nextFloat();
            currAccount[size1++] = new Customer(customerName , customerId , new CurrentAccount(balance , accountNo , overdraftAmount));
        }
        else
        {
            savAccount[size2++] = new Customer(customerName , customerId , new SavingAccount(balance , accountNo));
        }    
    }


    static void innerMenu(String acc){
        
        while(true){
            
            System.out.println();
            System.out.println("***** INNER MENU *****");
            System.out.println("1. Create Account");
            System.out.println("2. Check Account Status (Existing Customer)");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Deposit Amount");
            System.out.println("5. Go Back to Previous Menu");
            System.out.println("6. Exit");
            System.out.println();

            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            System.out.println();

            switch(choice)
            {
                    case 1 :    System.out.println("**** Creating New Customer Account ****");
                                System.out.println();
                                getAccountDetails(acc);
                                break;

                    case 2 :    System.out.println("Wait Searching For Your Account....\n");
                                if(acc == "current")
                                {
                                    int index = searchInCurrentAccount();
                                    if(index == -1){
                                        System.out.println(" Account DOSEN'T EXIST, Please Create one !");
                                    }
                                    else{
                                        System.out.println("---- Current Account Found ----");
                                        currAccount[index].display();
                                    }
                                }
                                else{
                                
                                    int index = searchInSavingAccount();
                                    if(index == -1){
                                        System.out.println(" Account DOSEN'T EXIST, Please Create one !");
                                    }
                                    else{
                                        System.out.println();
                                        System.out.println("---- Saving Account Found ----");
                                        savAccount[index].display();
                                        System.out.println();
                                    }
                                }
                                break;
                    
                    case 3 :    System.out.println("WITHDRAW Amount....\n");
                                if(acc == "current")
                                {
                                    int index = searchInCurrentAccount();
                                    if(index == -1){
                                        System.out.println(" Account DOSEN'T EXIST, Please Create one !");
                                    }
                                    else{
                                        System.out.println("---- Current Account Found ----");
                                        System.out.print("Enter the amount to be  WITHDRAWN :");
                                        float amount = sc.nextFloat();

                                        try{
                                            float b = currAccount[index].returnBalance();
					                        isExcceding(amount, b);
                                            currAccount[index].withdrawal(amount);
                                        }

                                        catch(Exception e) {
                                            System.out.println("\n--AMOUNT TO BE WITHDRAWN IS EXCEEDING BALANCE !");
                                            
                                        }

                                    }
                                }
                                else{
                                    
                                    int index = searchInSavingAccount();
                                    if(index == -1){
                                        System.out.println(" Account DOSEN'T EXIST, Please Create one !");
                                    }
                                    else{
                                        System.out.println("---- Saving Account Found ----");
                                        System.out.print("Enter the amount to be  WITHDRAWN :");
                                        float amount = sc.nextFloat();

                                        try{
                                            float b = savAccount[index].returnBalance();
					                        isExcceding(amount, b);
                                            savAccount[index].withdrawal(amount);
                                        }

                                        catch(Exception e) {
                                            System.out.println("\n--AMOUNT TO BE WITHDRAWN IS EXCEEDING BALANCE !");    
                                        }
                                        
                                        System.out.println();
                                    }
                                    
                                }
                                break;

                    case 4 :    System.out.println("DEPOSIT Amount....\n");
                                if(acc == "current")
                                {
                                    int index = searchInCurrentAccount();
                                    if(index == -1){
                                        System.out.println(" Account DOSEN'T EXIST, Please Create one !");
                                    }
                                    else{
                                        System.out.println("---- Current Account Found ----");
                                        System.out.print("Enter the amount you want to DEPOSIT : ");
                                        float amount = sc.nextFloat();
                                        currAccount[index].deposit(amount);
                                    }
                                }
                                else{
                                    
                                    int index = searchInSavingAccount();
                                    if(index == -1){
                                        System.out.println(" Account DOSEN'T EXIST, Please Create one !");
                                    }
                                    else{
                                        System.out.println("---- Saving Account Found ----");
                                        System.out.print("Enter the amount you want to DEPOSIT : ");
                                        float amount = sc.nextFloat();
                                        savAccount[index].deposit(amount);
                                        System.out.println();
                                    }                                    
                                }
                                break;

                    case 5 :    mainmenu();
                                break;

                    case 6 :    System.exit(0);
                                break;

                    default:    System.out.println("Invalid Choice Entered.");
            }
        }
        
    }

    public static int searchInCurrentAccount(){
        //System.out.println(size1);
        System.out.println("---- Enter the Details of the Customer ----");
        System.out.print("Enter Customer Id : ");
        String cId = sc.next();
        for(int k=0 ; k<size1 ; k++)
        {   
            //System.out.println(currAccount[k].customerName);
            if( (currAccount[k].customerId).equals(cId))
                return k;
        }

        return -1;
    }

    public static int searchInSavingAccount(){
        //System.out.println(size2);
        System.out.println("---- Enter the Details of the Customer ----");
        System.out.print("Enter Customer Id : ");
        String cId = sc.next();
        for(int k=0 ; k<size2 ; k++)
        {   
            //System.out.println(currAccount[k].customerName);
            if( (savAccount[k].customerId).equals(cId))
                return k;
        }

        return -1;
    }
}
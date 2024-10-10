public class BankAccount {
    private double cheakingBalnace;
    private double savingsBalance;
    private static int member; 
    private static double member1; 
    private double total;
  

    public BankAccount() {
      this.cheakingBalnace = 0;
      this.savingsBalance = 0;
      member += 1;
      member1 = this.cheakingBalnace + this.savingsBalance;
    }
  
    // Create a getter method for the user's checking account balance.
  
    public void getCheckingBalance() {
      System.out.println(cheakingBalnace);
    }
  
    // Create a getter method for the user's saving account balance.
    public void getSavingsAccount() {
      System.out.println(savingsBalance);
    }
  
    public void chooseAccount() {
      System.out.println("Choose Your bank account type :");
      System.out.println("1: Savings Account ");
      System.out.println("other: Checking Account");
    }

    public double depositMoney(double money, int accountType) {
      if (accountType == 1) {
        cheakingBalnace += money;
      } else {
        savingsBalance += money;
      }
      total = cheakingBalnace + savingsBalance;
      return total;
    }
  
    public void withdraw(double money, int accountType) {
  
      if (cheakingBalnace + savingsBalance < money || cheakingBalnace < 0 || savingsBalance < 0) {
        System.out.println("Sorry,  insufficient funds! ");
      } else {
        if (accountType == 1) {
          cheakingBalnace -= money;
        } else {
          savingsBalance -= money;
        }
        total = cheakingBalnace + savingsBalance;
      }
    }
  
    public double balance() {
      return cheakingBalnace + savingsBalance;
    }
  
  }
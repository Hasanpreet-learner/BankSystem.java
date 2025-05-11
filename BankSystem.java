import java.util.Scanner;

class BankAccount {
    String name;
    int accNumber;
    double balance;

    BankAccount(String name, int accNumber, double balance){
        this.name = name;
        this.accNumber = accNumber;
        this.balance = balance;
    }

    void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited : " + amount);
            System.out.println("Updated Balance : " + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdrawn : " + amount);
            System.out.println("Updated Balance : " + balance);
        } else if(amount > balance){
            System.out.println("Insufficient Funds");
        } else {
            System.out.println("Invalid Withdrawal Amount");
        }
    }

    void checkBalance(){
        System.out.println("Your Account Balance : " + balance);
    }
}

public class BankSystem {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        BankAccount account = new BankAccount("John Doe", 1001, 5000.0);

        while(true){
            System.out.println("\nBank Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Enter amount to be deposited: ");
                    double depositAmount = input.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = input.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    System.out.println("Exiting. Thank you!");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

import java.util.Random;
import java.awt.*;
import java.lang.Math;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("This is a simple Bank Account Model Design in Java.");
        System.out.println("You will be able to make deposit, withdraw money and check balance.");
        System.out.println("");

        System.out.println("Add Account Number: ");
        Scanner input = new Scanner(System.in);
        int inputNum = input.nextInt();

        System.out.println("Make a deposit: ");
        input = new Scanner(System.in);
        int inputDepo = input.nextInt();

        Bank_Account new_account = new Bank_Account(inputNum,inputDepo);

        System.out.println("Please follow the options below.");
        System.out.println("1. Make a deposit.");
        System.out.println("2. Check balance.");
        System.out.println("3. Withdraw money.");

        input = new Scanner(System.in);
        int options = input.nextInt();
        if (options == 1) {
            System.out.println("How much do you want to deposit?");
            input = new Scanner(System.in);
            inputDepo = input.nextInt();
            new_account.deposit(inputDepo);

        } else if (options == 2) {
            new_account.balance(inputNum);

        } else if (options == 3) {
            System.out.println("How much do you want to withdraw?");
            input = new Scanner(System.in);
            int inputWithdraw = input.nextInt();
            new_account.withdraw(inputWithdraw);
        } else
            System.out.println("Invalid");


    }

}

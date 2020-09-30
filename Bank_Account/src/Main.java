import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import java.lang.Math;
import java.sql.*;
import java.util.Scanner;

public class Main {

    Connection connect;
    Statement stm;
    public static void main(String[] args) {

        //Establishing connection
        Main connection = new Main();
        Connection connect_ = connection.Create_Connection();


        Bank_Account new_account = new Bank_Account();
        // Quick introduction to the program
        System.out.println("This is a simple Bank Account Model Design in Java.");
        System.out.println("You will be able to add a new account, make deposit, withdraw money and check balance.");
        System.out.println("");

        // Request for the user's account number and immediate deposit

        System.out.println("Please follow the options below:");
        System.out.println("1. Add a new account.");
        System.out.println("2. Make a deposit.");
        System.out.println("3. Check balance.");
        System.out.println("4. Withdraw money.");

        int inputAccount;
        Double add_money;
        Scanner input = new Scanner(System.in);
        int options = input.nextInt();
        switch(options) {
            case 1: // Get the details NEW ACCOUNT
                    System.out.println("Name: ");
                    input = new Scanner(System.in);
                    String inputName = input.nextLine();
                    System.out.println("Add Account Number: ");
                    input = new Scanner(System.in);
                    inputAccount = input.nextInt();
                    System.out.println("Make a deposit: Y/N");
                    input = new Scanner(System.in);
                    String inputDepo = input.nextLine();

                    // Call Function
                    new_account.Add_Account(connect_, inputName, inputAccount, inputDepo);

                    System.out.println("Thanks!");
                break;

            case 2: // DEPOSIT
                    System.out.println("Name: ");
                    input = new Scanner(System.in);
                    inputName = input.nextLine();
                    System.out.println("Account Number: ");
                    input = new Scanner(System.in);
                    inputAccount = input.nextInt();
                    System.out.println("How much do you want to deposit?");
                    input = new Scanner(System.in);
                    double inputDeposit = input.nextDouble();
                    new_account.deposit( connect_, inputDeposit, inputAccount, inputName);
                break;

            case 3: // BALANCE
                    System.out.println("Name: ");
                    input = new Scanner(System.in);
                    inputName = input.nextLine();
                    System.out.println("Account Number: ");
                    input = new Scanner(System.in);
                    inputAccount = input.nextInt();
                    new_account.balance( connect_, inputName, inputAccount);
                break;

            case 4: // WITHDRAW
                    System.out.println("Name: ");
                    input = new Scanner(System.in);
                    inputName = input.nextLine();
                    System.out.println("Account Number: ");
                    input = new Scanner(System.in);
                    inputAccount = input.nextInt();
                    System.out.println("How much do you want to withdraw?");
                    input = new Scanner(System.in);
                    double inputWithdraw = input.nextDouble();
                    new_account.withdraw( connect_, inputName, inputAccount, inputWithdraw);
                break;

            default: System.out.println("Invalid");
                break;

        }

    } // end main

    // Create Connection with the database
    public Connection Create_Connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank_Account", "root","S@b3d0ri@My5ql" );
            stm = connect.createStatement();

            if (connect != null)
                System.out.println("Connected...");

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {

            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();

        }

        return connect;
    } // Create_Connection

}// end Main

import com.mysql.cj.Query;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Bank_Account {

    private int account_number;
    private int account_balance;
    private int add_money;
    private String account_name;

    public Bank_Account() {

//        this.account_number = account_number;
//        this.account_name = account_name;

        // Save the details in the database

    }

    public void Add_Account(Connection conn, String account_name, int account_number, String account_Depo) {

        try {

            this.account_number = account_number;
            this.account_name = account_name;
            String query = "SELECT * FROM Bank_Account.Account_Data;";

            // Save the details in the database
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Account_Data (Name, Account_Number) VALUES (?,?)");
            stm.setString(1,account_name);
            String account_numberString = Integer.toString(account_number);
            stm.setString(2,account_numberString);
            stm.execute();
            //stm.executeUpdate();
            //stm.close();

            if(account_Depo == "y") {
                System.out.println("How much do you want to deposit?");
                Scanner input = new Scanner(System.in);
                this.add_money = input.nextInt();
                deposit(conn, add_money, account_number, account_name);
            } else
                // Add £0 to the account

            System.out.println("Account Created");
            System.out.println("Name: " + this.account_name);
            System.out.println("Account number: " + this.account_number);

        } catch (SQLException ex) {

            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();

        }

    }

    public void deposit(Connection conn, double add_money, int account_number, String account_name) {
        try {

            if(add_money < 0) {
                System.out.println("You cannot make a negative withdraw");
            }

            // Pull out the data from the dataBase
            PreparedStatement stm = conn.prepareStatement("SELECT Money\n" +
                    "FROM `Bank_Account`.`Account_Data` where Name = ? and Account_Number = ?;");
            stm.setString(1,account_name);
            String add_moneyString = Integer.toString(account_number); // convert INT to STRING
            stm.setString(2,add_moneyString);
            ResultSet rs = stm.executeQuery();

            String display_Money;
            double money_Added = 0;
            while (rs.next()) {

                display_Money = rs.getString("Money"); //get the current money in the account
                double money_AddedConversion = Double.parseDouble(display_Money);

                money_Added = money_AddedConversion + add_money; // add to the current balance
                System.out.println("You added: " + display_Money + " to your account");
                System.out.println("Your balance is: " + money_Added);

                // Update the new balance into the database
            }

        } catch (SQLException ex) {

            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();

        }

    } // deposit

    public void withdraw(Connection conn, String account_name, int account_number, double remove_money) {
        try {

            if(remove_money < 0) {
                System.out.println("You cannot make a negative withdraw");
            }

            // Pull out the data from the dataBase
            PreparedStatement stm = conn.prepareStatement("SELECT Money\n" +
                    "FROM `Bank_Account`.`Account_Data` where Name = ? and Account_Number = ?;");
            stm.setString(1,account_name);
            String add_moneyString = Integer.toString(account_number); // convert INT to STRING
            stm.setString(2,add_moneyString);
            ResultSet rs = stm.executeQuery();

            String display_Money;
            double money_Removed = 0;
            while (rs.next()) {

                display_Money = rs.getString("Money"); //get the current money in the account
                double money_RemovedConversion = Double.parseDouble(display_Money);
                if(remove_money > money_RemovedConversion) {
                    System.out.println("You cannot remove more money that your current balance");
                } else {
                    money_Removed = money_RemovedConversion - remove_money; // subtract from the current balance
                    System.out.println("You removed: " + display_Money + " from your account");
                    System.out.println("Your balance is: " + money_Removed);

                    // Update the new balance into the database
                }
            }

        } catch (SQLException ex) {

            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();

        }

    } // withdraw

    public void balance(Connection conn, String account_name, int account_number) {
        try {

            // Pulling the Money data from the DataBase
            PreparedStatement stm = conn.prepareStatement("SELECT Money\n" +
                    "FROM `Bank_Account`.`Account_Data` where Name = ? and Account_Number = ?;");

            stm.setString(1,account_name);
            String add_moneyString = Integer.toString(account_number);
            stm.setString(2,add_moneyString);
            ResultSet rs = stm.executeQuery();

            String display_Money = null;
            while (rs.next()) {

                display_Money = rs.getString("Money");
                System.out.println(display_Money);
            }
            System.out.println("Your balance is: " + display_Money);
            //stm.executeUpdate();
            //System.out.println("Your account balance is: " + this.account_number);

        } catch (SQLException ex) {

            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();

        }

    } // balance

}

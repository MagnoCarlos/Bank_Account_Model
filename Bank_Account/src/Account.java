class Bank_Account {

    private int account_number;
    private int account_balance;

    public Bank_Account(int account_number, int account_balance) {

        this.account_number = account_number;
        this.account_balance = account_balance;

        System.out.println("Your account is: " + this.account_number);
    }

    public void deposit(int add_money) {

        if(add_money < 0) {
            System.out.println("You cannot make a negative deposit");
        } else {
            this.account_balance = this.account_balance + add_money;
            System.out.println("You added " + add_money + " to your account");
            System.out.println("Your new balance is: " + this.account_balance);
        }
    }

    public void withdraw(int remove_money) {

        if(remove_money < 0) {
            System.out.println("You cannot make a negative withdraw");
        } else if(remove_money > this.account_balance){
            System.out.println("You cannot remove more money that your current balance");
        } else {
            this.account_balance = this.account_balance - remove_money;
            System.out.println("You removed " + remove_money + " from your account");
            System.out.println("Your new balance is: " + this.account_balance);
        }
    }

    public void balance(int account_number) {

        this.account_balance = this.account_balance;

        System.out.println("Your account balance is: " + this.account_number);
    }

}

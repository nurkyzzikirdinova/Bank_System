class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double checkBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Сиздин аккаунтга " + amount + " сом кошулду");
    }

    public void withdrawal(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " сом алынды.");
        } else {
            System.out.println("Аккаунтта жеткиликтүү сумма жок.");
        }
    }

    public void transaction(Account recipient, double amount) {
        if (amount <= balance) {
            withdrawal(amount);
            recipient.deposit(amount);
            System.out.println(amount + " сом которулду.");
        } else {
            System.out.println("Аккаунтта жеткиликтүү сумма жок.");
        }

    }

}
class Bank {
    long[] b;

    public Bank(long[] balance) {
        b = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > b.length || account2 > b.length || b[account1 - 1] < money) return false;
        b[account1 - 1] -= money;
        b[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account > b.length) return false;
        b[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > b.length || b[account - 1] < money) return false;
        b[account - 1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
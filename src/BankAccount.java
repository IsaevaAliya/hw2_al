public class BankAccount {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void deposit(double som) {
        amount += som;
    }

    public void withDraw(int som) throws LimitException {
        if (som > amount) {
            throw new LimitException("Insufficient funds for withdrawal", amount);
        }
        amount -= som;
    }
}

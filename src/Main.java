public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(15000);

        while (true) {
            try {
                account.withDraw(6000);
                System.out.println("Successfully withdrew 6000. Remaining balance: " + account.getAmount());
            } catch (LimitException e) {
                System.out.println(e.getMessage());
                System.out.println("Withdrawing the remaining amount: " + e.getRemainingAmount());
                try {
                    account.withDraw((int) e.getRemainingAmount());
                } catch (LimitException limitException) {
                    // Этот блок не должен быть достигнут
                    limitException.printStackTrace();
                }
                break;
            }
        }
    }
}

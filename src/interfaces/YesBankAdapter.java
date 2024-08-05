package interfaces;

public class YesBankAdapter implements BankingService{
    @Override
    public void transferMoney(int amount, int account) {
        // YesBank API call with the params required by YesBank
        System.out.println("Transferred money using Yes bank");
    }

    @Override
    public int getBalance() {
        // Yes bank API to get the balance of an account.
        return 10;
    }
}

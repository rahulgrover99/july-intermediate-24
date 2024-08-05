package interfaces;

public class ICICIBankAdapter implements BankingService{
    @Override
    public void transferMoney(int amount, int account) {
        // Calls icici bank API.
        System.out.println("Transferred money using ICICI");

    }

    @Override
    public int getBalance() {
        System.out.println("Checked money using ICICI");
        return 0;
    }

    public void iciciSpecial() {

    }
}

package interfaces;

public abstract class AbstractBankingService implements BankingService{
    @Override
    public void transferMoney(int account, int amount) {

    }

    public abstract int getBalance();
}

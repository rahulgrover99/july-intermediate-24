package interfaces;


import java.util.*;

public interface BankingService {

    void transferMoney(int account, int amount);

    int getBalance();

}



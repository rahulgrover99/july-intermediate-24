package interfaces;


import java.util.*;

public interface BankingService {

    // By default all variables in
    // an interface are static and final
        static final int a = 0;

    void transferMoney(int account, int amount);

    int getBalance();

}



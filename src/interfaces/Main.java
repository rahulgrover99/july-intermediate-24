package interfaces;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        PhonePe phonePe = new PhonePe(new ICICIBankAdapter());

        List<BankingService> bankingServiceList = List.of(new ICICIBankAdapter(), new YesBankAdapter());

        phonePe.checkBalance();
        phonePe.sendMoney(11, 11);

    }
}

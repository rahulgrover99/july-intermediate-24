package interfaces;

class PhonePe{

//    PhonePe(YesBankApi api) {
//        this.api = api;
//    }


    private BankingService api;

    PhonePe(BankingService api) {
        this.api = api;
    }


    void sendMoney(int to, int amount) {
//        api.transferMoney(to, amount);
        api.transferMoney(11, 11);
    }

    int checkBalance() {
//        api.getBalance();
        return api.getBalance();
    }

}
package designpatterns.observer;

public class AnalyticsService implements OrderObserver{

    void analyseOrder() {
        System.out.println("order analysing");
    }

    @Override
    public void onOrderPlace(int id) {
        analyseOrder();
    }
}

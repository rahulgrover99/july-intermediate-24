package designpatterns.observer;

public class InventoryService implements OrderObserver{


    void updateInventory(int id) {
        System.out.println("Updating inventory.");
    }


    @Override
    public void onOrderPlace(int id) {
        updateInventory(id);
    }
}

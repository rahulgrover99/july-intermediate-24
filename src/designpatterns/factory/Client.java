package designpatterns.factory;

public class Client {

    public static void main(String[] args) {

        Flutter f = new Flutter();
        UiFactory uiFactory = f.createUiFactory("Android");

//        Flutter f = new AndroidFlutter();
        Object button = uiFactory.createButton();


        System.out.println("hi");

    }

}

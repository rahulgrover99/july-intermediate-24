package designpatterns.factory;

import javax.print.ServiceUIFactory;

public class Flutter {

    void setTheme() {
        System.out.println("Setting theme...");
    }

    void setRefreshRate(int val) {
        System.out.println("set refresh rate to " + val);
    }

    // abstract UiFactory createUiFactory();


    // Simple (Practical) factory
    UiFactory createUiFactory(String platform) {
        return switch (platform) {
            case "IOS" -> new IosUiFactory();
            case "Android" -> new AndroidUiFactory();
            default -> null;
        };
    }

}

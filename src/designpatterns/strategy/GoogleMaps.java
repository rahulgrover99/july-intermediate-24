package designpatterns.strategy;

public class GoogleMaps {


    void findPathForMode(String src, String dest, Modes mode) {
        PathCalculator pc = PathCalculatorFactory.getPathCalculator(mode);
    }



}


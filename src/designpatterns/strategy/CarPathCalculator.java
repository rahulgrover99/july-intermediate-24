package designpatterns.strategy;

import java.util.List;

public class CarPathCalculator implements PathCalculator{

    private static final List<String> roads = List.of("Road1", "Road2");


    @Override
    public void findPath(String src, String dest) {
        System.out.println("Finding path for car");

        for (String road: roads) {
            System.out.println(road);
        }

    }
}

package designpatterns.strategy;

import java.util.List;

public class WalkingPathCalculator implements PathCalculator{

    private static final List<String> EDGES = List.of("Street1", "Street2");

    @Override
    public void findPath(String src, String dest) {
        System.out.println("Finding path for Walking");

        for (String path: EDGES) {
//            EDGES.add("Street3");
            System.out.println(path);
        }

    }
}

package designpatterns.strategy;

import java.nio.file.Path;

public class PathCalculatorFactory {

    private static PathCalculator CAR_PATH = new CarPathCalculator();
    private static PathCalculator WALK_PATH = new WalkingPathCalculator();

    static PathCalculator getPathCalculator(Modes mode) {
        return switch (mode) {
            case CAR -> CAR_PATH;
            case WALK -> WALK_PATH;
            default -> throw new IllegalArgumentException();
        };
    }

}

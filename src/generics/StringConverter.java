package generics;

import java.util.function.Function;

public class StringConverter implements Function<Integer, String> {
    @Override
    public String apply(Integer integer) {
        return integer.toString();
    }
}

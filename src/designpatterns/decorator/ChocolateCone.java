package designpatterns.decorator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Collections;

public class ChocolateCone implements IceCream{
    @Override
    public String getDesc() {
        return "Chocolate Cone";
    }

    @Override
    public int getCost() {
        return 20;
    }

}

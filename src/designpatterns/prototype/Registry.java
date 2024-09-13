package designpatterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {
    public enum RegistryType{
        SIGNING, CLOUD, LOCAL
    }

    private Map<RegistryType, SigningConfig> mp = new HashMap<>();

    public SigningConfig get(RegistryType type) {
        return mp.get(type);
    }

    public void add(RegistryType type, SigningConfig sc) {
        mp.put(type, sc);
    }

}

package designpatterns.prototype;

public class Main {

    public static void main(String[] args) {

        SigningConfig obj1 = new CloudSigningConfig("key1", "cert1", "url");
        SigningConfig obj2 = new SigningConfig("key1", "cert1");

        Registry registry = new Registry();
        registry.add(Registry.RegistryType.CLOUD, obj1);

        registry.add(Registry.RegistryType.SIGNING, obj2);

        SigningConfig copy = createCopy(registry.get(Registry.RegistryType.SIGNING));

        System.out.println(copy);

    }

    private static SigningConfig createCopy(SigningConfig sc) {
        return sc.copy();
    }
}

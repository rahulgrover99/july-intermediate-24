package designpatterns.prototype;

public class SigningConfig {
    private String key;
    public String certificate;

    public SigningConfig(String key, String certificate) {
        this.key = key;
        this.certificate = certificate;
    }

    // Copy Constructor;
    public SigningConfig(SigningConfig other) {
        this.key = other.key;
        this.certificate = other.certificate;
    }


    public SigningConfig copy() {
        return new SigningConfig(this);
    }

}

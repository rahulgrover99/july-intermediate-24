package designpatterns.prototype;

public class CloudSigningConfig extends SigningConfig{

    private String url;

    public CloudSigningConfig(String key, String certificate, String url) {
        super(key, certificate);
        this.url = url;
    }

    public CloudSigningConfig(SigningConfig other) {
        super(other);
        this.url = ((CloudSigningConfig)other).url;
    }

    @Override
    public SigningConfig copy() {
        return new CloudSigningConfig(this);
    }
}

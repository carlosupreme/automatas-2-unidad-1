public class CampoConfig {

    private final String etiqueta;
    private final String placeholder;
    private final Validador validador;

    public CampoConfig(String etiqueta, String placeholder, String regex) {
        this(etiqueta, placeholder, new ValidadorPatron(regex));
    }

    public CampoConfig(String etiqueta, String placeholder, Validador validador) {
        this.etiqueta    = etiqueta;
        this.placeholder = placeholder;
        this.validador   = validador;
    }

    public String    getEtiqueta()    { return etiqueta; }
    public String    getPlaceholder() { return placeholder; }
    public Validador getValidador()   { return validador; }
}

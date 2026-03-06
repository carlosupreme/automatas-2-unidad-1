import java.util.regex.Pattern;

public class ValidadorPatron implements Validador {

    private final Pattern patron;

    protected ValidadorPatron(String regex) {
        this.patron = Pattern.compile(regex);
    }

    @Override
    public boolean validar(String texto) {
        return patron.matcher(texto).matches();
    }
}

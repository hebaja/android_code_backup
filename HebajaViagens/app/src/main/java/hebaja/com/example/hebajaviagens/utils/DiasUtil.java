package hebaja.com.example.hebajaviagens.utils;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String formataEmTexto(int quantidadeDedias) {
        if (quantidadeDedias > 1) {
            return quantidadeDedias + PLURAL;
        }
            return quantidadeDedias + SINGULAR;
    }
}

package codigo_morse_arvore_binaria;

public final class Formatadora {
    private Formatadora() {}

    public static String limpaFrase(String frase) {
        if (frase == null) return "";

        frase = frase.toUpperCase();
        char[] caracteres = frase.toCharArray();

        for (int i = 0; i < caracteres.length; i++) {
            switch (caracteres[i]) {
                case 'Á': case 'À': case 'Ã': case 'Â': caracteres[i] = 'A'; break;
                case 'É': case 'Ê': caracteres[i] = 'E'; break;
                case 'Í': case 'Î': caracteres[i] = 'I'; break;
                case 'Ó': case 'Ô': case 'Õ': caracteres[i] = 'O'; break;
                case 'Ú': case 'Ü': caracteres[i] = 'U'; break;
                case 'Ç': caracteres[i] = 'C'; break;
            }
        }

        return new String(caracteres);
    }
}
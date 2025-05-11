package codigo_morse_arvore_binaria;

public class TabelaMorse {
    public static final String[] CODIGOS = {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
        ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", 
        "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", 
        ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"
    };

    public static final char[] SIMBOLOS = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
        'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
    };

    private TabelaMorse() {}
    
    public static void imprimirTabela() {
        for(int i = 0; i < CODIGOS.length && i < SIMBOLOS.length; i ++) {
            System.out.printf("%-10s  %-5s |\t", CODIGOS[i], SIMBOLOS[i]);

            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
    }

}

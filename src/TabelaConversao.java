public class TabelaConversao {


    String[] codigosMorse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--..",
            ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----"
    };
    String[] letras = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z",
            "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "0"
    };

    public void formarTabela(String[] tabelaCodigo, String[] tabelaLetra){

        for(int i = 0; i < tabelaCodigo.length && i < tabelaLetra.length; i ++){
            System.out.printf("%-10s  %-5s |\t", tabelaCodigo[i], tabelaLetra[i]);

            if ((i + 1) % 4 == 0) {
                System.out.println();
            }

        }
    }

    public void imprimirTabela() {
        formarTabela(codigosMorse, letras);
    }

}

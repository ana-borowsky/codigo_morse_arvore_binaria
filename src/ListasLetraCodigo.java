public class ListasLetraCodigo {

    String[] codigosMorse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--..",
            ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----"
    };
    char[] letras = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z',
            '1', '2', '3', '4', '5',
            '6', '7', '8', '9', '0'
    };

    public void inserirArvore(String[] tabelaCodigo, char[] tabelaLetra, ArvoreCodigoMorse arvore) {
        for(int i = 0; i < tabelaCodigo.length && i < tabelaLetra.length; i ++){
            arvore.inserir(tabelaCodigo[i],tabelaLetra[i]);
        }
    }

    public void insercaoElementoArvore(ArvoreCodigoMorse arvore){
        inserirArvore(codigosMorse, letras, arvore);
    }

    public void formarTabela(String[] tabelaCodigo, char[] tabelaLetra){
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

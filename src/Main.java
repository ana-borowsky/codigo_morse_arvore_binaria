public class Main {
    public static void main(String[] args) {
        ArvoreCodigoMorse arvore = new ArvoreCodigoMorse();

        arvore.inserir(".-", 'A');
        arvore.inserir("-...",'B');
        arvore.inserir("-.-.", 'C');
        arvore.inserir("-..", 'D');
        arvore.inserir(".", 'E');
        arvore.inserir("..-.", 'F');
        arvore.inserir("--.", 'G');
        arvore.inserir("....", 'H');
        arvore.inserir("..", 'I');
        arvore.inserir(".---", 'J');
        arvore.inserir("-.-", 'K');
        arvore.inserir(".-..", 'L');
        arvore.inserir("--", 'M');
        arvore.inserir("-.", 'N');
        arvore.inserir("---", 'O');
        arvore.inserir(".--.", 'P');
        arvore.inserir("--.-", 'Q');
        arvore.inserir(".-.", 'R');
        arvore.inserir("...", 'S');
        arvore.inserir("-", 'T');
        arvore.inserir("..-", 'U');
        arvore.inserir("...-", 'V');
        arvore.inserir(".--", 'W');
        arvore.inserir("-..-", 'X');
        arvore.inserir("-.--", 'Y');
        arvore.inserir("--..", 'Z');
        arvore.inserir(".----", '1');
        arvore.inserir("..---", '2');
        arvore.inserir("...--", '3');
        arvore.inserir("....-", '4');
        arvore.inserir(".....", '5');
        arvore.inserir("-....", '6');
        arvore.inserir("--...", '7');
        arvore.inserir("---..", '8');
        arvore.inserir("----.", '9');
        arvore.inserir("-----", '0');

        arvore.imprimirArvore(arvore);
        //TODO
        // Menu
        // Opção de imprimir arvore
        // Opção de mostrar a correspondencia entre letra e código
        // Opção de inserir mensagem para que seja codificada em morse
        // Opção de inserir mensagem em morse para ser decodificada
        // Busca
        // Metodo de busca na árvore, deve efetuar a busca dos caracters na arvore de acordo com o código colocado
        // e deve retornar a letra ou numero correspondente ao codigo inserido
        
    }
}

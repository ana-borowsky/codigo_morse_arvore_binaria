public class Main {
    public static void main(String[] args) {
        ArvoreCodigoMorse arvore = new ArvoreCodigoMorse();
        Menu menu = new Menu();
        NavegacaoMenu navegacao = new NavegacaoMenu(menu, arvore);

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

        navegacao.executando();
        arvore.imprimirArvore(arvore);
        
        // Frase de teste
        String frase = "Super frase que testará tudo e todos com atenção";
        String codigoMorse = arvore.letraParaCodigo(frase);

        System.out.println("Frase original: " + frase);
        System.out.println("Código Morse:     " + codigoMorse);
        
        String fraseMorse = "... --- ... / .- -. .-";  // SOS ANA

        String resultado = arvore.codigoParaSimbolo(fraseMorse);

        System.out.println("Código Morse: " + fraseMorse);
        System.out.println("Texto traduzido: " + resultado);
        
        
        //TODO
        // Menu
	        // Opção de imprimir arvore
        		// Arvore de codigos morse 
        		// Arvore de letras
	        // Opção de mostrar a correspondencia entre letra e código
	        // Opção de inserir mensagem para que seja codificada em morse (colocar que pontuação e simbolos nao sao aceitos)
	        // Opção de inserir mensagem em morse para ser decodificada (talvez colocar aqui ja a tabela de conversao de um para o outro)
        // Busca
        	// Busca de simbolos que retornam codigo morse
        	// Busca de código morse que retorna os simbolos
        
    }
}

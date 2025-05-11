import codigo_morse_arvore_binaria.Formatadora;
import codigo_morse_arvore_binaria.Tupla;

public class ArvoreCodigoMorse {
    private Node raiz;
    class Node {
        Tupla dado;
        Node esquerda, direita;

        public Node(Tupla dado) {
            this.dado = dado;
            this.esquerda = null;
            this.direita = null;
        }
    }

    void inserir(String codigo, char valor) {
        raiz = inserir(raiz, valor, codigo);
    }
    
    Node inserir(Node node, char letra, String codigo) {
        if (node == null)
            node = new Node(new Tupla('#', "#")); // Padrão de tupla vazia

        Node raiz = node;

        for (int i = 0; i < codigo.length(); i++) {
            char codigoMorse = codigo.charAt(i);

            if (codigoMorse == '.') {
                if (raiz.esquerda == null)
                    raiz.esquerda = new Node(new Tupla('#', "#"));

                if (i == codigo.length() - 1)
                    raiz.esquerda.dado = new Tupla(letra, codigo);

                raiz = raiz.esquerda;
            } else if (codigoMorse == '-') {
                if (raiz.direita == null)
                    raiz.direita = new Node(new Tupla('#', "#"));

                if (i == codigo.length() - 1)
                    raiz.direita.dado = new Tupla(letra, codigo);

                raiz = raiz.direita;
            }
        }

        return node;
    } 
     
    private String buscaCodigo(Node node, char simbolo) {
        if (node == null) return null;

        if (node.dado.simbolo == simbolo) {
            return node.dado.codigo;
        }

        String esquerda = buscaCodigo(node.esquerda, simbolo);
        if (esquerda != null) return esquerda;

        return buscaCodigo(node.direita, simbolo);
    }
    
    public String codificar(String frase) { // Recebe a frase em caracteres e numeros e retorna em codigo morse
        frase = Formatadora.limpaFrase(frase); // troca acentos e cedilhas para poder ter o equivalente correto para buscar o código morse -> ex: atenção vira atencao

        String resultado = "";

        for (int i = 0; i < frase.length(); i++) {
            char simbolo = frase.charAt(i);
            String codigo = buscaCodigo(this.raiz, simbolo);
            
            if (simbolo == ' ') {
            	resultado += ' ';
            } else {
            	if (codigo != null) {
                resultado += codigo + " ";
	            } else {
	                resultado += "? ";
	            }
            }
        }

        return resultado;
    }  
    
    private char buscarSimbolo(Node node, String codigo) {
        Node atual = node;

        for (int i = 0; i < codigo.length(); i++) {
            char c = codigo.charAt(i);
            if (c == '.') {
                if (atual.esquerda != null)
                    atual = atual.esquerda;
                else
                    return '#';
            } else if (c == '-') {
                if (atual.direita != null)
                    atual = atual.direita;
                else
                    return '#';
            } else {
                return '#'; // caractere inválido
            }
        }

        return atual.dado.simbolo;
    }
    
    public String decodificar(String fraseMorse) { // Recebe frase em morse, retorna em letras e numeros
        String resultado = "";

        String[] codigos = fraseMorse.trim().split(" ");

        for (String codigo : codigos) {
            if (codigo.equals("/")) { // separação de palavras
                resultado += " ";
            } else {
                char simbolo = buscarSimbolo(this.raiz, codigo);
                if (simbolo != '#') {
                    resultado += simbolo;
                } else {
                    resultado += "?"; // símbolo não encontrado
                }
            }
        }

        return resultado;
    }

    void desenhar(Node node, int nivel, String tipoArvore) { // Desenha a árvore binária ou de simbolos ou de códigos
        if (node == null) return;
        
        desenhar(node.direita, nivel + 1, tipoArvore);
        
        for (int i = 0; i < nivel; i++) System.out.print("	");

        if (tipoArvore == "codigo") {
            System.out.println(node.dado.codigo); 
        }

        if (tipoArvore == "simbolo") {
            System.out.println(node.dado.simbolo); 
        }

        desenhar(node.esquerda, nivel + 1, tipoArvore);
    }

    void imprimirArvore(ArvoreCodigoMorse arvore, String tipoArvore) {
        System.out.println(Mensagens.MENSAGEM_ARVORE);
        arvore.desenhar(arvore.raiz, 0, tipoArvore);
    }
  
}
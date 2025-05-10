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
    
    public Node getRaiz() {
        return raiz;
    }
    
    public static String limpaFrase(String frase) {
        frase = frase.toUpperCase();
        StringBuilder limpa = new StringBuilder();

        for (int i = 0; i < frase.length(); i++) {
            char letra = frase.charAt(i);

            switch (letra) {
                case 'Á':
                case 'À':
                case 'Ã':
                case 'Â':
                    letra = 'A';
                    break;
                case 'É':
                case 'Ê':
                    letra = 'E';
                    break;
                case 'Í':
                case 'Î':
                    letra = 'I';
                    break;
                case 'Ó':
                case 'Ô':
                case 'Õ':
                    letra = 'O';
                    break;
                case 'Ú':
                case 'Ü':
                    letra = 'U';
                    break;
                case 'Ç':
                    letra = 'C';
                    break;
                default:
                    break;
            }

            limpa.append(letra);
        }

        return limpa.toString();
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
    
    public char codigoParaLetra(String codigo) {
        Node atual = this.raiz;

        for (int i = 0; i < codigo.length(); i++) {
            char sinal = codigo.charAt(i);

            if (sinal == '.') {
                if (atual.esquerda != null) {
                    atual = atual.esquerda;
                } else {
                    return '?'; // Caminho inválido
                }
            } else if (sinal == '-') {
                if (atual.direita != null) {
                    atual = atual.direita;
                } else {
                    return '?'; // Caminho inválido
                }
            } else {
                return '?'; // Símbolo inválido (nem . nem -)
            }
        }

        return atual.dado.simbolo;
    }
    
    public String letraParaCodigo(String frase) {
        frase = limpaFrase(frase); // troca acentos e cedilhas

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
    
    public String codigoParaSimbolo(String fraseMorse) {
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


    void desenhar(Node node, int nivel) {
        if (node == null) return;
        
        desenhar(node.direita, nivel + 1);
        
        for (int i = 0; i < nivel; i++) System.out.print("	");
        
        System.out.println(node.dado.simbolo); // dado.codigo mostra arvore de códigos e dado.simbolo mostra árvore de simbolos
        
        desenhar(node.esquerda, nivel + 1);
    }

    void imprimirArvore(ArvoreCodigoMorse arvore) {
        System.out.println("\n\n Árvore desenhada - nós com dados vazios são representados por #:\n\n");
        arvore.desenhar(arvore.raiz, 0);
    }
  
}
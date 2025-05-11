import codigo_morse_arvore_binaria.Formatadora;
import codigo_morse_arvore_binaria.TabelaMorse;
import codigo_morse_arvore_binaria.Tupla;

public class ArvoreCodigoMorse {
    private Node raiz;
    
    class Node {
        Tupla dado;
        Node esquerda, direita;

        public Node(Tupla dado) {
            this.dado = dado; // o dado do nó é uma tupla com o código morse e o simbolo correspondente
            this.esquerda = null;
            this.direita = null;
        }
    }

    void inserir(String codigo, char valor) {
        raiz = inserir(raiz, valor, codigo);
    }
    
    Node inserir(Node node, char letra, String codigo) { //Insere um novo nó na árvore de código Morse com base no código fornecido.
        // Se o nó atual é null, cria um novo nó com uma tupla vazia Tupla('#', "#")
        if (node == null)
            node = new Node(new Tupla('#', "#")); // Nó temporário sem símbolos válidos

        // Ponteiro para percorrer a árvore sem perder a referência à raiz
        Node raiz = node;

        // Percorre cada caractere do código Morse
        for (int i = 0; i < codigo.length(); i++) {
            char codigoMorse = codigo.charAt(i);

            // Código '.' indica que devemos seguir para a esquerda
            if (codigoMorse == '.') {
                // Se não existe nó à esquerda, cria um nó vazio
                if (raiz.esquerda == null)
                    raiz.esquerda = new Node(new Tupla('#', "#"));

                // Se é o último caractere do código, atualiza o nó com a letra/código real
                if (i == codigo.length() - 1)
                    raiz.esquerda.dado = new Tupla(letra, codigo);

                // Move o ponteiro para o nó da esquerda
                raiz = raiz.esquerda;
            }
            // Código '-' indica que devemos seguir para a direita
            else if (codigoMorse == '-') {
                // Se não existe nó à direita, cria um nó vazio
                if (raiz.direita == null)
                    raiz.direita = new Node(new Tupla('#', "#"));

                // Se é o último caractere do código, atualiza o nó com a letra/código real
                if (i == codigo.length() - 1)
                    raiz.direita.dado = new Tupla(letra, codigo);

                // Move o ponteiro para o nó da direita
                raiz = raiz.direita;
            }
        }

        // Retorna a raiz da árvore (ou subárvore) modificada
        return node;
    }
    
    
    // Inicializa a árvore com os simbolos e códigos corretos
    public void inicializar() {
        for (int i = 0; i < TabelaMorse.CODIGOS.length; i++) {
            this.inserir(TabelaMorse.CODIGOS[i], TabelaMorse.SIMBOLOS[i]);
        }
    }
     
 // Este seria o método buscar() pedido pelo professor. O nome é diferente pois temos dois: a busca de códigos e a de simbolos
    private String buscarCodigo(Node node, char simbolo) { 
        if (node == null) return null;

        if (node.dado.simbolo == simbolo) {
            return node.dado.codigo;
        }

        String esquerda = buscarCodigo(node.esquerda, simbolo);
        if (esquerda != null) return esquerda;

        return buscarCodigo(node.direita, simbolo);
    }
    
    //Converte uma frase em texto comum para código Morse
    public String codificar(String frase) {
        // Normaliza a frase: converte para maiúsculas e remove acentos/cedilha
        // Exemplo: "Atenção" -> "ATENCAO"
        frase = Formatadora.limpaFrase(frase);

        // Variável para acumular o resultado da codificação
        String resultado = "";

        // Percorre cada caractere da frase
        for (int i = 0; i < frase.length(); i++) {
            char simbolo = frase.charAt(i);
            
            // Busca o código Morse correspondente ao símbolo na árvore
            String codigo = buscarCodigo(this.raiz, simbolo);
            
            // Tratamento especial para espaços (separação entre palavras)
            if (simbolo == ' ') {
                resultado += ' '; // Adiciona um espaço diretamente ao resultado
            } else {
                // Se encontrou o código Morse correspondente
                if (codigo != null) {
                    resultado += codigo + " "; // Adiciona o código + espaço separador
                } else {
                    // Símbolo não encontrado na árvore (caractere inválido)
                    resultado += "? "; // Marca como desconhecido
                }
            }
        }

        // Retorna a string codificada
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

 // Desenha a árvore binária ou de simbolos ou de códigos
    void desenhar(Node node, int nivel, String tipoArvore) { 
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

 // Imprime a árvore mostrando uma mensagem e colocando o tipo da árvore a ser impressa
    void imprimirArvore(ArvoreCodigoMorse arvore, String tipoArvore) { 
        System.out.println(Mensagens.MENSAGEM_ARVORE);
        arvore.desenhar(arvore.raiz, 0, tipoArvore);
    }
  
}
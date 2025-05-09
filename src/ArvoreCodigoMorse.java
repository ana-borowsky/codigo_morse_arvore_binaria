public class ArvoreCodigoMorse {
    private Node raiz;
    class Node {
        private char letra;
        private Node esquerda, direita;

        Node(char letra) {
            this.letra = letra;
            this.esquerda = null;
            this.direita = null;
        }
    }

    void inserir(String codigo, char valor) {
        raiz = inserir(raiz, valor, codigo);
    }

    Node inserir(Node node, char valor, String codigo) {
        if (node == null)
            node = new Node(' ');

        Node raiz = node;

        for (int i = 0; i < codigo.length(); i++) {
            char codigoMorse = codigo.charAt(i);

            if (codigoMorse == '.') {
                if (raiz.esquerda == null)
                    raiz.esquerda = new Node('}'); // Retirar a chave, coloquei so para testar se estava sendo inserido os vazios quando
                                                        // não tem nehuma letra, mas a letra seguinte esta ligada a esse no vazio

                if (i == codigo.length() - 1)
                    raiz.esquerda.letra = valor;

                raiz = raiz.esquerda;
            }
            else if (codigoMorse == '-') {
                if (raiz.direita == null)
                    raiz.direita = new Node('}'); // Retirar a chave, coloquei so para testar se estava sendo inserido os vazios quando
                                                        // não tem nehuma letra, mas a letra seguinte esta ligada a esse no vazio

                if (i == codigo.length() - 1)
                    raiz.direita.letra = valor;

                raiz = raiz.direita;
            }
        }

        return node;
    }

    public Node getRaiz() {
        return raiz;
    }

    void desenhar(Node node, int nivel) {
        if (node == null) return;
        desenhar(node.direita, nivel + 1);
        for (int i = 0; i < nivel; i++) System.out.print(" ");
        System.out.println(node.letra);
        desenhar(node.esquerda, nivel + 1);
    }

    void imprimirArvore(ArvoreCodigoMorse arvore){
        System.out.println("\n\n Árvore Desenhada:\n\n");
        arvore.desenhar(arvore.raiz, 0);

        System.out.println("Árvore Desenhada:\n\n");
        arvore.desenhar(arvore.raiz, 0);
    }

}
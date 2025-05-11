public class Main {
    public static void main(String[] args) {
        ArvoreCodigoMorse arvore = new ArvoreCodigoMorse();
        Menu menu = new Menu();

        NavegacaoMenu navegacao = new NavegacaoMenu(menu, arvore);
        ListasLetraCodigo listaCodigoMorse = new ListasLetraCodigo();

        listaCodigoMorse.insercaoElementoArvore(arvore);
        navegacao.executando();



        // Relatorio Alteracoes:

        // Crei o menu, tentei segui o mesmo modelo do trabalho de Fila e Pilha usando struct.
        // Melhorei a insercao na arvore, para isso criei a classe ListaLetraCodigo. Essa classe serve para
        // imprimir a tabela com as letras e os codigos referentes a elas.
        // Na classe classe ArvoreCodigoMorse alterei o metodo desenhar e imprimirArvore. Essas alteracoes são apenas
        // para conseguir imprimir a arvore com as letras e a arvore com os codigos.

        // Obs: A inserção esta sendo feita na classe na classe ListaLetraCodigo, mas fiquei na duvida se não deixava
        //      na main. Preferi deixar na  ListaLetraCodigo porque deixa a main mais limpa.


        //TODO
        // Busca
        	// Busca de simbolos que retornam codigo morse
        	// Busca de código morse que retorna os simbolos
        
    }
}

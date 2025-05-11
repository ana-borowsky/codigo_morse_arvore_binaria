public class Menu {
    public void menuPrincipal() {
        System.out.println(OpcoesMenu.MENU);
        String[] opcoes = {OpcoesMenu.IMPRIMIR_ARVORE, OpcoesMenu.TABELA_LETRA_CODIGO, OpcoesMenu.MENSAGEM, OpcoesMenu.SAIR};
        exibirMenu(opcoes);
        imprimirSetaInput();
        
    }

    public void menuArvore() {
        System.out.println(Mensagens.DESTAQUE + OpcoesMenu.IMPRIMIR_ARVORE);
        String[] opcoes = {OpcoesMenu.ARVORE_CODIGO_MORSE, OpcoesMenu.ARVORE_LETRAS,OpcoesMenu.VOLTAR};
        exibirMenu(opcoes);
        imprimirSetaInput();
    }

    public void mostrarArvoreMorse() {
        System.out.println(OpcoesMenu.ARVORE_CODIGO_MORSE);
        
    }

    public void mostrarArvoreSimbolos() {
        System.out.println(OpcoesMenu.ARVORE_LETRAS);
    }

    public void mostratabela() {
        System.out.println(Mensagens.DESTAQUE + OpcoesMenu.TABELA_LETRA_CODIGO);
    }

    public void menuMensagem() {
        System.out.println(Mensagens.DESTAQUE + OpcoesMenu.MENSAGEM);
        String[] opcoes = {OpcoesMenu.MENSAGEM_COMUM, OpcoesMenu.MENSAGEM_MORSE,OpcoesMenu.VOLTAR};
        exibirMenu(opcoes);
        imprimirSetaInput();
    }

    public void exibirMenu(String [] opcoes) {
        for( int i = 0 ; i < opcoes.length; i ++) {
            System.out.printf("[ %d ] %s%n", i + 1, opcoes[i]);
        }
    }
    
    private void imprimirSetaInput() {
    	System.out.print(">> ");
    }
}

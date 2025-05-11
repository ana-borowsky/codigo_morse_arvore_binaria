public class Main {
    public static void main(String[] args) {
    	System.out.println(Mensagens.BOAS_VINDAS);	
    	
        ArvoreCodigoMorse arvore = new ArvoreCodigoMorse();
        Menu menu = new Menu();

        NavegacaoMenu navegacao = new NavegacaoMenu(menu, arvore);
        ElementosArvore listaCodigoMorse = new ElementosArvore();

        listaCodigoMorse.insercaoElementoArvore(arvore);
        navegacao.executando();
    }
}

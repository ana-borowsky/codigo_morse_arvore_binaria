public class Main {
    public static void main(String[] args) {
    	System.out.println(Mensagens.BOAS_VINDAS);	
    	
        ArvoreCodigoMorse arvore = new ArvoreCodigoMorse();
        arvore.inicializar();
        Menu menu = new Menu();

        NavegacaoMenu navegacao = new NavegacaoMenu(menu, arvore);
        
        navegacao.executando();
    }
}

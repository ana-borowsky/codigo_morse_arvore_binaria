public class Main {
    public static void main(String[] args) {
    	System.out.println(Mensagens.BOAS_VINDAS);	
    	
        ArvoreCodigoMorse arvore = new ArvoreCodigoMorse();
        arvore.inicializar();

        NavegacaoMenu navegacao = new NavegacaoMenu(arvore);
        
        navegacao.executando();
    }
}

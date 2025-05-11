import java.util.Scanner;

public class NavegacaoMenu {
    TabelaConversao tabela = new TabelaConversao();
    public ArvoreCodigoMorse arvore;
    public Menu menu;


    public NavegacaoMenu(Menu menu, ArvoreCodigoMorse arvoreMorse) {
        this.menu = menu;
        this.arvore = arvoreMorse;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void executando(){
        boolean rodando = true;

        while (rodando){
            menu.menuPrincipal();
            int opcaoSelecionada = lerOpcao(scanner);

            switch (opcaoSelecionada) {
                case 1:
                    menuImprimirArvore();
                    break;

                case 2:
                    menu.mostratabela();
                    tabela.imprimirTabela();
                    break;

                case 3:
                    mensagem();
                    break;

                case 4:
                    rodando = false;
                    System.out.println(MensagensMenu.ENCERRA_PROGRAMA);
                    break;

                default:
                    System.out.println(MensagensMenu.OPCAO_INVALIDA);
                    break;
            }
        }
    }

    public void menuImprimirArvore(){
        menu.menuArvore();
        int opcaoSolicitacao = lerOpcao(scanner);

        switch (opcaoSolicitacao){
            case 1:
                menu.mostrarArvoreMorse();
                // Adicionar a Arvore de codigo morse
                break;

            case 2:
                menu.mostrarArvoreLetras();
                arvore.imprimirArvore(arvore);
                break;

            case 3:
                break;

            default:
                System.out.println(MensagensMenu.OPCAO_INVALIDA);
                break;
        }

    }

    public void mensagem(){
        menu.menuMensagem();
        int opcaoSolicitacao = lerOpcao(scanner);

        switch (opcaoSolicitacao){
            case 1:
                System.out.println(MensagensMenu.MENSAGEM_CODIFICA);
                String frase = scanner.nextLine();
                String textoCodificado = arvore.letraParaCodigo(frase);
                System.out.println(MensagensMenu.TEXTO_MORSE + textoCodificado);
                break;

            case 2:
                tabela.imprimirTabela();
                System.out.println(MensagensMenu.MENSAGEM_DECODIFICADA);
                String fraseCodificada = scanner.nextLine();
                String resultado = arvore.codigoParaSimbolo(fraseCodificada);
                System.out.println(MensagensMenu.TEXTO_TRADUZIDO + resultado);
                break;

            case 3:
                break;

            default:
                System.out.println(MensagensMenu.OPCAO_INVALIDA);
                break;

        }

    }

    public static int lerOpcao(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(MensagensMenu.OPCAO_INVALIDA);
            }
        }
    }
}

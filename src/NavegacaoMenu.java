import java.util.Scanner;

import codigo_morse_arvore_binaria.TabelaMorse;

public class NavegacaoMenu {
    public ArvoreCodigoMorse arvore;
    public Menu menu;

    public NavegacaoMenu(Menu menu, ArvoreCodigoMorse arvoreMorse) {
        this.menu = menu;
        this.arvore = arvoreMorse;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void executando() {
        boolean rodando = true;

        while (rodando) {
            menu.menuPrincipal();
            int opcaoSelecionada = lerOpcao(scanner);

            switch (opcaoSelecionada) {
                case 1:
                    menuImprimirArvore();
                    break;

                case 2:
                    menu.mostratabela();
                    TabelaMorse.imprimirTabela();
                    break;

                case 3:
                    mensagem();
                    break;

                case 4:
                    rodando = false;
                    System.out.println(Mensagens.ENCERRA_PROGRAMA);
                    break;

                default:
                    System.out.println(Mensagens.OPCAO_INVALIDA);
                    break;
            }
        }
    }

    public void menuImprimirArvore() {
        menu.menuArvore();
        int opcaoSolicitacao = lerOpcao(scanner);

        switch (opcaoSolicitacao) {
            case 1:
                menu.mostrarArvoreMorse();
                System.out.println(Mensagens.MENSAGEM_ARVORE);
                arvore.imprimir(arvore.raiz, 0, "codigo");
                //arvore.imprimirArvore(arvore,"codigo");
                break;

            case 2:
                menu.mostrarArvoreSimbolos();
                System.out.println(Mensagens.MENSAGEM_ARVORE);
                //arvore.imprimirArvore(arvore,"simbolo");
                arvore.imprimir(arvore.raiz, 0, "simbolo");
                break;

            case 3:
                break;

            default:
                System.out.println(Mensagens.OPCAO_INVALIDA);
                break;
        }

    }

    public void mensagem() {
        menu.menuMensagem();
        int opcaoSolicitacao = lerOpcao(scanner);

        switch (opcaoSolicitacao) {
            case 1:
                System.out.println(Mensagens.MENSAGEM_CODIFICA);
                String frase = scanner.nextLine();
                String textoCodificado = arvore.codificar(frase);
                System.out.println(Mensagens.TEXTO_MORSE + textoCodificado);
                break;

            case 2:
                System.out.println(OpcoesMenu.TABELA_LETRA_CODIGO);
                TabelaMorse.imprimirTabela();
                System.out.println(Mensagens.MENSAGEM_DECODIFICADA);
                String fraseCodificada = scanner.nextLine();
                String resultado = arvore.decodificar(fraseCodificada);
                System.out.println(Mensagens.TEXTO_TRADUZIDO + resultado);
                break;

            case 3:
                break;

            default:
                System.out.println(Mensagens.OPCAO_INVALIDA);
                break;

        }

    }

    public static int lerOpcao(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(Mensagens.OPCAO_INVALIDA);
            }
        }
    }
}

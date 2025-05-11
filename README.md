## 🌲 Tradutor Morse com Árvore Binária
Atividade da disciplina Resolução de problemas estruturados em computação
Este projeto implementa uma *árvore binária* que mapeia letras e números para seus respectivos *códigos Morse* e vice-versa. 
A árvore é construída com base nas regras do código Morse e permite traduções nos dois sentidos.

---

### Classes do Projeto

- Main: Ponto de enetrada do programa
- ArvoreCodigoMorse: Responsável por gerar a árvore e todas as funções relacionadas a ela
  - Node: Nó utilizado na árvore binária
    - Tupla: É a informação de cada nó
  - ElementosArvore: Insere os elementos pré-determinados na árvore
- Menu: gera os menus do programa
  - OpcoesMenu: "struct" com as opções do menu
  - Mensagens: "Struct" com as mensagens para uso no programa
  - NavegacaoMenu: Responsável pela navegação
- Formatadora: Formata o input do usuário, removendo acentos e cedilhas

---

### Funcionalidades

* Inserção de símbolos (letras e números) com seus respectivos códigos Morse em uma árvore binária.
* Impressão visual das árvores binárias de símbolos e de códigos morse.
* Tradução de frases de *texto normal para código Morse*.
* Tradução de frases em *código Morse para texto normal*.
* Impressão de uma tabela de conversão.

---

### Exemplo de Uso

java
String morse = "... --- ... / .- -. .-"; // SOS ANA
String textoTraduzido = arvore.codigoParaSimbolo(morse);
System.out.println(textoTraduzido); // Output: SOS ANA


---

### Exemplo de Inserção

java
arvore.inserir(".-", 'A');
arvore.inserir("-...", 'B');


---

### Requisitos

* JDK 8 ou superior
* Um ambiente para compilar e executar Java (javac e java)

---

### IDE utilizada
- Eclipse
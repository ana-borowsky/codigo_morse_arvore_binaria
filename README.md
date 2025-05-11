## 🌲 Tradutor Morse com Árvore Binária
Atividade da disciplina Resolução de problemas estruturados em computação
Este projeto implementa uma *árvore binária* que mapeia letras e números para seus respectivos *códigos Morse* e vice-versa. 
A árvore é construída com base nas regras do código Morse e permite traduções nos dois sentidos.

![Image](https://github.com/user-attachments/assets/cb3a6ff9-c3ce-48ac-a409-ffb46b0cb84c)

---
### Print do programa
![Image](https://github.com/user-attachments/assets/24a5a053-48b3-47c4-af44-391d4dfab776)
---

### Classes do Projeto

- Main: Ponto de entrada do programa
- ArvoreCodigoMorse: Responsável por gerar a árvore e todas as funções relacionadas a ela
  - Node: Nó utilizado na árvore binária
    - Tupla: É a informação de cada nó
- TabelaMorse: responsável pelos itens que serão salvos na árvore e e impressão da tabela de conversão
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
* Tradução de frases em *código Morse para texto*.
* Impressão de uma tabela de conversão de código morse para simboolos (letras e números)

---

### Exemplo de Uso

input: ... --- ...

output: SOS


input: ANA

output: .- -. .-

---

### Requisitos

* JDK 8 ou superior
* Um ambiente para compilar e executar Java (javac e java)

---

### IDE utilizada
- Eclipse

### Como rodar
Rode a classe Main do programa.
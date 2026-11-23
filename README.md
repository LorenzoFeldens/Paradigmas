# Paradigmas de Programação

Trabalhos feitos em 2015 para a disciplina de **Paradigmas de Programação**. O repositório reúne exercícios
em diferentes paradigmas: **funcional** (Haskell), **lógico** (Prolog), **imperativo** (C) e **orientado a
objetos** (Java).

## Conteúdo

| Arquivo | Linguagem | Descrição |
|---|---|---|
| [`Romualdo.c`](Romualdo.c) | C | Lê um arquivo de logins, mantém só os de até 8 caracteres em uma lista encadeada ordenada e grava `new_<arquivo>` com os e-mails `<login>@mycompany.com`. |
| [`t3.hs`](t3.hs) | Haskell | Primeiros exercícios: funções simples como par/ímpar, soma de quadrados e operações com listas. |
| [`t4.hs`](t4.hs) | Haskell | Recursão sobre listas e strings (elevar ao quadrado, verificar se um caractere está contido, remover vogais...). |
| [`t5.hs`](t5.hs) | Haskell | List comprehension e a versão recursiva das mesmas funções (sufixos, contagem de palavras curtas...). |
| [`t6/`](t6) | Haskell | Geração de imagens **SVG**: retângulos e quadrados com cores e posições calculadas. |
| [`t7.pl`](t7.pl) | Prolog | Predicados sobre listas (soma elemento a elemento, contagem regressiva...). |
| [`t10/`](t10) | Java | Aplicação Swing de cadastro de **postos de combustível** e dos seus **preços**, com banco HSQLDB. |

## t10 – Cadastro de postos

Aplicação desktop para cadastrar postos (nome fantasia, bandeira, razão social, CNPJ, endereço, bairro, CEP e
imagem) e o histórico de preços de cada combustível. Os dados ficam em um banco **HSQLDB** em arquivo
(`postosdb`), com as tabelas `POSTO` e `PRECO`. A tela valida, por exemplo, que o CNPJ tenha 14 dígitos e não
esteja repetido e que o CEP tenha 8 dígitos.

Projeto do **NetBeans** (Ant, Java 8), com classe principal `t10.T10`.

## Como executar

- **Haskell**: carregue o arquivo no GHCi, por exemplo `ghci t4.hs`, e chame as funções.
- **Prolog**: `swipl t7.pl` e faça as consultas aos predicados.
- **C**: `gcc Romualdo.c -o romualdo` e execute informando o nome de um arquivo `.txt` com um login por linha.
- **Java (t10)**: abra a pasta `t10` no NetBeans e execute.

> O repositório tem caminhos muito longos (dentro de `t10/build`). No Windows, clone com
> `git -c core.longpaths=true clone https://github.com/LorenzoFeldens/Paradigmas.git`.

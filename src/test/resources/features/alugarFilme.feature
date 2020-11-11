#language: pt

@AllCenarios

Funcionalidade: Alugar filme

  Cenario: Alugar um filme com sucesso
    Dado que o usuario queira alugar um filme com estoque 2, aluguel 3 e tipo de aluguel extendido
    Quando o usuario fizer a locacao
    Então o preço do aluguel sera R 6
    E a data de entrega sera em 1 dia
    E o estoque do filme sera 1 unidade

  @teste
  Esquema do Cenario: Dar condições de locacao conforme tipo de aluguel
    Dado um filme com estoque de 2 unidades
    E que o preço do aluguel seja R <preco>
    E que o tipo do aluguel seja <tipo>
    Quando o usuario fizer a locacao
    Então o preço do aluguel sera R <valor>
    E a data de entrega sera em <qtdDias> dias
    E a pontuacao sera de <pontuacao> pontos

    Exemplos:
      | preco | tipo      | valor | qtdDias | pontuacao |
      |   4   |   comum   |   4   |   1     |     1     |
      |  10   | extendido |  20   |   3     |     2     |
      |  5    |  semanal  |  15   |   7     |     3     |
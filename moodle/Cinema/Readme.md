# Cinema

![cover](https://github.com/qxcodepoo/arcade/raw/master/base/010/cover.jpg)

[](toc)

- [Cinema](#cinema)
  - [Intro](#intro)
  - [Diagrama](#diagrama)
  - [Shell](#shell)

O objetivo dessa atividade é implementar o sistema de alocação de uma única sala de cinema. Se existem cadeiras livres, os clientes podem reservá-las. Também podem desistir da reserva. O sistema deve mostrar quem está sentado em cada cadeira.

Nessa atividade, você deverá criar:

1. Uma classe que representa o cliente.
2. Uma classe que representa a sala de cinema e guarda os clientes.

## Intro

Seu sistema deverá:

- **Inicializando.**
  - Iniciar a sala de cinema.
    - Ao iniciar, você deve informar quantos assentos existem na sua sala.
  - Mostrar o estado da sala, escrevendo um - para cada cadeira vazia.
  - Se uma nova sala for iniciada, apague todas as informações da sala antiga.
- **Reservas.**
  - reservar uma cadeira para um cliente passando id, telefone e número da cadeira.
    - avise que houve erro ao tentar colocar duas pessoas na mesma cadeira.
    - avise que houve erro ao tentar colocar duas pessoas com mesmo id na sala.
    - atualize a função show para mostrar os clientes onde estiverem sentados.
- **Cancelamentos.**
  - Cancele reserva passando o id do cliente.

***

## Diagrama


![diagrama](https://github.com/qxcodepoo/arcade/raw/master/base/010/diagrama.png)


***

## Shell

```bash
$show
[ ]
$init 5
$show
[ - - - - - ]
$init 4
$show
[ - - - - ]
$init 4
$reservar davi 3232 0
$reservar joao 3131 3
$show
[ davi:3232 - - joao:3131 ]
$reservar rute 3030 0
fail: cadeira ja esta ocupada
$reservar davi 3234 2
fail: cliente ja esta no cinema
$reservar davi 3232 5
fail: cadeira nao existe
$cancelar davi
$cancelar rita
fail: cliente nao esta no cinema
$show
[ - - - joao:3131 ]
$end
```


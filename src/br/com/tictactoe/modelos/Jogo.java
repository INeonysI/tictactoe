package br.com.tictactoe.modelos;

import java.util.Scanner;

public class Jogo {
    Tabuleiro tabuleiro = new Tabuleiro();
    private int rodada = 1;
    private char jogador;
    private Character vencedor = ' ';

    //jogador 1 -> x
    //jogador 2 -> o
    public void joga(int posicao) {
        int x, y;
        if (rodada % 2 == 1) {
            jogador = 'x';
        } else {
            jogador = 'o';
        }

        if (posicao <= 3 ) {
            x= 0;
            y = posicao - 1;
        } else if(posicao <= 6){
            x = 1;
            y = posicao - 4;
        } else  {
            x = 2;
            y = posicao - 7;
        }

        if (tabuleiro.setTable(x, y, jogador) == 0) {
            rodada++;
        } else {
            System.out.println("Posição já jogada! Tente uma posião válida.")

            ;
        }
    }

    public void play() {
        Scanner scan = new Scanner(System.in);
        while (vencedor.equals(' ') && rodada <= 9) {
            System.out.println("Rodada " + rodada + "\n");
            tabuleiro.imprimeTabuleiro();
            if (rodada % 2 == 1) {
                System.out.println("\nVez do jogador 1. Digite sua jogada: ");
            } else {
                System.out.println("\nVez do jogador 2. Digite sua jogada: ");
            }
            joga(scan.nextInt());
            vencedor = tabuleiro.verificaVencedor();
            System.out.println("----------------------");
        }

        tabuleiro.imprimeTabuleiro();
        if (vencedor.equals(' ')) {
            System.out.println("\nDeu velha!");
        } else if(vencedor.equals('x')) {
            System.out.println("\nJogador 1 venceu. Parabéns!");
        } else if(vencedor.equals('o')){
            System.out.println("\nJogador 2 vence. Parabéns!");
        }
        System.out.println("Fim de jogo");
    }
}

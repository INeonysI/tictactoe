package br.com.tictactoe.modelos;

public class Tabuleiro {
    private Character[][] table = new Character[3][3];

    public Tabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = ' ';
            }
        }
    }

    // x | o | x
    // x | x | o
    //   | o | o
    public void imprimeTabuleiro() {
        for (int i = 0; i < 3; i++) { // Colunas
            for (int j = 0; j < 3; j++){ // linhas
                if (j != 2){
                    System.out.print(table[i][j] + " | ");
                } else {
                    System.out.print(table[i][j] + "\n");
                }
            }
        }
    }


    public int setTable(int x, int y, char jogador) {
        if (table[x][y].equals(' ')) {
            table[x][y] = jogador;
            return 0;
        } else return 1;
    }

    public char verificaVencedor() {
        if (table[0][0].equals(table[0][1]) && table[0][1].equals(table[0][2])) {
            return table[0][0];
        }else if (table[1][0].equals(table[1][1]) && table[1][1].equals(table[1][2])) {
            return table[1][0];
        }else if (table[2][0].equals(table[2][1]) && table[2][1].equals(table[2][2])) {
            return table[2][0];
        }else if (table[0][0].equals(table[1][0]) && table[1][0].equals(table[2][0])) {
            return table[0][0];
        }else if (table[0][1].equals(table[1][1]) && table[1][1].equals(table[2][1])) {
            return table[0][1];
        }else if (table[0][2].equals(table[1][2]) && table[1][2].equals(table[2][2])) {
            return table[0][2];
        }else if (table[0][0].equals(table[1][1]) && table[1][1].equals(table[2][2])) {
            return table[0][0];
        }else if (table[0][2].equals(table[1][1]) && table[1][1].equals(table[2][0])) {
            return table[0][2];
        } else {
            return ' ';
        }
    }

}

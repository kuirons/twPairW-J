package org.coach.tdd.template;

public class GameOfLife {

    private   int stauts[][] = new int[3][3];

    public int[][] getStauts() {
        return stauts;
    }

    public int judgeCellStatus(int x, int y) {
        int sum = 0;
        for (int i = 0; i < stauts.length; i++) {
            for (int j = 0; j < stauts[i].length; j++) {
                if (stauts[i][j] == 1) {
                    sum++;
                }
            }
        }
        return sum == 2 ? stauts[x][y] : 0;
    }
}

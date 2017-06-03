package org.coach.tdd.template;

public class GameOfLife {

    public int judgeCellStatus(int[][] test) {
        int sum = 0;
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {
                if (test[i][j] == 1) {
                    sum++;
                }
            }
        }
        return sum == 2 ? test[1][1] : 0;
    }
}

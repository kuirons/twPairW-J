package org.coach.tdd.template;

public class GameOfLife {

    private int[][] status = new int[3][3];

    public int[][] getStatus() {
        return status;
    }

    public void judgeCellStatus(int x, int y) {
        int sum = 0;
        for (int i = 0; i < status.length; i++) {
            for (int j = 0; j < status[i].length; j++) {
                if (status[i][j] == 1) {
                    sum++;
                }
            }
        }
        if (sum == 3) {
            status[x][y] = 1;
        } else if (sum != 2) {
            status[x][y] = 0;
        }
    }
}

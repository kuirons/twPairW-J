package org.coach.tdd.template;

public class GameOfLife {

    private int status[][] = new int[3][3];

    public int[][] getStatus() {
        return status;
    }

    public int judgeCellStatus(int x, int y) {
        int sum = 0;
        int nextStatus;
        for (int i = 0; i < status.length; i++) {
            for (int j = 0; j < status[i].length; j++) {
                if (status[i][j] == 1) {
                    sum++;
                }
            }
        }
        if (sum == 2) {
            nextStatus = status[x][y];
        } else if (sum == 3) {
            status[x][y] = 1;
            nextStatus = 1;
        } else {
            status[x][y] = 0;
            nextStatus = 0;
        }
        return nextStatus;
    }
}

package org.coach.tdd.template;

public class GameOfLife {

    private int[][] status = new int[3][3];

    public int[][] getStatus() {
        return status;
    }

    public void judgeCellStatus(int x, int y) {
        int sum = 0;
        for (int i = x-1; i < x+2; i++) {
            for (int j = y-1; j < y+2; j++) {
                if(!judgeArrayBounds(i,j)){
                    if (status[i][j] == 1) {
                        sum++;
                    }
                }
            }
        }
        if (sum == 3) {
            status[x][y] = 1;
        } else if (sum != 2) {
            status[x][y] = 0;
        }
    }

    public boolean judgeArrayBounds(int x, int y) {
        if (x < 0 || y < 0 || x > status.length - 1 || y > status[0].length - 1) {
            return true;
        }
        return false;
    }
}

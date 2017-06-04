package io.github.ji01.gameoflife;

/**
 * Created by jiyang on 17-6-3.
 * game of life
 */

public class GameOfLife {
    public int[][] newStatus;
    private int[][] status;

    private int varX;
    private int varY;

    void setVar(int varX, int varY) {
        this.varX = varX;
        this.varY = varY;
        status = new int[varX][varY];
        newStatus = new int[varX][varY];
        int pairXYnum = (int) (varX * varY * 0.3);
        for (int i = 0; i < pairXYnum; i++) {
            status[getRandom()][getRandom()] = 1;
        }
        copyArray(newStatus, status);
    }

    private void judgeCellStatus(int x, int y) {
        int sum = 0;
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (judgeArrayBounds(i, j)) {
                    continue;
                }
                if (!(i == x && j == y)) {
                    if (status[i][j] == 1) {
                        sum++;
                    }
                }
            }
        }
        getNewCellStatus(x, y, sum);
    }

    private void getNewCellStatus(int x, int y, int sum) {
        if (sum == 3) {
            newStatus[x][y] = 1;
        } else if (sum == 2) {
            newStatus[x][y] = status[x][y];
        } else {
            newStatus[x][y] = 0;
        }
    }

    private boolean judgeArrayBounds(int x, int y) {
        return x < 0 || y < 0 || x > varX - 1 || y > varY - 1;
    }

    private void copyArray(int[][] newArr, int[][] oldArr) {
        for (int i = 0; i < varX; i++) {
            System.arraycopy(oldArr[i], 0, newArr[i], 0, varY);

        }
    }

    private int getRandom() {
        int minV = varX > varY ? varY : varX;
        int a = (int) (Math.random() * minV);
        return a;
    }

    public void refreshAllCellStatus() {
        for (int i = 0; i < varX; i++) {
            for (int j = 0; j < varY; j++) {
                judgeCellStatus(i, j);
            }
        }
        copyArray(status, newStatus);
    }

}

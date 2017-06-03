package org.coach.tdd.template;

import java.util.Scanner;

public class GameOfLife {

    private int[][] status;
    private int[][] newStatus;
    private int varX;
    private int varY;

    public int[][] getNewStatus() {
        return newStatus;
    }

    public int[][] getStatus() {
        return status;
    }

    public void judgeCellNewStatus(int x, int y) {
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


    public boolean judgeArrayBounds(int x, int y) {
        if (x < 0 || y < 0 || x > varX - 1 || y > varY - 1) {
            return true;
        }
        return false;
    }

    public boolean checkInput(String input) {
        boolean flag = false;
        if (input.isEmpty()) {
            flag = false;
        } else {
            String[] inputs = input.split(",");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            if (x >= 3 && y >= 3) {
                varX = x;
                varY = y;
                status = new int[varX][varY];
                newStatus = new int[varX][varY];
                flag = true;
            }
        }
        return flag;
    }


    public void copyArray(int[][] newArr, int[][] oldArr) {
        for (int i = 0; i < varX; i++) {
            for (int j = 0; j < varY; j++) {
                newArr[i][j] = oldArr[i][j];
            }

        }
    }

    public void getInput() {
        System.out.println("请输入(x,y)格式的两个数字:");
        Scanner scanner = new Scanner(System.in);
        if (checkInput(scanner.nextLine())) {
            int pairXYnum = (int) (varX * varY * 0.3);
            for (int i = 0; i < pairXYnum; i++) {
                status[getRandom()][getRandom()] = 1;
            }
            copyArray(newStatus, status);
            recycleGame30Times();
        } else {
            System.out.println("格式错误，请重新输入");
            getInput();
        }
        scanner.close();
    }

    public int getRandom() {
        int minV = varX > varY ? varY : varX;
        int a = (int) (Math.random() * minV);
        return a;
    }

    public void recycleGame30Times() {
        for (int i = 0; i < 30; i++) {
            refreshPrint();
            refreshAllCellStatus();
            copyArray(status, newStatus);
        }
    }

    private void refreshPrint() {
        for (int i = 0; i < varX; i++) {
            for (int j = 0; j < varY; j++) {
                char c = status[i][j] == 1 ? '*' : '-';
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }

    public void refreshAllCellStatus() {
        for (int i = 0; i < varX; i++) {
            for (int j = 0; j < varY; j++) {
                judgeCellNewStatus(i, j);
            }
        }
    }

    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.getInput();
    }

}

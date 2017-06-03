package org.coach.tdd.template;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameOfLife {

    private int[][] status;
    private int[][] newStatus;
    private int varX;
    private int varY;

    public int[][] getStatus() {
        return status;
    }

    public void judgeCellStatus(int x, int y) {
        int sum = 0;

        for (int i = x - 1; i < x + 2; i++) {
            if (!(i < 0 || i > varX - 1)) {
                for (int j = y - 1; j < y + 2; j++) {
                    if (!(j < 0 || j > varY - 1)) {
                        if (!(i == x && j == y)) {
                            if (status[i][j] == 1) {
                                sum++;
                            }
                        }
                    }
                }
            }
        }
//        System.out.print(sum + " \n");
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
        if (input.isEmpty()) {
            return false;
        }
        String[] inputs = input.split(",");
        int x = Integer.parseInt(inputs[0]);
        int y = Integer.parseInt(inputs[1]);
        if (x >= 3 && y >= 3) {
            varX = x;
            varY = y;
            status = new int[varX][varY];
            newStatus = new int[varX][varY];
            return true;
        }
        return false;
    }


    public void copyArray(int newArr[][], int oldArr[][]) {
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
            int pairXYnum = (int) (varX * varY * 0.15);
//            for (int i = 0; i < pairXYnum; i++) {
//                status[getRandom()][getRandom()] = 1;
//            }
            status[1][1] = 1;
            status[2][2] = 1;
            status[3][3] = 1;
            status[0][0] = 1;
            status[0][1] = 1;
            copyArray(newStatus, status);
            recycleGame30Times();
        } else {
            System.out.println("格式错误，请重新输入");
            getInput();
        }
        scanner.close();
    }

    public int getRandom() {
        Random random = new Random(25);
        return random.nextInt(varX > varY ? varY : varX);
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
                judgeCellStatus(i, j);
            }
        }
    }

    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.getInput();
    }

}

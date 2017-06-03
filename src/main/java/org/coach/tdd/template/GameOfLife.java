package org.coach.tdd.template;

import java.util.Random;
import java.util.Scanner;

public class GameOfLife {

    private int[][] status;
    private int varX;
    private int varY;

    public int[][] getStatus() {
        return status;
    }

    public void judgeCellStatus(int x, int y) {
        int sum = 0;
        int[][] newStatus = status;
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (!judgeArrayBounds(i, j)) {
                    if (newStatus[i][j] == 1) {
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
            return true;
        }
        return false;
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

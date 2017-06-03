package org.coach.tdd.template;

import java.io.IOException;
import java.util.Scanner;

public class GameOfLife {

    private int[][] status = new int[3][3];
    private int varX;
    private int varY;

    public int[][] getStatus() {
        return status;
    }

    public void judgeCellStatus(int x, int y) {
        int sum = 0;
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (!judgeArrayBounds(i, j)) {
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
            return true;
        }
        return false;
    }


    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        if (checkInput(scanner.nextLine())) {
            
        } else {
            System.out.println("格式错误，请重新输入");
            getInput();
        }
        scanner.close();
    }


    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.getInput();
    }
}

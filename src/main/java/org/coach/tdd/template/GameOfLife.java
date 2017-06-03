package org.coach.tdd.template;

public class GameOfLife {

    private   int stauts[][] = new int[3][3];

    public int[][] getStauts() {
        return stauts;
    }

    public int judgeCellStatus(int x, int y) {
        int sum = 0;
        int nextStatus;
        for (int i = 0; i < stauts.length; i++) {
            for (int j = 0; j < stauts[i].length; j++) {
                if (stauts[i][j] == 1) {
                    sum++;
                }
            }
        }
        if(sum==2){
            nextStatus=stauts[x][y];
        }
        else if(sum==3){
            stauts[x][y]=1;
            nextStatus=1;
        }
        else{
            stauts[x][y]=0;
            nextStatus=0;
        }
        return nextStatus;
    }
}

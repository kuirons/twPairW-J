package org.coach.tdd.template;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameOfLifeTest {
    private GameOfLife gameOfLife = new GameOfLife();
    private int[][] test = gameOfLife.getStatus();

    @Test
    public void ifCellAroundAllDeadReturnDead() {
        gameOfLife.judgeCellStatus(1, 1);
        assertEquals(0, test[1][1]);
    }

    @Test
    public void ifCellAroundHaveOneCellLivedReturnDead() {
        test[0][0] = 1;
        gameOfLife.judgeCellStatus(1, 1);
        assertEquals(0, test[1][1]);
    }

    @Test
    public void ifCellAroundHaveTwoCellLivedReturnLastStatus() {
        test[0][1] = 1;
        test[0][2] = 1;
        gameOfLife.judgeCellStatus(1, 1);
        assertEquals(test[1][1], test[1][1]);
    }

    @Test
    public void ifCellAroundHaveThreeCellLivedReturnLastStatus() {
        test[0][0] = 1;
        test[0][1] = 1;
        test[0][2] = 1;
        gameOfLife.judgeCellStatus(1, 1);
        assertEquals(1, test[1][1]);

    }

    @Test
    public void ifCellAroundHaveMoreThanTreeAliveReturnDead() {
        test[0][0] = 1;
        test[0][1] = 1;
        test[0][2] = 1;
        test[1][2] = 1;
        test[2][1] = 1;
        gameOfLife.judgeCellStatus(1, 1);
        assertEquals(0, test[1][1]);
    }
}

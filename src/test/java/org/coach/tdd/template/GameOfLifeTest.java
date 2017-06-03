package org.coach.tdd.template;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void ifCellAtLeftTop() {
        test[0][1] = 1;
        test[1][1] = 1;
        test[1][0] = 1;
        gameOfLife.judgeCellStatus(0, 0);
        assertEquals(1, test[0][0]);
    }

    @Test
    public void judgeArrayBoundsLeftTop() {
        assertTrue(gameOfLife.judgeArrayBounds(-1, -1));
    }

    @Test
    public void judgeArrayBoundsRightBottom() {
        assertTrue(gameOfLife.judgeArrayBounds(test.length, test[0].length));
    }
}

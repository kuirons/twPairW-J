package org.coach.tdd.template;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class GameOfLifeTest {
    private GameOfLife gameOfLife = new GameOfLife();

    @Before
    public void init() {
        gameOfLife.checkInput("3,3");
    }

    @Test
    public void ifCellAroundAllDeadReturnDead() {
        gameOfLife.judgeCellStatus(1, 1);
        assertEquals(0, gameOfLife.getStatus()[1][1]);
    }

    @Test
    public void ifCellAroundHaveOneCellLivedReturnDead() {
        gameOfLife.getStatus()[0][0] = 1;
        gameOfLife.judgeCellStatus(1, 1);
        assertEquals(0, gameOfLife.getStatus()[1][1]);
    }

    @Test
    public void ifCellAroundHaveTwoCellLivedReturnLastStatus() {
        gameOfLife.getStatus()[0][1] = 1;
        gameOfLife.getStatus()[0][2] = 1;
        gameOfLife.judgeCellStatus(1, 1);
        assertEquals(gameOfLife.getStatus()[1][1], gameOfLife.getStatus()[1][1]);
    }

    @Test
    public void ifCellAroundHaveThreeCellLivedReturnLastStatus() {
        gameOfLife.getStatus()[0][0] = 1;
        gameOfLife.getStatus()[0][1] = 1;
        gameOfLife.getStatus()[0][2] = 1;
        gameOfLife.judgeCellStatus(1, 1);
        assertEquals(1, gameOfLife.getNewStatus()[1][1]);
    }

    @Test
    public void ifCellAroundHaveMoreThanTreeAliveReturnDead() {
        gameOfLife.getStatus()[0][0] = 1;
        gameOfLife.getStatus()[0][1] = 1;
        gameOfLife.getStatus()[0][2] = 1;
        gameOfLife.getStatus()[1][2] = 1;
        gameOfLife.getStatus()[2][1] = 1;
        gameOfLife.judgeCellStatus(1, 1);
        assertEquals(0, gameOfLife.getStatus()[1][1]);
    }

    @Test
    public void ifCellAtLeftTop() {
        gameOfLife.getStatus()[0][1] = 1;
        gameOfLife.getStatus()[1][1] = 1;
        gameOfLife.getStatus()[1][0] = 1;
        gameOfLife.copyArray(gameOfLife.getNewStatus(), gameOfLife.getStatus());
        gameOfLife.judgeCellStatus(0, 0);
        assertEquals(1, gameOfLife.getNewStatus()[0][0]);
    }

    @Test
    public void judgeArrayBoundsLeftTop() {
        assertTrue(gameOfLife.judgeArrayBounds(-1, -1));
    }

    @Test
    public void judgeArrayBoundsRightBottom() {
        assertTrue(gameOfLife.judgeArrayBounds(
                gameOfLife.getStatus().length,
                gameOfLife.getStatus()[0].length));
    }

    @Test
    public void isInputSuccess() {
        assertTrue(gameOfLife.checkInput("3,3"));
    }
}

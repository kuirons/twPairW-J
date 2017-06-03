package org.coach.tdd.template;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameOfLifeTest {
    private GameOfLife gameOfLife = new GameOfLife();
    private int test[][] = new int[3][3];
    @Test
    public void ifCellAroundAllDeadReturnDead() {
        assertEquals(0, gameOfLife.judgeCellStatus(test));
    }

    @Test
    public void ifCellAroundHavaOneCellLivedReturnDead() {
        test[0][0] = 1;
        assertEquals(0, gameOfLife.judgeCellStatus(test));
    }
    @Test
    public void ifCellAroundHavaTwoCellLivedReturnLastStatus() {
        test[0][0] = 1;
        test[0][1] = 1;
        int status = test[1][1];
        assertEquals(status, gameOfLife.judgeCellStatus(test));
    }
}

package org.coach.tdd.template;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.lang.reflect.Array;

public class GameOfLifeTest {
    private int test[][] = new int[3][3];
    GameOfLife gameOfLife = new GameOfLife();
    @Test
    public void IfCellAroundAllDeadReturnDead() {
        assertEquals(0, gameOfLife.judgeCellStatus(test));
    }

    @Test
    public void IfCellAroundHavaOneCellLivedReturnDead() {
        test[0][0] = 1;
        assertEquals(0, gameOfLife.judgeCellStatus(test));
    }
}

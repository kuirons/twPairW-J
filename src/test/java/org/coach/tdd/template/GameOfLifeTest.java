package org.coach.tdd.template;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.lang.reflect.Array;

public class GameOfLifeTest {
    @Test
    public void IfCellAroundAllDeadReturnDead() {
        int test[][]=new int[3][3];
        GameOfLife gameoflife=new GameOfLife();
        assertEquals(0,gameoflife.judgeCellStatus(test));
    }
}

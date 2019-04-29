package com.devsmms.test;

import com.devsmms.mindgames.game.controllers.ChessGameController;
import com.devsmms.mindgames.game.controllers.GameController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GameTest {

    GameController gc;

    @Before
    public void setUp(){
        gc = new ChessGameController();
    }

    @Test
    public void testValidCoordinate() {
        String coord1 = "a2";
        boolean res1 = gc.coordinatesValidation(coord1);
        String coord2 = "2b";
        boolean res2 = gc.coordinatesValidation(coord2);

        assertEquals(true, res1);
        assertEquals(false, res2);

    }
}

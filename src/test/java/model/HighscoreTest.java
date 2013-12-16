/******************************************************************************
 * This work is applicable to the conditions of the MIT License,              *
 * which can be found in the LICENSE file, or at                              *
 * https://github.com/philippwinter/pacman/blob/master/LICENSE                *
 *                                                                            *
 * Copyright (c) 2013 Philipp Winter, Jonas Heidecke & Niklas Kaddatz         *
 ******************************************************************************/

package model;

import controller.MainController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * HighscoreTest
 *
 * @author Philipp Winter
 * @author Jonas Heidecke
 * @author Niklas Kaddatz
 */
public class HighscoreTest {

    private Highscore instance;
    private Position pos;
    private Pacman pac;

    @Before
    public void setUp() {
        MainController.reset();

        pos = Game.getInstance().getMap().getPositionContainer().get(0,0);
        pac = new Pacman(pos, "Mr. Pacman");
        instance = pac.getHighscore();
    }

    @Test
    public void testGetScore() {
        assertEquals(0, instance.getScore());
    }

    @Test
    public void testAddToScore() {
        assertEquals(0, instance.getScore());
        Ghost g = new Ghost(pos, "Blue Guy", Colour.BLUE);
        instance.addToScore(g);
        assertEquals(g.getScore(), instance.getScore());
    }

    @Test
    public void testGetApplicableObject() {
        assertSame(pac, instance.getApplicableObject());
    }

    @Test
    public void testEquals() {
        assertEquals(instance, pac.getHighscore());
    }
}

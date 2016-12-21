package com.crazylabz.io;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TicTacToeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private TicTacToe ticTacToe;

    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
        ticTacToe = new TicTacToe();
    }

    @Test
    public void playerXMarkTopLeft(){
        new Player("x").steps(0);
        assertBord(
                        " x |   |   \n" +
                        "-----------\n" +
                        "   |   |   \n" +
                        "-----------\n" +
                        "   |   |   \n");
    }

    @Test
    public void playerXMarkTopLeftPlayerOMarkTopRight(){
        new Player("x").steps(0);
        new Player("o").steps(2);
        assertBord(
                        " x |   | o \n" +
                        "-----------\n" +
                        "   |   |   \n" +
                        "-----------\n" +
                        "   |   |   \n");
    }

    @Test
    public void playerXMarkFirstTopLeftPlayerOMarkTopRight(){
        new Player("x").steps(0, 1);
        new Player("o").steps(2);
        assertBord(
                        " x | x | o \n" +
                        "-----------\n" +
                        "   |   |   \n" +
                        "-----------\n" +
                        "   |   |   \n");
    }

    @Test
    public void playerXWinGivenTopRowMarked(){
        new Player("x").steps(0, 1, 2);
        new Player("o").steps(3, 4);
        assertBord(
                        " w | i | n \n" +
                        "-----------\n" +
                        " o | o |   \n" +
                        "-----------\n" +
                        "   |   |   \n");
    }

    @Test
    public void playerXWinGivenRightColumnMarked(){
        new Player("x").steps(0, 3, 6);
        new Player("o").steps(1, 4);
        assertBord(
                        " w | o |   \n" +
                        "-----------\n" +
                        " i | o |   \n" +
                        "-----------\n" +
                        " n |   |   \n");
    }

    @Test
    public void playerXWinGivenRightDiagonalMarked(){
        new Player("x").steps(2, 4, 6);
        new Player("o").steps(0, 1);
        assertBord(
                        " o | o | w \n" +
                        "-----------\n" +
                        "   | i |   \n" +
                        "-----------\n" +
                        " n |   |   \n");
    }

    private void assertBord(String actual) {
        ticTacToe.printBord();
        assertThat(actual, is(outContent.toString()));
    }

    private class Player {
        String player = "";
        public Player(String player){
            this.player = player;
        }

        public void steps(int...steps){
            Arrays.stream(steps).forEach(s -> ticTacToe.play(player, s));
        }
    }
}

package com.epam.gameoflife.app;

import com.epam.gameoflife.tick.Seed;
import com.epam.gameoflife.tick.Shapes;
import com.epam.gameoflife.world.Matrix;

/**
 * Main class of the app.
 */
public class GameOfLife {

    /**
     * Entry point of the game.
     */
    public static void main(String[] args) throws InterruptedException {
        int usersChoice = GameTemplate.startTheGame();

        GameTemplate game = new GameTemplate(new Matrix(new Seed(Shapes.numberToShape(usersChoice))));
        game.playTheGame(game.matrix);
    }

}

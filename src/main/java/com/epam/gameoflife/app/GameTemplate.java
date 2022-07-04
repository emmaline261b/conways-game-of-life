package com.epam.gameoflife.app;

import com.epam.gameoflife.gui.PrintCommander;
import com.epam.gameoflife.gui.UserScanner;
import com.epam.gameoflife.world.Matrix;
import com.epam.gameoflife.world.WorldStatusCheck;

import static java.lang.Thread.sleep;

/**
 * Game runtime class.
 *
 * @author Malgorzata Lasota
 */
public final class GameTemplate {

    //==== variables ====
    Matrix matrix;
    Evolution evolution;
    UserScanner userScanner;
    PrintCommander printCommander;

    //==== constructors ====
    public GameTemplate() {
    }

    public GameTemplate(Matrix matrix) {
        this.matrix = matrix;
        this.evolution = new Evolution(matrix);
        this.userScanner = new UserScanner();
        this.printCommander = new PrintCommander(matrix);
    }

    //==== methods ====

    /**
     * Prepares the world.
     *
     * @author Malgorzata Lasota
     */
    public static int startTheGame() {
        PrintCommander printCommander = new PrintCommander();
        UserScanner userScanner = new UserScanner();
        return printCommander.showGUI(userScanner);
    }

    /**
     * Starts the game.
     *
     * @author Malgorzata Lasota
     */
    public void playTheGame(Matrix matrix) {
        printCommander.showFramedWorld(matrix);
        WorldStatusCheck wsc = new WorldStatusCheck(matrix);

        while (!wsc.shouldTheWorldEnd()) {
            try {
                matrix = evolution.evolve(printCommander);
                printCommander.showFramedWorld(matrix);
                sleep(400);
            } catch (InterruptedException ignored) {
            }
        }
        ;

        evolution.endTheGame(printCommander);

    }

}

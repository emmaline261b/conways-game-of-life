package com.epam.gameoflife.gui;

import com.epam.gameoflife.Grid;
import com.epam.gameoflife.tick.Seed;
import com.epam.gameoflife.tick.Shapes;
import com.epam.gameoflife.world.Matrix;

public class PrintCommander {

    //==== variables ====
    public final char ALIVE_POINTER = '★';
    //۞
    //༓  ❄
    //፨ ⵘ ⠝
    //៙ ◉ ● ◌ ⚫ ⚪ ⚽ ⭕
    //᳀ ❌ ✖
    //⃞ ⏹ ⏺ █ ░ ⬛ ⬜
    //★ ☆ ⭐ ✹ ✴ ✳ ✨
    public final char DEAD_POINTER = '☆';
    public Frame frame;

    //==== constructors ====
    public PrintCommander() {
    }

    public PrintCommander(Matrix matrix) {
        this.frame = new Frame(matrix);
    }

//    public static void main(String[] args) {
//        Matrix matrix = new Matrix(5 ,5, new Seed(Shapes.BLINKER));
//        PrintCommander pc = new PrintCommander(matrix);
//        pc.showFramedWorld(matrix);
//    }
    //====== methods =======
    public int showGUI(UserScanner userScanner) {
        welcome();
        chooseYourBattle();
        int choice = userScanner.getUsersChoice();
        confirmTheChoice(choice);
        return choice;
    }

    public void welcome() {
        String welcome = """
                 __       __   _______  _______        __       _______.        ___           _______      ___      .___  ___.  _______\s
                |  |     |  | |   ____||   ____|      |  |     /       |       /   \\         /  _____|    /   \\     |   \\/   | |   ____|
                |  |     |  | |  |__   |  |__         |  |    |   (----`      /  ^  \\       |  |  __     /  ^  \\    |  \\  /  | |  |__  \s
                |  |     |  | |   __|  |   __|        |  |     \\   \\         /  /_\\  \\      |  | |_ |   /  /_\\  \\   |  |\\/|  | |   __| \s
                |  `----.|  | |  |     |  |____       |  | .----)   |       /  _____  \\     |  |__| |  /  _____  \\  |  |  |  | |  |____\s
                |_______||__| |__|     |_______|      |__| |_______/       /__/     \\__\\     \\______| /__/     \\__\\ |__|  |__| |_______|""";

        System.out.println(welcome);
        System.out.println();
    }

    public void chooseYourBattle() {
        System.out.println("CHOOSE THE SHAPE YOU WANT TO START WITH:");
        System.out.println();
        printShapesByName();
        System.out.print("TYPE IN WHICH SHAPE YOU WANT TO START WITH? => ");
    }

    private void printShapesByName() {
        for (int i = 0; i < Shapes.values().length; i++) {
            int ordinalPlusOne = Shapes.values()[i].ordinal() + 1;
            System.out.println(" * " + ordinalPlusOne + ". * " + Shapes.values()[i].name() + " * ");
        }
        System.out.println();
    }

    public void showFramedWorld(Matrix matrix) {
        printUpperBoundary();
        for (int i = 0; i < Grid.DEFAULT_HEIGHT; i++) {
            printLeft();
            if (matrix == null) {
                printVoid();
            } else {
                printMatrixLine(i, matrix);
            }
            printRight();
        }
        PrintLowerBoundary();
        //System.out.println("TO BREAK CLICK => CTRL + 2.");

    }

    private void PrintLowerBoundary() {
        for (int i = 0; i < frame.frameWidth; i++) {
            System.out.print(frame.horizontalBorder);
        }
        System.out.println();

    }

    private void printRight() {
        System.out.println(" " + frame.verticalBorder);
    }

    private void printVoid() {
        for (int x = 0; x < Grid.DEFAULT_WIDTH; x++) {
            System.out.print(".");
        }
    }

    private void printMatrixLine(int y, Grid mGrid) {
        try {
            for (int x = 0; x < Grid.DEFAULT_WIDTH; x++) {
                if (mGrid.getCellFromTheGrid(y, x).isAlive()) {
                    System.out.print(ALIVE_POINTER);
                } else {
                    System.out.print(DEAD_POINTER);
                }
            }
        } catch (IndexOutOfBoundsException ignored) {}
    }

    private void printLeft() {
        System.out.print(frame.verticalBorder + " ");
    }

    private void printUpperBoundary() {
        for (int i = 0; i < frame.frameWidth / 2 - 8; i++) {
            System.out.print(frame.horizontalBorder);
        }
        System.out.print(" ROUND NO. " + Frame.frameNumber + "  ");
        for (int i = 0; i < frame.frameWidth / 2 - 8; i++) {
            System.out.print(frame.horizontalBorder);
        }
        System.out.println();
    }

    public void confirmTheChoice(int choice) {
        System.out.println("YOU CHOSE OPTION NO. " + choice + " - " + Shapes.values()[choice - 1].toString().toUpperCase() + ".");
        System.out.println("THE GAME IS PREPARING...");
    }

    public void goodbye() {
        String goodbye = """
                  _______      ___      .___  ___.  _______         ______   ____    ____  _______ .______     \s
                 /  _____|    /   \\     |   \\/   | |   ____|       /  __  \\  \\   \\  /   / |   ____||   _  \\    \s
                |  |  __     /  ^  \\    |  \\  /  | |  |__         |  |  |  |  \\   \\/   /  |  |__   |  |_)  |   \s
                |  | |_ |   /  /_\\  \\   |  |\\/|  | |   __|        |  |  |  |   \\      /   |   __|  |      /    \s
                |  |__| |  /  _____  \\  |  |  |  | |  |____       |  `--'  |    \\    /    |  |____ |  |\\  \\----.
                 \\______| /__/     \\__\\ |__|  |__| |_______|       \\______/      \\__/     |_______|| _| `._____|
                                                                                                               \s""";

        System.out.println(goodbye);
        System.out.println();

    }

}
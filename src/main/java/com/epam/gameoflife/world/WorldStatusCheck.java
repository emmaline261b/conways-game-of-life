package com.epam.gameoflife.world;

// TODO: 27/03/2022 can i make it private or package private?
final public class WorldStatusCheck {

    //==== variables ====
    Matrix matrix;

    //==== constructors ====
    public WorldStatusCheck() {}

    public WorldStatusCheck(Matrix matrix) {
        this.matrix = matrix;
    }

    //==== methods ====
    public boolean shouldTheWorldEnd() {
        return checkIfEveryonesDead() || checkIfItsStillLife();

    }

    boolean checkIfEveryonesDead() {
        int counter = 0;
        for (int y = 0; y < matrix.matHeight; y++) {
            for (int x = 0; x < matrix.matWidth; x++) {
                if (matrix.matGrid[y][x].isAlive()) counter++;
            }
        }
        return ( counter == 0 );
    }

    boolean checkIfItsStillLife() {
        int counter = 0;
        for (int y = 0; y < matrix.matHeight; y++) {
            for (int x = 0; x < matrix.matWidth; x++) {
                if (matrix.matGrid[y][x].WillLive() != matrix.matGrid[y][x].isAlive()) counter++;
            }
        }
        return ( counter == 0 );
    }

}

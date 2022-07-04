package com.epam.gameoflife.app;

import com.epam.gameoflife.Cell;
import com.epam.gameoflife.Grid;
import com.epam.gameoflife.gui.Frame;
import com.epam.gameoflife.gui.PrintCommander;
import com.epam.gameoflife.tick.Seed;
import com.epam.gameoflife.tick.Shapes;
import com.epam.gameoflife.world.Matrix;

public final class Evolution {
    //==== variables ====
    Matrix matrix;

    //==== constructors ====
    public Evolution(Matrix matrix) {
        this.matrix = matrix;
    }

    //==== methods ====
    public void prepareTheWorld(int shapeNo) {
        Seed seed = new Seed(Shapes.numberToShape(shapeNo));
        matrix = matrix.getShallowCopy(seed);
    }

    public Matrix evolve(PrintCommander printCommander) {
        applyTheRules();
        Matrix newMatrix = theNewDayComes();
        //===
        matrix = newMatrix;
        return newMatrix;
    }

    Matrix theNewDayComes() {
        Matrix newMatrix = new Matrix(matrix); //deep copy == completely new world created
        for (int y = 0; y < Grid.DEFAULT_HEIGHT; y++) {
            for (int x = 0 ; x < Grid.DEFAULT_WIDTH; x++) {
                newMatrix.getCellFromTheGrid(y, x).setIsAlive(newMatrix.getCellFromTheGrid(y, x).willLive());
                newMatrix.getCellFromTheGrid(y, x).setWillLive(false);
            }
        }
        Frame.addOneToFrameNumber();
        return newMatrix;
    }

    private void applyTheRules() {
        Grid mGrid = matrix;
        for (int y = 0; y < Grid.DEFAULT_HEIGHT; y++) {
            for (int x = 0 ; x < Grid.DEFAULT_WIDTH; x++) {
                mGrid.getCellFromTheGrid(y, x).countAliveNeighbors(matrix);
            }
        }
        willSurviveEvolution();
    }

    private void willSurviveEvolution() {
        for (int y = 0; y < Grid.DEFAULT_HEIGHT; y++) {
            for (int x = 0 ; x < Grid.DEFAULT_WIDTH; x++) {
                Cell testCell = matrix.getCellFromTheGrid(y, x);
                if (testCell.isAlive()) {
                    whatWillHappen(testCell);
                }
                if (!testCell.isAlive()) {
                    willResurrect(testCell);
                }
            }
        }
    }

    private void whatWillHappen(Cell testCell) {
        switch (testCell.countAliveNeighbors(matrix)) {
            case 0, 1, 4, 5, 6, 7, 8:
                testCell.setWillLive(false);
                break;
            case 2, 3:
                testCell.setWillLive(true);
                break;
            default:
                throw new IllegalStateException("Unexpected value: ");
        }
    }

    private void willResurrect(Cell testCell) {
        Cell test = testCell;
        if (test.countNeighbors(matrix).size() == 3) {
            test.setWillLive(true);
        }
    }

    private boolean checkIfDead() {
        Grid mGrid = matrix;
        for (int y = 0; y < Grid.DEFAULT_HEIGHT; y++) {
            for (int x = 0; x < Grid.DEFAULT_WIDTH; x++) {
                if (mGrid.getCellFromTheGrid(y, x).isAlive() == true) return false;
            }
        }
        return true;
    }

    void endTheGame(PrintCommander printCommander) {
        printCommander.goodbye();

    }

}

package com.epam.gameoflife.world;

import com.epam.gameoflife.Cell;
import com.epam.gameoflife.Grid;
import com.epam.gameoflife.Point;

public class SeedInjector {

    //==== variables ====

    //==== constructors ====
    public SeedInjector() {}

    //==== methods ====
    private Point getTheBeginningPoint(Grid mGrid, Grid sGrid) {
        Point matMPoint = mGrid.getTheMidpoint();
        Point seedMPoint = sGrid.getTheMidpoint();
        return new PointOnMatrix(matMPoint.getYPoint() - seedMPoint.getYPoint(),
                matMPoint.getXPoint() - seedMPoint.getXPoint());
    }

    void injectTheSeed(Grid mGrid, Grid sGrid) {
        copyTheSeed(mGrid, sGrid);
    }

    private void copyTheSeed(Grid mGrid, Grid sGrid) {
        Point matBPoint = getTheBeginningPoint(mGrid, sGrid);
        for (int y = matBPoint.getYPoint(); y < matBPoint.getYPoint() + sGrid.getHeight(); y++) {
            for (int x = matBPoint.getXPoint(); x < matBPoint.getXPoint() + sGrid.getWidth(); x++) {
                Cell temp = (Cell)sGrid.getCellFromTheGrid(y - matBPoint.getYPoint(),
                        x - matBPoint.getXPoint());
                mGrid.setTheCellInTheGrid(temp.isAlive(), y, x);
            }
        }
    }
}

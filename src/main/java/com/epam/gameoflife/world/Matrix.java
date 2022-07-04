package com.epam.gameoflife.world;

import com.epam.gameoflife.Cell;
import com.epam.gameoflife.Grid;

import java.util.Random;

public final class Matrix implements Grid {

    //==== variables ====
    int matWidth;
    int matHeight;
    MatCell[][] matGrid;
    SeedInjector seedInjector = new SeedInjector();

    //==== constructors ====
    public Matrix() {
        this.matHeight = DEFAULT_HEIGHT;
        this.matWidth = DEFAULT_WIDTH;
        this.matGrid = new MatCell[matHeight][matWidth];
        fillTheGrid();
    }

    public Matrix(Grid sGrid) {
        this();
        seedInjector.injectTheSeed(this, sGrid);
    }

    public Matrix(int matHeight, int matWidth, Grid sGrid) {
        this.matHeight = matHeight;
        this.matWidth = matWidth;
        this.matGrid = new MatCell[matHeight][matWidth];
        fillTheGrid();
        seedInjector.injectTheSeed(this, sGrid);

    }

    public Matrix(Matrix that) {
        this.matWidth = that.matWidth;
        this.matHeight = that.matHeight;
        this.matGrid = getDeepCopyOf(that.matGrid);
        this.seedInjector = that.seedInjector;
    }

    //==== methods ====
    public Matrix getShallowCopy(Grid sGrid) {
        //copies the whole matrix
        this.matWidth = DEFAULT_WIDTH;
        this.matHeight = DEFAULT_HEIGHT;
        fillTheGrid();
        seedInjector.injectTheSeed(this, sGrid);
        return this;
    }

     MatCell[][] getDeepCopyOf(MatCell[][] matGrid) {
        //just the matGrid -> requires running a constructor
        MatCell[][] newMatGrid = new MatCell[matGrid.length][matGrid[0].length];
        for (int y = 0; y < matGrid.length; y++) {
            for (int x = 0; x < matGrid[y].length; x++) {
                newMatGrid[y][x] = (MatCell) matGrid[y][x].getCellCopy();
                newMatGrid[y][x].numberOfAliveNeighbors = newMatGrid[y][x].countAliveNeighbors(this);
            }
        }
        return newMatGrid;
    }

    @Override
    public void fillTheGrid() {
        for (int y = 0; y < matHeight; y++) {
            for (int x = 0; x < matWidth; x++) {
                matGrid[y][x] = new MatCell(false, y, x);
            }
        }
    }

    @Override
    public void fillTheGridRandomly(Random random) {
        for (int y = 0; y < matHeight; y++) {
            for (int x = 0; x < matWidth; x++) {
                matGrid[y][x] = new MatCell(random.nextBoolean(), y, x);
            }
        }
    }

    @Override
    public PointOnMatrix getTheMidpoint() {
        int xMidpoint = this.matWidth / 2;
        int yMidpoint = this.matHeight / 2;
        return new PointOnMatrix(yMidpoint, xMidpoint);
    }

    public Cell getCellFromTheGrid(int y, int x) {
        return matGrid[y][x].getCellCopy();
    }

    @Override
    public int getHeight() {
        return matHeight;
    }

    @Override
    public int getWidth() {
        return matWidth;
    }

    @Override
    public void setTheCellInTheGrid(boolean isAlive, int y, int x) {
        this.matGrid[y][x] = new MatCell(isAlive, y, x);
    }

    public MatCell[][] getGrid() {
        return matGrid;
    }
}

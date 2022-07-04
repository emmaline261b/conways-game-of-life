package com.epam.gameoflife.world;

import com.epam.gameoflife.Cell;
import com.epam.gameoflife.Grid;
import com.epam.gameoflife.Point;

import java.util.HashSet;
import java.util.Objects;

final class MatCell implements Cell {

    //==== variables ====
    int numberOfAliveNeighbors = 0;
    private boolean isAlive;
    private boolean willLive = false;
    private final HashSet<Point> allMyNeighbors = new HashSet<>();
    private final int xPoint;
    private final int yPoint;

    //==== constructors ====
    public MatCell(boolean isAlive, int yPoint, int xPoint) {
        this.isAlive = isAlive;
        this.yPoint = yPoint;
        this.xPoint = xPoint;
    }

    public MatCell(boolean isAlive, boolean willLive, int numberOfAliveNeighbors, int xPoint, int yPoint) {
        this(isAlive, yPoint, xPoint);
        this.willLive = willLive;
        this.numberOfAliveNeighbors = numberOfAliveNeighbors;
    }

    //==== methods ====
    @Override
    public Cell getCellCopy() {
        return new MatCell(this.isAlive, this.willLive, this.numberOfAliveNeighbors, this.xPoint, this.yPoint);
        //note that you still need to count alive neighbors
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    public boolean WillLive() {
        return willLive;
    }

    public void setIsAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public boolean willLive() {
        return false;
    }

    @Override
    public int getYPoint() {
        return this.yPoint;
    }

    @Override
    public int getXPoint() {
        return this.xPoint;
    }

    public void setWillLive(boolean willLive) {
        this.willLive = willLive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!( o instanceof MatCell that )) return false;
        return xPoint == that.xPoint && yPoint == that.yPoint && allMyNeighbors.equals(that.allMyNeighbors);
    }

    @Override
    public HashSet<Point> countNeighbors(Grid mGrid) {
        Matrix matrix = new Matrix(Grid.DEFAULT_HEIGHT, Grid.DEFAULT_WIDTH, mGrid);
        HashSet<Point> neighbors = this.allMyNeighbors;
        for (int y = this.getYPoint() - 1; y <= this.yPoint + 1; y++) {
            for (int x = this.getXPoint() - 1; x <= this.getXPoint() + 1; x++) {
                if (y < 0 || y >= matrix.getHeight() || x < 0 || x >= matrix.getWidth() || ( y == this.getYPoint() && x == this.getXPoint() )) {
                } else {
                    neighbors.add(new PointOnMatrix(y, x));
                }
            }
        }
        return neighbors;
    }

    @Override
    public int countAliveNeighbors(Grid mGrid) {
        int counter = 0;
        for (Point neighbor : allMyNeighbors) {
            if (mGrid.getCellFromTheGrid(neighbor.getYPoint(),
                    neighbor.getXPoint()).isAlive()) {
                counter++;
            }
        }
        this.numberOfAliveNeighbors = counter;
        return counter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(allMyNeighbors, xPoint, yPoint);
    }
}

package com.epam.gameoflife.tick;

import com.epam.gameoflife.Cell;
import com.epam.gameoflife.Grid;
import com.epam.gameoflife.Point;

import java.util.ArrayList;
import java.util.HashSet;

final class SeedCell implements Cell {

    //==== variables ====
    private boolean isAlive = false;
    private int yPoint = 0;
    private int xPoint = 0;

    //==== constructors ====
    public SeedCell() {
    }

    public SeedCell(boolean isAlive, int yPoint, int xPoint) {
        this.isAlive = isAlive;
        this.yPoint = yPoint;
        this.xPoint = xPoint;
    }

    //==== methods ====
    @Override
    public SeedCell getCellCopy() {
        return new SeedCell(this.isAlive, this.xPoint, this.yPoint);
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public HashSet<Point> countNeighbors(Grid sGrid) {
        HashSet<Point> neighbors = new HashSet<>();
        for (int y = this.yPoint - 1; y <= yPoint + 1; y++) {
            for (int x = this.xPoint - 1; x <= xPoint + 1; x++) {
                if (y < 0 || y > sGrid.getHeight() || x < 0 || x > sGrid.getWidth() || (y == x)) {
                    continue;
                } else {
                    neighbors.add(new PointInSeed(y, x));
                }
            }
        }
        return neighbors;
    }

    @Override
    public int countAliveNeighbors(Grid sGrid) {
        int counter = 0;
        HashSet<Point> neighbors = countNeighbors(sGrid);
        for (Point neighbor : neighbors) {
            for (int y = 0; y < sGrid.getHeight(); y++) {
                for (int x = 0; x < sGrid.getWidth(); x++) {
                    if (neighbor.getYPoint() == y
                            && neighbor.getXPoint() == x
                            && sGrid.getCellFromTheGrid(y, x).isAlive()) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    @Override
    public void setWillLive(boolean b) {}

    @Override
    public void setIsAlive(boolean b) {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!( o instanceof SeedCell )) return false;
        SeedCell seedCell = (SeedCell) o;
        return isAlive == seedCell.isAlive && xPoint == seedCell.xPoint && yPoint == seedCell.yPoint;
    }

}

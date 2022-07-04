package com.epam.gameoflife.tick;

import com.epam.gameoflife.Point;

final class PointInSeed implements Point {

    //==== variables ====
    int yPoint = 0;
    int xPoint = 0;

    //==== constructors ====
    public PointInSeed() {
    }

    public PointInSeed(int yPoint, int xPoint) {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
    }

    //==== methods ====
    @Override
    public PointInSeed whatsThePoint() {
        return this;
    }

    @Override
     public int getYPoint() {
        return yPoint;
    }

    @Override
    public int getXPoint() {
        return xPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointInSeed point = (PointInSeed) o;
        return xPoint == point.xPoint && yPoint == point.yPoint;
    }
}

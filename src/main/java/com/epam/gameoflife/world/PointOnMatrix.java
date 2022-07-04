package com.epam.gameoflife.world;

import com.epam.gameoflife.Point;

final class PointOnMatrix implements Point {

    //==== variables ====
    int xPoint = 0;
    int yPoint = 0;

    //==== constructors ====
    public PointOnMatrix() {
    }

    public PointOnMatrix(int yPoint, int xPoint) {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
    }

    //==== methods ====
    @Override
    public Point whatsThePoint() {
        return this;
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
        if (o == null || getClass() != o.getClass()) return false;
        PointOnMatrix point = (PointOnMatrix) o;
        return xPoint == point.xPoint && yPoint == point.yPoint;
    }
}

package com.epam.gameoflife;

import java.util.HashSet;

public interface Cell {

    Cell getCellCopy();

    boolean isAlive();

    boolean equals(Object o);

    HashSet<Point> countNeighbors(Grid grid);

    int countAliveNeighbors(Grid grid);

    void setWillLive(boolean b);
    
    void setIsAlive(boolean b);

    boolean willLive();

    int getYPoint();

    int getXPoint();
}

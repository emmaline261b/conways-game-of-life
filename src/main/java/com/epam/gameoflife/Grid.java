package com.epam.gameoflife;

import java.util.Random;

public interface Grid {

    final int GRID_SIZE = 5;
    final int DEFAULT_SEED_WIDTH = 8;
    final int DEFAULT_SEED_HEIGHT = 8;
    final int DEFAULT_WIDTH = 100; //230
    final int DEFAULT_HEIGHT = 30; //38
    final int MAX_WIDTH = 220;

    void fillTheGrid();

    void fillTheGridRandomly(Random random);

    Point getTheMidpoint();

    Cell getCellFromTheGrid(int y, int x);

    int getHeight();

    int getWidth();

    void setTheCellInTheGrid(boolean alive, int y, int x);
}

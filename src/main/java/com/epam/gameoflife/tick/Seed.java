package com.epam.gameoflife.tick;

import com.epam.gameoflife.Cell;
import com.epam.gameoflife.Grid;

import java.util.Random;

  public final class Seed implements Grid {

    //==== variables ====
    int seedWidth;
    int seedHeight;
    SeedCell[][] seedGrid;
    PointInSeed seedMPoint;

    //==== constructors ====
    public Seed(Shapes shape) {
        this.seedWidth = shape.getTheShapeWidth();
        this.seedHeight = shape.getTheShapeHeight();
        this.seedGrid = new SeedCell[this.seedHeight][this.seedWidth];
        copyShapeToSeed(shape);
        seedMPoint = getTheMidpoint();
        // TODO: 26/03/2022  should this method be static?£?££?£?!!!?
    }

    //==== methods ====
    @Override
    public void fillTheGrid() {
        for (int y = 0; y < this.seedHeight; y++) {
            for (int x = 0; x < this.seedWidth; x++) {
                seedGrid[y][x] = new SeedCell(false, y, x);
            }
        }
    }

    @Override
    public void fillTheGridRandomly(Random random) {

    }

    // TODO: 25/03/2022 add randomly generated seed
//     void fillTheGridRandomly(Random random, int height, int width) {
//        for (int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                seedGrid[y][x] = new SeedCell(random.nextBoolean(), y, x);
//            }
//        }
//    }

    @Override
    public PointInSeed getTheMidpoint() {
        return new PointInSeed(seedHeight / 2, seedWidth / 2);
    }

    @Override
    public Cell getCellFromTheGrid(int y, int x) {
        return seedGrid[y][x];
    }

    private void copyShapeToSeed(Shapes shape) {
        for (int y = 0; y < seedHeight; y++) {
            for (int x = 0; x < seedWidth; x++) {
                if (shape.shape[y][x] == 1) {
                    seedGrid[y][x] = new SeedCell(true, y, x);
                } else {
                    seedGrid[y][x] = new SeedCell(false, y, x);
                }
            }
        }
    }

    public int getHeight() {
        return seedHeight;
    }

    public int getWidth() {
        return seedWidth;
    }

      @Override
      public void setTheCellInTheGrid(boolean alive, int y, int x) {
          this.seedGrid[y][x] = new SeedCell(alive, y, x);
      }

      public SeedCell getSeedGridCell(int y, int x) {
        return seedGrid[y][x];
    }
}

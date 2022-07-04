package com.epam.gameoflife.gui;

import com.epam.gameoflife.Grid;
import com.epam.gameoflife.world.Matrix;

 public final class Frame {

    //==== variables ====
    public static int frameNumber = 1;
    final int BUFFER = 4;
    char verticalBorder = ' ';
    char horizontalBorder = ' ';
    int frameWidth = Grid.DEFAULT_WIDTH;
    int frameHeight = Grid.DEFAULT_HEIGHT;

    //==== constructors ====
    public Frame(Matrix matrix) {
        this.frameWidth += BUFFER;
    }

    //==== methods ====
    private int countTheFrameHeight(Matrix matrix) {
        return frameHeight = Grid.DEFAULT_HEIGHT + BUFFER;
    }

    private int countTheFrameWidth(Matrix matrix) {
        return frameWidth = Grid.DEFAULT_WIDTH + BUFFER;
    };

    public static int getTheFrameNumber() {
        return frameNumber;
    }

    public static void addOneToFrameNumber() {
        frameNumber++;
    }
}

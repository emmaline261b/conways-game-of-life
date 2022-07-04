package com.epam.gameoflife.tick;

import com.epam.gameoflife.gui.PrintCommander;

public enum Shapes {

    //==== ENUMS ====
    DOT(new Integer[][]{
            {1}
    }),
    BLOCK(new Integer[][]{
            {1, 1},
            {1, 1}
    }),
    BOAT(new Integer[][]{
            {1, 1, 0},
            {1, 0, 1},
            {0, 1, 0}
    }),
    BLINKER(new Integer[][]{
            {1, 1, 1}
    }),
    TOAD(new Integer[][]{
            {0, 0, 0, 0},
            {0, 1, 1, 1},
            {1, 1, 1, 0},
            {0, 0, 0, 0}
    }),
    BEACON(new Integer[][]{
            {1, 1, 0, 0},
            {1, 1, 0, 0},
            {0, 0, 1, 1},
            {0, 0, 1, 1}
    }),
    PULSAR(new Integer[][]{
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1},
            {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
            {0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
            {1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1},
            {1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1},
            {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0}
    }),
    PENTADECATHLON(new Integer[][]{
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
            {1, 1, 0, 1, 1, 1, 1, 0, 1, 1},
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0}
    }),
    GLIDER(new Integer[][]{
            {1, 0, 1},
            {0, 1, 1},
            {0, 1, 0}
    }),
    LIGHTWEIGHT_SPACESHIP(new Integer[][]{
            {0, 0, 1, 1, 0},
            {1, 1, 0, 1, 1},
            {1, 1, 1, 1, 0},
            {0, 1, 1, 0, 0}
    }),
    MIDDLEWEIGHT_SPACESHIP(new Integer[][]{
            {0, 0, 1, 1, 0},
            {1, 1, 0, 1, 1},
            {1, 1, 1, 1, 0},
            {0, 1, 1, 0, 0}
    }),
    HEAVYWEIGHT_SPACESHIP(new Integer[][]{
            {0, 0, 1, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 1}
    }),
    RANDOM(new Integer[][]{
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0}
    });

    //==== variables ====
    final Integer[][] shape;

    //==== constructors ====
    Shapes(Integer[][] shape) {
        this.shape = shape;
    }

    //==== methods ====
    public static Shapes numberToShape(int number) {
        if (number < 1 || number > Shapes.values().length) return Shapes.TOAD;
        return Shapes.values()[number - 1];
    }

    public String enumToString(PrintCommander printCommander) {
        String result = " * " + this.name() + " * " + "\n";
        String alive = String.valueOf(printCommander.ALIVE_POINTER);
        String dead = String.valueOf(printCommander.DEAD_POINTER);

        for (int i = 0; i < this.shape.length; i++) {
            for (int j = 0; j < this.shape[i].length; j++) {
                if (this.shape[i][j] == (Integer) 0)
                    result += dead;
                if (this.shape[i][j] == (Integer) 1)
                    result += alive;
            }
            result += "\n";
        }
        return result;
    }

    public int getTheShapeWidth() {
        return shape[0].length;
    }

    public int getTheShapeHeight() {
        return shape.length;
    }

    public int getTheShapeSize() {
        return getTheShapeHeight() * getTheShapeWidth();
    }

    public int howManyAreAlive() {
        int lifeCounter = 0;
        for (int y = 0; y < getTheShapeHeight(); y++) {
            for (int x = 0; x < getTheShapeWidth(); x++) {
                if (shape[y][x] == 1) {
                    lifeCounter++;
                }
            }
        }
        return lifeCounter;
    }
}


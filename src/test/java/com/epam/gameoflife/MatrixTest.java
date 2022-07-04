package com.epam.gameoflife;

import com.epam.gameoflife.tick.Seed;
import com.epam.gameoflife.tick.Shapes;
import com.epam.gameoflife.world.Matrix;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MatrixTest {


    @BeforeMethod
    private void setup(){
        Shapes testShape = Shapes.BLOCK;
        Matrix testMatrix = new Matrix(new Seed(testShape));
    }

    @Test
    public void testFillTheGrid() {
    //given

    //when

    //then
    }

    @Test
    public void testGetTheMidpoint() {
    }

    @Test
    public void testInjectTheSeed() {
    }

    @Test
    public void testRedefineTheSizeOfTheMatrix() {
    }

    @Test
    public void testCountAliveNeighbors() {
    }
}
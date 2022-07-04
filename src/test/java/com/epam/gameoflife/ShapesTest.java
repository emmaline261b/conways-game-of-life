package com.epam.gameoflife;

import com.epam.gameoflife.gui.PrintCommander;
import com.epam.gameoflife.tick.Seed;
import com.epam.gameoflife.tick.Shapes;
import com.epam.gameoflife.world.Matrix;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ShapesTest {

    @Test(enabled = false)
    public void shouldBeAbleToGetShapeStringFromEnum() {
        //given
        PrintCommander printCommander = new PrintCommander(new Matrix(new Seed(Shapes.BLOCK)));
        Shapes shape = Shapes.BLOCK;
        String actual = """
                @@
                @@
                """;
        String alive = String.valueOf(printCommander.ALIVE_POINTER);
        String dead = String.valueOf(printCommander.DEAD_POINTER);

        //when
        String expected = shape.enumToString(printCommander);

        //then
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void testNumberToShape() {
    }
}
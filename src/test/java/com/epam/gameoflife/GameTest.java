package com.epam.gameoflife;

import com.epam.gameoflife.app.GameTemplate;
import com.epam.gameoflife.gui.PrintCommander;
import com.epam.gameoflife.tick.Seed;
import com.epam.gameoflife.tick.Shapes;
import com.epam.gameoflife.world.Matrix;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

@Test(enabled = false)
public class GameTest {

    @Test(dataProvider = "dp")
    public void testGameWorldCreation(Shapes shape, int matHeight, int matWidth, String expected) {
        //given
        Matrix matrix = new Matrix(matHeight, matWidth, new Seed(shape));
        PrintCommander pc = new PrintCommander(matrix);
        Cell[][] matGrid = matrix.getGrid();
        //when


        //then
        //Assert.assertEquals(actual, expected);

    }

    @DataProvider(name = "dp")
    public Object[][] dp() {
        return new Object[][]{
                {Shapes.DOT, 1, 1, "1"}
        };
    }
}


//    enum Assertion {
//        EQUALS((generation, evolved) -> Assert.assertEquals(generation, evolved)),
//        NOT_EQUALS((generation, evolved) -> Assert.assertNotEquals(generation, evolved));
//
//        private final BiConsumer<Generation, Generation> predicate;
//
//        Assertion(BiConsumer<Generation, Generation> predicate) {
//            this.predicate = predicate;
//        }
//    }
//}


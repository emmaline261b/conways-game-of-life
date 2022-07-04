//package com.epam.gameoflife;
//
//import com.epam.gameoflife.tick.Cell;
//import com.epam.gameoflife.tick.Seed;
//import com.epam.gameoflife.tick.Shapes;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class CellTest {
//
//    @Test
//    public void testIsAlive() {
//        //given
//        Cell cell = new Cell(true);
//        Seed seed = new Seed(Shapes.BLOCK);
//        boolean areEqual = false;
//        //when
//        for (int i = 0; i < seed.xAxis; i++) {
//            for (int j = 0; j < seed.yAxis; j++) {
//                if (cell.pointOnMatrix.yPoint == i && cell.pointOnMatrix.xPoint == j) {
//                    areEqual = true;
//                }
//            }
//        }
//        //then
//        Assert.assertTrue(areEqual);
//    }
//
//    @Test
//    public void testGetCopy() {
//        //given
//        Cell actual = new Cell(true, 8, true, 1, 1);
//        Cell shallowCopy = actual; //shallow copy
//        //when
//        Cell deepCopy = actual.getCopy();
//        //then
//        Assert.assertEquals(deepCopy, actual);
//
//
//    }
//}
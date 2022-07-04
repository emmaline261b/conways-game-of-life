//package com.epam.gameoflife;
//
//import com.epam.gameoflife.tick.Seed;
//import com.epam.gameoflife.tick.Shapes;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class SeedTest {
//
////    @Test
////    public void SeedGridIsNotNull() {
////        //given
////        Seed seed = new Seed(Shapes.BLOCK);
////        boolean isItNull = false;
////        //when
////        for (int i = 0; i < seed.yAxis; i++) {
////            for (int j = 0; j < seed.xAxis; j++) {
////                if (seed.seedGrid[i][j] == null) {
////                    isItNull = true;
////                    break;
////                };
////            }
////        }
////        //then
////        Assert.assertFalse(isItNull);
////    }
//
////    @Test
////    public void testGetTheMidpoint() {
////        //given
////        Seed seed = new Seed(Shapes.BLOCK);
////        Point midpoint = new Point(0,0);
////        //when
////            midpoint.xPoint = seed.seedGrid[0].length / 2 + 1;
////            midpoint.yPoint = seed.seedGrid.length / 2 + 1;
////            Point testPoint = seed.getTheMidpoint();
////        //then
////        Assert.assertEquals(midpoint, testPoint);
////    }
//
//  //  @Test
////    public void testSeedIsFullOfAliveCells() {
////        //given
////        Seed seed = new Seed(Shapes.BLOCK);
////        boolean isItAlive = true;
////        //when
////        for (int i = 0; i < seed.yAxis; i++) {
////            for (int j = 0; j < seed.xAxis; j++) {
////                if (seed.seedGrid[i][j] == null) {
////                    isItAlive = false;
////                    break;
////                }
////                if (seed.seedGrid[i][i].isAlive == false) {
////                    isItAlive = false;
////                    break;
////                }
////            }
////        }
////        //then
////        Assert.assertTrue(isItAlive);
////    }
//
////    @Test
////    public void testTheSeedShouldBeTheSameShapeAsShapesEnum() {
////        //given
////        Seed seed = new Seed(Shapes.BLOCK);
////        boolean isItDifferent = false;
////        //when
////        for (int i = 0; i < seed.yAxis; i++) {
////            for (int j = 0; j < seed.xAxis; j++) {
////                if ((!seed.seedGrid[i][j].isAlive && Shapes.BLOCK.shape[i][j] == 1) || (seed.seedGrid[i][j].isAlive && Shapes.BLOCK.shape[i][j] == 0)) {
////                    isItDifferent = true;
////                };
////            }
////        }
////        //then
////        Assert.assertFalse(isItDifferent);
////    }
////}
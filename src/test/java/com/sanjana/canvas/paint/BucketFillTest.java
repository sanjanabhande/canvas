package com.sanjana.canvas.paint;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BucketFillTest {

    private BucketFill bucketFill = new BucketFill();

    @Test
    public void testFillCanvas(){
        String[][] canvas = emptyArray(new String[4][20]);
        bucketFill.bucketFill("R 19 3 o", canvas);
        assertFillCanvas(canvas, "o");
    }

    @Test
    public void testFillCanvasWithLinePresent(){
        String[][] canvas = emptyArray(new String[4][20]);
        //Line
        canvas[0][3] = "x";
        canvas[1][3] = "x";
        canvas[2][3] = "x";
        canvas[3][3] = "x";
        bucketFill.bucketFill("R 19 3 o", canvas);
        assertFillCanvasWithLine(canvas, "o");
    }

    private void assertFillCanvas(String[][] canvas, String expectedSymbol){
        for(int i=1; i<canvas.length; i++){
            for(int j=1; j< canvas[i].length; j++){
                Assert.assertEquals(expectedSymbol, canvas[i][j]);
            }
        }
    }

    private void assertFillCanvasWithLine(String[][] canvas, String expectedSymbol){
        for(int i=1; i<canvas.length; i++){
            for(int j=4; j< canvas[i].length; j++){
                Assert.assertEquals(expectedSymbol, canvas[i][j]);
            }
        }
    }

    private String[][] emptyArray(String [][] arr){
        for(int i=0; i< arr.length; i++) {
            Arrays.fill(arr[i], " ");
        }
        return arr;
    }
}

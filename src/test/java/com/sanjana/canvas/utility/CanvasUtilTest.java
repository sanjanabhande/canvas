package com.sanjana.canvas.utility;


import com.sanjana.canvas.model.DrawVO;
import org.junit.Assert;
import org.junit.Test;

public class CanvasUtilTest {

    private CanvasUtil canvasUtil = new CanvasUtil();

    @Test
    public void testCreateHeight(){
        String[][] canvas = new String[4][20];
        DrawVO drawVO = new DrawVO();
        drawVO.setStartWidth(0);
        drawVO.setEndWidth(19);
        drawVO.setStartHeight(0);
        drawVO.setEndHeight(3);
        drawVO.setDrawSymbol("|");
        canvasUtil.createHeight(drawVO, canvas);
        assertCanvasHeight(canvas, drawVO.getDrawSymbol());
    }

    @Test
    public void testCreateWidth(){
        String[][] canvas = new String[4][20];
        DrawVO drawVO = new DrawVO();
        drawVO.setStartWidth(0);
        drawVO.setEndWidth(19);
        drawVO.setStartHeight(0);
        drawVO.setEndHeight(3);
        drawVO.setDrawSymbol("-");
        canvasUtil.createWidth(drawVO, canvas);
        assertCanvasWidth(canvas, drawVO.getDrawSymbol());

    }

    @Test
    public void testSetParamsToDraw(){
        String input = "R 4 1 5 9";
        DrawVO drawVO = canvasUtil.setParamsToDraw(input);
        Assert.assertEquals(4, drawVO.getStartWidth());
        Assert.assertEquals(1, drawVO.getStartHeight());
        Assert.assertEquals(5, drawVO.getEndWidth());
        Assert.assertEquals(9, drawVO.getEndHeight());
        Assert.assertEquals("x", drawVO.getDrawSymbol());
    }

    @Test
    public void testEmpty(){
        String[][] canvas = new String[2][2];
        canvasUtil.makeEmpty(canvas);
        assertEmptyCanvas(canvas);
    }

    private void assertCanvasWidth(String [][] canvas, String expected){
        for(int i=0; i< canvas[0].length; i++){
            Assert.assertEquals(expected, canvas[0][i]);
            Assert.assertEquals(expected, canvas[canvas.length-1][i]);
        }
    }

    private void assertCanvasHeight(String [][] canvas, String expected){
        for(int i=0; i< canvas.length; i++){
            Assert.assertEquals(expected, canvas[i][0]);
            Assert.assertEquals(expected, canvas[i][canvas[0].length-1]);
        }
    }

    private void assertEmptyCanvas(String[][] canvas){
        for(int i=0; i<canvas.length; i++){
            for(int j=0; j<canvas[i].length; j++){
                Assert.assertEquals(" ", canvas[i][j]);
            }
        }
    }
}

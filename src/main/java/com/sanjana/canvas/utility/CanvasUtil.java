package com.sanjana.canvas.utility;

import com.sanjana.canvas.model.DrawVO;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CanvasUtil {

    private static final String SPACE = " ";
    private static final String DRAW_SYMBOL = "x";

    public void printCanvasDrawing(String[][] canvas){
        for (int x = 0; x < canvas.length; x++) {         //this equals to the row in our canvas.
            for (int y = 0; y < canvas[x].length; y++) {   //this equals to the column in each row.
                System.out.print(canvas[x][y]);
            }
            System.out.println(); //change line on console as row comes to end in the canvas.
        }
    }

    public void createWidth(DrawVO drawVO, String[][] canvas){
        int startHeight = drawVO.getStartHeight();
        int endHeight = drawVO.getEndHeight();
        int startWidth = drawVO.getStartWidth();
        int endWidth = drawVO.getEndWidth();
        String drawSymbol = drawVO.getDrawSymbol();

        while (startWidth <= endWidth){
            if (startHeight == endHeight){
                canvas[startHeight][startWidth] = drawSymbol;
            } else {
                canvas[startHeight][startWidth] = drawSymbol;
                canvas[endHeight][startWidth] = drawSymbol;
            }
            startWidth++;
        }
    }

    public void createHeight(DrawVO drawVO, String[][] canvas){
        int startHeight = drawVO.getStartHeight();
        int endHeight = drawVO.getEndHeight();
        int startWidth = drawVO.getStartWidth();
        int endWidth = drawVO.getEndWidth();
        String drawSymbol = drawVO.getDrawSymbol();

        while (startHeight <= endHeight){
            if (startWidth == endWidth){
                canvas[startHeight][startWidth] = drawSymbol;
            } else {
                canvas[startHeight][startWidth] = drawSymbol;
                canvas[startHeight][endWidth] = drawSymbol;
            }
            startHeight++;
        }
    }

    public DrawVO setParamsToDraw(String input){
        String[] data = input.split(SPACE);
        checkAllParametersSet(data, 5);
        DrawVO drawVO = new DrawVO();
        drawVO.setStartWidth(Integer.parseInt(data[1]));
        drawVO.setEndWidth(Integer.parseInt(data[3]));
        drawVO.setStartHeight(Integer.parseInt(data[2]));
        drawVO.setEndHeight(Integer.parseInt(data[4]));
        drawVO.setDrawSymbol(DRAW_SYMBOL);
        return drawVO;
    }

    public void makeEmpty(String[][] canvas){
        for(int i=0; i<canvas.length; i++){
            Arrays.fill(canvas[i], SPACE);
        }
    }

    public void checkAllParametersSet(String[] data, int expectedLength ){
        if(data.length!=expectedLength){
            throw new IllegalStateException();
        }
    }

    public void checkCanvas(String[][] canvas){
        if(null == canvas){
            throw new RuntimeException("Canvas is null");
        }
    }
}

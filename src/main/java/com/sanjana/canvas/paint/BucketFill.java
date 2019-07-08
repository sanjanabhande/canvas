package com.sanjana.canvas.paint;

import org.springframework.stereotype.Service;

@Service
public class BucketFill {

    private static final String SPACE = " ";

    public void bucketFill(String input, String[][] canvas){
        String[] data = input.split(SPACE);
        int width = Integer.parseInt(data[1]);
        int height = Integer.parseInt(data[2]);
        int startWidth = width;
        int endWidth = width+1;
        int startHeight = height;
        int endHeight = height+1;
        String symbol = data[3];

        bucketFillUp(canvas, startHeight, startWidth, endWidth, symbol, width);
        startWidth = width;
        endWidth = width+1;
        bucketFillDown(canvas, endHeight, startWidth, endWidth, symbol, width);
    }

    private void bucketFillUp(String[][] canvas, int startHeight, int startWidth,
                              int endWidth, String symbol, int width){
        while (startHeight > 0
                && checkObstacleFillUp(canvas, startHeight, startWidth, endWidth)){
            fillLeft(canvas, startHeight, startWidth, symbol);
            fillRight(canvas, startHeight, endWidth, symbol);
            startWidth = width;
            endWidth = width+1;
            startHeight--;
        }
    }

    private void bucketFillDown(String [][] canvas, int endHeight, int startWidth,
                                int endWidth, String symbol, int width){
        while (endHeight < canvas.length
                && checkObstacleFillDown(canvas, endHeight, startWidth, endWidth)){
            fillLeft(canvas, endHeight, startWidth, symbol);
            fillRight(canvas, endHeight, endWidth, symbol);
            startWidth = width;
            endWidth = width+1;
            endHeight++;
        }
    }

    private void fillLeft(String canvas[][], int height, int width, String symbol){
        while (width > 0 && isCanvasPositionEmpty(canvas, height, width)){
            canvas[height][width] = symbol;
            width--;
        }
    }

    private void fillRight(String canvas[][], int height, int width, String symbol){
        while (width < canvas[0].length && isCanvasPositionEmpty(canvas, height, width)){
            canvas[height][width] = symbol;
            width++;
        }
    }

    private boolean checkObstacleFillUp(String [][]canvas, int startHeight, int startWidth, int endWidth){
        return isCanvasPositionEmpty(canvas,startHeight,startWidth) || isCanvasPositionEmpty(canvas,startHeight,endWidth);
    }

    private boolean checkObstacleFillDown(String [][]canvas, int endHeight, int startWidth, int endWidth){
        return isCanvasPositionEmpty(canvas,endHeight,startWidth) || isCanvasPositionEmpty(canvas,endHeight,endWidth);
    }

    private boolean isCanvasPositionEmpty(String[][] canvas, int height, int width){
        return canvas[height][width].equalsIgnoreCase(SPACE);
    }
}

package com.sanjana.canvas.draw;

import com.sanjana.canvas.utility.CanvasUtil;
import com.sanjana.canvas.model.DrawVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Canvas {

    @Autowired
    private CanvasUtil canvasUtil;

    public void create(String input, String[][] canvas){
        String[] canvasData = input.split(" ");
        canvasUtil.checkAllParametersSet(canvasData, 3);
        int canvasHeight = Integer.parseInt(canvasData[2])+2;
        int canvasWidth = Integer.parseInt(canvasData[1])+2;

        String canvasWidthSymbol = "-";
        String canvasHeightSymbol = "|";
        canvas = new String[canvasHeight][canvasWidth];
        canvasUtil.makeEmpty(canvas);

        DrawVO widthObject = new DrawVO();
        widthObject.setStartHeight(0);
        widthObject.setEndHeight(canvasHeight-1);
        widthObject.setStartWidth(0);
        widthObject.setEndWidth(canvasWidth-1);
        widthObject.setDrawSymbol(canvasWidthSymbol);
        canvasUtil.createWidth(widthObject, canvas);

        DrawVO heightObject = new DrawVO();
        heightObject.setStartHeight(1);
        heightObject.setEndHeight(canvasHeight-2);
        heightObject.setStartWidth(0);
        heightObject.setEndWidth(canvasWidth-1);
        heightObject.setDrawSymbol(canvasHeightSymbol);
        canvasUtil.createHeight(heightObject, canvas);

    }
}

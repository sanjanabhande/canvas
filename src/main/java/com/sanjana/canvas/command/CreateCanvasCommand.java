package com.sanjana.canvas.command;

import com.sanjana.canvas.draw.Canvas;
import com.sanjana.canvas.utility.CanvasUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateCanvasCommand implements  Command{

    @Autowired
    private Canvas canvas;

    @Autowired
    private CanvasUtil canvasUtil;

    @Override
    public void handle(String input, String[][] initialCanvas) {
        canvas.create(input, initialCanvas);
        canvasUtil.printCanvasDrawing(initialCanvas);
    }
}

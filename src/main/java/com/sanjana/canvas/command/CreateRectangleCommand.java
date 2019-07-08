package com.sanjana.canvas.command;

import com.sanjana.canvas.draw.Rectangle;
import com.sanjana.canvas.utility.CanvasUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateRectangleCommand implements Command {

    @Autowired
    private Rectangle rectangle;

    @Autowired
    private CanvasUtil canvasUtil;

    @Override
    public void handle(String input, String[][] canvas) {
        canvasUtil.checkCanvas(canvas);
        rectangle.draw(input, canvas);
        canvasUtil.printCanvasDrawing(canvas);
    }
}

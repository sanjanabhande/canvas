package com.sanjana.canvas.command;

import com.sanjana.canvas.draw.Line;
import com.sanjana.canvas.utility.CanvasUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateLineCommand implements Command {

    @Autowired
    private Line line;

    @Autowired
    private CanvasUtil canvasUtil;

    @Override
    public void handle(String input, String[][] canvas) {
        canvasUtil.checkCanvas(canvas);
        line.draw(input, canvas);
        canvasUtil.printCanvasDrawing(canvas);
    }
}

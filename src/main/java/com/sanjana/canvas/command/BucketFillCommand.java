package com.sanjana.canvas.command;

import com.sanjana.canvas.paint.BucketFill;
import com.sanjana.canvas.utility.CanvasUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class BucketFillCommand implements Command {

    @Autowired
    private BucketFill bucketFill;

    @Autowired
    private CanvasUtil canvasUtil;

    @Override
    public void handle(String input, String[][] canvas) {
        canvasUtil.checkCanvas(canvas);
        bucketFill.bucketFill(input, canvas);
        canvasUtil.printCanvasDrawing(canvas);
    }
}

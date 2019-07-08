package com.sanjana.canvas.draw;

import com.sanjana.canvas.model.DrawVO;
import com.sanjana.canvas.utility.CanvasUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Line {

    @Autowired
    private CanvasUtil canvasUtil;

    public void draw(String input, String[][] canvas){
        DrawVO drawVO = canvasUtil.setParamsToDraw(input);

        canvasUtil.createWidth(drawVO, canvas);
        canvasUtil.createHeight(drawVO, canvas);
    }
}

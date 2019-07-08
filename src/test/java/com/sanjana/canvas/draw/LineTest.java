package com.sanjana.canvas.draw;

import com.sanjana.canvas.model.DrawVO;
import com.sanjana.canvas.utility.CanvasUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LineTest {

    @Mock
    private CanvasUtil canvasUtil;

    @InjectMocks
    private Line line;

    @Test
    public void testDrawLine(){
        String input = "L 1 3 4 5";
        Mockito.doNothing().when(canvasUtil).createWidth(Mockito.any(DrawVO.class), Mockito.any());
        Mockito.doNothing().when(canvasUtil).createHeight(Mockito.any(DrawVO.class), Mockito.any());
        Mockito.when(canvasUtil.setParamsToDraw(input)).thenReturn(new DrawVO());
        line.draw(input, new String[4][5]);
        Mockito.verify(canvasUtil).createHeight(Mockito.any(DrawVO.class), Mockito.any());
        Mockito.verify(canvasUtil).createWidth(Mockito.any(DrawVO.class), Mockito.any());
        Mockito.verify(canvasUtil).setParamsToDraw(input);
    }
}

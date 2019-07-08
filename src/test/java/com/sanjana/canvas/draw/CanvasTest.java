package com.sanjana.canvas.draw;

import com.sanjana.canvas.utility.CanvasUtil;
import com.sanjana.canvas.model.DrawVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CanvasTest {

    @Mock
    private CanvasUtil canvasUtil;

    @InjectMocks
    private Canvas canvas;

    @Test
    public void testCreateCanvas(){
        Mockito.doNothing().when(canvasUtil).createWidth(Mockito.any(DrawVO.class), Mockito.any());
        Mockito.doNothing().when(canvasUtil).createHeight(Mockito.any(DrawVO.class), Mockito.any());
        /*String[][] actualCanvas = canvas.create(4, 20);
        Assert.assertNotNull(actualCanvas);
        Mockito.verify(canvasUtil).createHeight(Mockito.any(DrawVO.class), Mockito.any());*/
    }
}

package com.sanjana.canvas.command;

public class ExitCanvasCommand implements Command {

    @Override
    public void handle(String input, String[][] canvas) {
        System.out.println("Exiting");
        System.exit(0);
    }
}

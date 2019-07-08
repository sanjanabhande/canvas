package com.sanjana.canvas.command;

public class HelpCommand implements Command {

    final String COMMANDS_HELP = new StringBuilder().append("1. Create Canvas -> 'C w h' -> Create a new canvas of width w and height h.\n")
            .append("2. Create line -> 'L x1 y1 x2 y2' -> Create a new line from `(x1,y1)` to `(x2,y2)`. Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the `x` character.\n")
            .append("3. Create Rectangle -> 'R x1 y1 x2 y2' -> Create a new rectangle, whose upper left corner is `(x1,y1)` and lower right corner is `(x2,y2)`. Horizontal and vertical lines will be drawn using the `x` character. \n")
            .append("4. Bucket Fill -> 'B x y c' -> Fill the entire area connected to `(x,y)` with colour `'c'`. The behaviour of this is the same as that of the \"bucket fill\" tool in paint programs. \n")
            .append("5. Quit -> 'Q' -> Exit the program.").toString();

    @Override
    public void handle(String input, String[][] canvas) {
        System.out.println(COMMANDS_HELP);
    }
}

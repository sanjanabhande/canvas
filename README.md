# Console Paint Program

### Build Instructions
`./mvnw clean compile`

### Run instructions
`./mvnw spring-boot:run`

## Description

The program supports the following commands:
   
| Command | Command Name |  Description |
| ------- | ------------ |  ----------- |
| `C w h`     | Create canvas | Create a new canvas of width w and height h. |
| `L x1 y1 x2 y2` | Create line | Create a new line from `(x1,y1)` to `(x2,y2)`. Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the `x` character. |
| `R x1 y1 x2 y2` | Create rectangle | Create a new rectangle, whose upper left corner is `(x1,y1)` and lower right corner is `(x2,y2)`. Horizontal and vertical lines will be drawn using the `x` character. |
| `B x y c` | Bucket fill | Fill the entire area connected to `(x,y)` with colour `'c'`. The behaviour of this is the same as that of the "bucket fill" tool in paint programs. |
| `H` | Help | Shows list of commands that are allowed.
| `Q` | Quit | Exit the program. |
 
## Sample I/O

Below is a sample of the output your program should produce. User input is prefixed with `enter command:`.


	enter command: C 22 6
    ------------------------
    |                      |
    |                      |
    |                      |
    |                      |
    |                      |
    |                      |
    ------------------------
    enter command: L 6 1 6 6
    ------------------------
    |     x                |
    |     x                |
    |     x                |
    |     x                |
    |     x                |
    |     x                |
    ------------------------
    enter command: L 16 5 22 5
    ------------------------
    |     x                |
    |     x                |
    |     x                |
    |     x                |
    |     x         xxxxxxx|
    |     x                |
    ------------------------
    enter command: L 16 5 16 6
    ------------------------
    |     x                |
    |     x                |
    |     x                |
    |     x                |
    |     x         xxxxxxx|
    |     x         x      |
    ------------------------
    enter command: R 16 1 22 3
    ------------------------
    |     x        xxxxxxxx|
    |     x        x      x|
    |     x        xxxxxxxx|
    |     x                |
    |     x         xxxxxxx|
    |     x         x      |
    ------------------------
    enter command: B 18 1 a
    ------------------------
    |     x        xxxxxxxx|
    |     x        xaaaaaax|
    |     x        xxxxxxxx|
    |     x                |
    |     x         xxxxxxx|
    |     x         x      |
    ------------------------
    enter command: B 7 4 o
    ------------------------
    |     xooooooooxxxxxxxx|
    |     xooooooooxaaaaaax|
    |     xooooooooxxxxxxxx|
    |     xoooooooooooooooo|
    |     xoooooooooxxxxxxx|
    |     xooooooooox      |
    ------------------------


## Edge Cases
1. If you leave a space before or after the command, the program will trim it before executing it.
2. If you pass a command which is not recogonized, it will throw an error saying `Invalid Input`.
3. If you want to clear and start afresh, re-issue the `Create canvas` command.
4. If you try to draw line, rectangle or bucket fill without creating canvas, it will throw an error saying `Please create canvas (eg: using 'C 20 4') first.`.
5. If you try to draw a line outside the canvas, we will provide an error and an option to see help.
6. Help commands can also be seen by providing `H` command.

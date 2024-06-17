## Drawing Shapes

### Description 
This Java program allows user to draw shapes (a) square, (b) line, and (c) octagon using AWT. It implements functionality where shapes are drawn dynamically as the user clicks and drags the mouse, and then finalized upon releasing the mouse.

### Interactive Drawing Process
Upon launching the program, the user can choose from three shapes:

- Square: Click and drag to define the square's diagonal. Release the mouse button to draw the square.
- Line: Click and drag to draw a straight line from the starting point to the current mouse position. Release the mouse button to finalize the line.
- Octagon: Click and drag to draw the circumscribed rectangle of the octagon. Release the mouse button to complete the octagon.

### How to Run
To run the program:

1. Compile the Java file:
    ```bash
    javac DrawingShapes.java
    ```
2. Run the compiled program:
    ```bash
    java DrawingShapes
    ```

### Instructions for Use
- Drawing a Shape:
    -  Press the left mouse button at the starting point of the shape.
    - Drag the mouse to define the size and orientation of the shape.
    - Release the mouse button to finalize the shape.

- Switching Shapes:
    - Press the corresponding key for the shape you want to draw:
        - 'S' for square
        - 'L' for line
        - 'O' for octagon

- Exiting the Program:
    - Close the window or terminate the program to exit.

Enjoy drawing shapes interactively using this AWT-based Java application!
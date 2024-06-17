import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DrawingShapes extends Frame {
    private final int BACK_WIDTH = 600;
    private final int BACK_HEIGHT = 400;
    private final int SIDES_OF_OCT = 8;
    private enum Shapes {
        LINE, SQUARE, OCTAGON
    };
    private int startX, startY, endX, endY;
    private Shapes shape; 

    public DrawingShapes() {
        setTitle("Drawing Shapes");
        setSize(BACK_WIDTH, BACK_HEIGHT);
        setBackground(Color.WHITE);
        setVisible(true);

        shape = Shapes.LINE;

        // enable focus traversal keys
        setFocusTraversalKeysEnabled(true);

        // close the window when clicking the close button
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new DrawingShapes();
    }
}
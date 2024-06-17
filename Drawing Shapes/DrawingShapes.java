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
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }    
            public void mouseReleased(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                drawShape();
            }
        });

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_L:
                        shape = Shapes.LINE;                        
                        break;
                    case KeyEvent.VK_S:
                        shape = Shapes.SQUARE;
                        break;
                    case KeyEvent.VK_O:
                        shape = Shapes.OCTAGON;
                        break;
                }
            }
        });

        // enable focus traversal keys
        setFocusTraversalKeysEnabled(true);

        // close the window when clicking the close button
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void drawShape() {
        Graphics g = getGraphics();
        
        switch (shape) {
            case Shapes.LINE:
                g.drawLine(startX, startY, endX, endY);
                break;
            case Shapes.SQUARE:
                int size = endX-startX < endY-startY?
                    endX-startX : endY-startY;
                g.drawRect(startX, startY, size, size);
                break;
            case Shapes.OCTAGON:
                int centX = (startX + endX)/2;
                int centY = (startY + endY)/2;
                int radius = Math.abs(endX - startX)/2;
                
                int[] xPoints = new int[SIDES_OF_OCT];
                int[] yPoints = new int[SIDES_OF_OCT];

                for(int i=0; i < SIDES_OF_OCT; ++i) {
                    double angle = 2*Math.PI/SIDES_OF_OCT * i;
                    xPoints[i] = (int)(centX + radius*Math.cos(angle));
                    yPoints[i] = (int)(centY + radius*Math.sin(angle));
                }
                g.drawPolygon(xPoints, yPoints, SIDES_OF_OCT);
                break;   
        }    
    }
    public static void main(String[] args) {
        new DrawingShapes();
    }
}
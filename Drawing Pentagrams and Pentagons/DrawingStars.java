import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawingStars extends JFrame {
    private final int BACK_WIDTH = 600;
    private final int BACK_HEIGHT = 400;
    private enum Shapes {PENTAGRAM, PENTAGON}
    private DrawingPanel panel;
    private JLabel shapeLabel;
    private Shapes shape = Shapes.PENTAGON;

    public DrawingStars() {
        setTitle("Drawing Stars");
        setSize(BACK_WIDTH, BACK_HEIGHT);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        shapeLabel = new JLabel("Current shape: 五角星 (Pentagon)");
        shapeLabel.setHorizontalAlignment(JLabel.CENTER);
        shapeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (shape == Shapes.PENTAGON) {
                    shape = Shapes.PENTAGRAM;
                    shapeLabel.setText("Current shape: 五芒星 (Pentagram)");
                } else {
                    shape = Shapes.PENTAGON;
                    shapeLabel.setText("Current shape: 五角星 (Pentagon)");
                }
            }
        });
        add(shapeLabel, BorderLayout.NORTH);
        panel = new DrawingPanel();
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new DrawingStars();
    }

}
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

    private class DrawingPanel extends JPanel {
        private int startX, startY, endX, endY;

        public DrawingPanel() {
            setBackground(Color.WHITE);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    startX = e.getX();
                    startY = e.getY();
                    endX = e.getX();
                    endY = e.getY();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    repaint();
                }
            });

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    endX = e.getX();
                    endY = e.getY();
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);

            int centX = (startX + endX) / 2;
            int centY = (startY + endY) / 2;
            int radius = Math.min(Math.abs(endX - startX), Math.abs(endY - startY)) / 2;

            int[] xPoints, yPoints;

            switch (shape) {
                case PENTAGON:
                    xPoints = new int[10];
                    yPoints = new int[10];

                    for (int i = 0; i < 10; ++i) {
                        double angle = 2 * Math.PI / 10 * i;
                        if (i % 2 == 0) {
                            xPoints[i] = (int) (centX + radius * Math.cos(angle));
                            yPoints[i] = (int) (centY + radius * Math.sin(angle));
                        } else {
                            xPoints[i] = (int) (centX + radius / 2 * Math.cos(angle));
                            yPoints[i] = (int) (centY + radius / 2 * Math.sin(angle));
                        }
                    }
                    g2d.drawPolygon(xPoints, yPoints, 10);
                    break;

                case PENTAGRAM:
                    xPoints = new int[5];
                    yPoints = new int[5];

                    for (int i = 0; i < 5; ++i) {
                        double angle = 2 * Math.PI / 5 * i;
                        xPoints[i] = (int) (centX + radius * Math.cos(angle));
                        yPoints[i] = (int) (centY + radius * Math.sin(angle));
                    }
                    for (int i = 0; i < 5; ++i) {
                        int nextPoint = (i + 2) % 5;
                        g2d.drawLine(xPoints[i], yPoints[i], xPoints[nextPoint], yPoints[nextPoint]);
                    }
                    break;
            }
        }
    }
}
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Random;

public class DodgerGame extends JFrame implements MouseMotionListener {
    private static final int BACK_WIDTH = 500;
    private static final int BACK_HEIGHT = 500;
    private static final int LBL_X = 0, LBL_Y = 0;
    private static final int LBL_WIDTH = 100;
    private static final int LBL_HEIGHT = 20;
    private static final int CIR_DIAM = 50;
    private static final int CIR_Y = BACK_HEIGHT - CIR_DIAM*2;
    private static final int SQ_SIZE = 50;
    private static final int SQ_SPEED = 10;
    private static final int HP_START = 3;
    // posibillity of falling square = 1 / RAND_BOUND
    private static final int RAND_BOUND = 5;

    private int hp;
    private JLabel hp_lbl;
    private Rectangle circle;
    private ArrayList<Rectangle> squares;
    private Random random;

    public DodgerGame() {
        setTitle("Dodger Game");
        setSize(BACK_WIDTH, BACK_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addMouseMotionListener(this);

        circle = new Rectangle(0, CIR_Y, 
            CIR_DIAM, CIR_DIAM);
        hp = HP_START;
        squares = new ArrayList<>();
        random = new Random();
        hp_lbl = new JLabel("HP: "+ hp);
        hp_lbl.setBounds(LBL_X, LBL_Y, LBL_WIDTH, LBL_HEIGHT);
        add(hp_lbl);

        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
                repaint();
            }
        });
        timer.start();
        setVisible(true);
    }
    private void update() {
        if(hp <= 0) {
            JOptionPane.showMessageDialog(this, "Game Over!");
            System.exit(0);
        }

        if(random.nextInt(RAND_BOUND) == 0) {
            squares.add(
                new Rectangle(
                    random.nextInt(BACK_WIDTH-SQ_SIZE), 0,
                    SQ_SIZE, SQ_SIZE)
            );
        }
        
        for(Rectangle sq: squares) {
            sq.y += SQ_SPEED;
            if(sq.intersects(circle)) {
                hp--;
                squares.remove(sq);
                break;
            }
            if(sq.y > BACK_HEIGHT) {
                squares.remove(sq);
                break;
            }
        }
        hp_lbl.setText("HP: " + hp);
    }


    public static void main(String[] args) {
        new DodgerGame();
    }
}
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChangingColor {
    static private final int BACK_WIDTH = 300;
    static private final int BACK_HEIGHT = 200;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Thanks to TA");
        
        JButton redBtn = new JButton("Red");
        JButton blueBtn = new JButton("Blue");
        JButton greenBtn = new JButton("Green");

        JLabel label = new JLabel("助教辛苦了~", JLabel.CENTER);
        label.setOpaque(true);
        redBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setBackground(Color.RED);  
            }
        });
        blueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setBackground(Color.BLUE);
            }
        });
        greenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setOpaque(true);
                label.setBackground(Color.GREEN);
            }
        });

        JPanel btnPanel = new JPanel(new FlowLayout());
        btnPanel.add(redBtn);
        btnPanel.add(blueBtn);
        btnPanel.add(greenBtn);

        frame.setLayout(new BorderLayout());
        frame.add(btnPanel, BorderLayout.NORTH);
        frame.add(label, BorderLayout.CENTER);

        frame.setSize(BACK_WIDTH, BACK_HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

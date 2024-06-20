import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToeGame extends JFrame{
    static private final int BACK_WIDTH = 400;
    static private final int BACK_HEIGHT = 400;
    static private final Dimension BTN_DIM 
        = new Dimension(100, 100);
    static private final Font TEXT_FONT 
        = new Font("Arial", Font.PLAIN, 50);
    static private final char EMPTY_CHAR = ' ';
    static private final char O = 'O';
    static private final char X = 'X';

    private JButton[][] btns;
    private char[][] board;
    private char curPlayer;
    private JLabel statusLbl;


    public TicTacToeGame() {
        setTitle("4x4 Tic-Tac-Toe Game");
        setSize(BACK_WIDTH, BACK_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initialize vaiables
        btns = new JButton[4][4];
        board = new char[4][4];

        JPanel boardPanel = new JPanel(new GridLayout(4, 4));
        add(boardPanel, BorderLayout.CENTER);

        for(int row=0; row < 4; ++row) {
            for(int col=0; col < 4; ++col) {
                btns[row][col] = new JButton();
                btns[row][col].setFont(TEXT_FONT);
                btns[row][col].setPreferredSize(BTN_DIM);

                final int r = row, c = col;
                btns[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnClicked(r, c);
                    }
                });
                boardPanel.add(btns[row][col]);
            }
        }

        statusLbl = new JLabel("Player " + curPlayer + "'s turn");
        add(statusLbl, BorderLayout.SOUTH);
        
        resetBoard();
        setVisible(true);
    }
    private void resetBoard() {
        curPlayer = 'O';
        statusLbl.setText("Player " + curPlayer + "'s turn");

        for(int row=0; row < 4; ++row) {
            for(int col=0; col < 4; ++col) {
                board[row][col] = EMPTY_CHAR;
                btns[row][col].setText(
                    String.valueOf(board[row][col]));
                btns[row][col].setEnabled(true);
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToeGame();
    }
}

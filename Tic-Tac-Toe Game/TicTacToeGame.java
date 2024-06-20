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

    private void btnClicked(int row, int col) {
        if(board[row][col] == EMPTY_CHAR) {
            board[row][col] = curPlayer;
            btns[row][col].setText(String.valueOf(curPlayer));
            
            if(checkWin(curPlayer)) {
                JOptionPane.showMessageDialog(this, "Player " + curPlayer + " wins!");
                resetBoard();
                return;
            } else if(checkDraw()) {
                JOptionPane.showMessageDialog(this, "It's a draw!");
                resetBoard();
                return;
            }

            curPlayer = (curPlayer == X) ? O : X;
            statusLbl.setText("Player " + curPlayer + "'s turn");
        }
    }

    private boolean checkWin(char player) {
        for(int i=0; i < 4; ++i) {
            if(board[i][0] == player && board[i][1] == player
                && board[i][2] == player && board[i][3] == player)
                return true;
            if(board[0][i] == player && board[1][i] == player
                && board[2][i] == player && board[3][i] == player)
                return true;
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player && board[3][3] == player)
            return true;
        if (board[0][3] == player && board[1][2] == player && board[2][1] == player && board[3][0] == player)
            return true;

        return false;
    }

    private boolean checkDraw() {
        for(int row=0; row < 4; ++row) {
            for(int col=0; col < 4; ++col) {
                if(board[row][col] == EMPTY_CHAR)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new TicTacToeGame();
    }
}

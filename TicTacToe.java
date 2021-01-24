import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
public class TicTacToe implements ActionListener {

    Random rand = new Random();
    JFrame board = new JFrame();
    JPanel title = new JPanel();
    JPanel button = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    String player = "Player 1";
    boolean firstPlayerTurn;

    TicTacToe() {

        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setSize(1000, 1000); //Can change size for board
        board.getContentPane().setBackground(new Color(0, 222, 255));//background color of board
        board.setLayout(new BorderLayout());
        board.setVisible(true);

        textField.setBackground(new Color(40, 40, 40));
        textField.setForeground(new Color(255, 255, 255)); //font text color
        textField.setFont(new Font("Ink Free", Font.ITALIC, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setBounds(0, 0, 1000, 400);

        button.setLayout(new GridLayout(3, 3)); //button for rows and columns
        button.setBackground(new Color(0, 222, 255));

        for (int a = 0; a < 9; a++) {
            buttons[a] = new JButton();
            button.add(buttons[a]);
            buttons[a].setFont(new Font("MV Boli", Font.BOLD, 100));
            buttons[a].setFocusable(false);
            buttons[a].addActionListener(this);
        }
        title.add(textField);
        board.add(title, BorderLayout.NORTH); //position of textField
        board.add(button);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int b = 0; b < 9; b++) {
            if (e.getSource() == buttons[b]) {
                if (firstPlayerTurn) {
                    if (buttons[b].getText().equals("")) {
                        buttons[b].setForeground(new Color(255, 0, 0));
                        buttons[b].setText("X");
                        firstPlayerTurn = false;
                        textField.setText("Player 2 turn");
                        checkOfWinner();
                    }
                } else {
                    if (buttons[b].getText().equals("")) {
                        buttons[b].setForeground(new Color(25, 255, 0));
                        buttons[b].setText("O");
                        firstPlayerTurn = true;
                        textField.setText("Player 1 turn");
                        checkOfWinner();
                    }
                }
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (rand.nextInt(2) == 0) {
            firstPlayerTurn = true;
            textField.setText("Player 1 turn");
        } else {
            firstPlayerTurn = false;
            textField.setText("Player 2 turn");
        }
    }

    public void checkOfWinner() {
        //if player 1 wins
        if (
                (buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))
        ) {
            firstPlayerWins(0, 1, 2);
        }
        if (
                (buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X"))
        ) {
            firstPlayerWins(3, 4, 5);
        }
        if (
                (buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && (buttons[8].getText().equals("X"))
        ) {
            firstPlayerWins(6, 7, 8);
        }
        if (
                (buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && (buttons[6].getText().equals("X"))
        ) {
            firstPlayerWins(0, 3, 6);
        }
        if (
                (buttons[1].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X"))
        ) {
            firstPlayerWins(1, 4, 7);
        }
        if (
                (buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X"))
        ) {
            firstPlayerWins(2, 5, 8);
        }
        if (
                (buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[8].getText().equals("X"))
        ) {
            firstPlayerWins(0, 4, 8);
        }
        if (
                (buttons[2].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[6].getText().equals("X"))
        ) {
            firstPlayerWins(2, 4, 6);
        }

        //if player 2 wins
        if (
                (buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && (buttons[2].getText().equals("O"))
        ) {
            secondPlayerWins(0, 1, 2);
        }
        if (
                (buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[5].getText().equals("O"))
        ) {
            secondPlayerWins(3, 4, 5);
        }
        if (
                (buttons[6].getText().equals("O")) && (buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O"))
        ) {
            secondPlayerWins(6, 7, 8);
        }
        if (
                (buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[6].getText().equals("O"))
        ) {
            secondPlayerWins(0, 3, 6);
        }
        if (
                (buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[7].getText().equals("O"))
        ) {
            secondPlayerWins(1, 4, 7);
        }
        if (
                (buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O"))
        ) {
            secondPlayerWins(2, 5, 8);
        }
        if (
                (buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O"))
        ) {
            secondPlayerWins(0, 4, 8);
        }
        if (
                (buttons[2].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[6].getText().equals("O"))
        ) {
            secondPlayerWins(2, 4, 6);
        }
    }

    public void firstPlayerWins(int i, int d, int n) {
        buttons[i].setBackground(Color.YELLOW);
        buttons[d].setBackground(Color.YELLOW);
        buttons[n].setBackground(Color.YELLOW);

        for (int z = 0; z < 9; z++) {
            buttons[z].setEnabled(false);
        }
        textField.setText("Player 1 wins.");

        if (player.equals("Player 1 wins.")) player = "Player 2 wins.";
        else player = "Player 1 wins.";
        JOptionPane tic = new JOptionPane();
        int dialogResult = JOptionPane.showConfirmDialog(tic, "Well played. " + player + " Try playing the game again if you haven't won", "Congratulations", JOptionPane.DEFAULT_OPTION);
        if (dialogResult == JOptionPane.CLOSED_OPTION) resetTheButtons();
        else System.exit(0);
    }

    public void secondPlayerWins(int i, int d, int n) {
        buttons[i].setBackground(Color.ORANGE);
        buttons[d].setBackground(Color.ORANGE);
        buttons[n].setBackground(Color.ORANGE);

        for (int z = 0; z < 9; z++) {
            buttons[z].setEnabled(false);
        }
        textField.setText("Player 2 wins.");

        if (player.equals("Player 2 wins.")) player = "Player 1 wins.";
        else player = "Player 2 wins.";
        JOptionPane tic = new JOptionPane();
        int dialogResult = JOptionPane.showConfirmDialog(tic, "You're awesome. " + player + " Try playing the game again if you haven't won ", "Congratulations", JOptionPane.DEFAULT_OPTION);
        if (dialogResult == JOptionPane.CLOSED_OPTION) resetTheButtons();
        else System.exit(0);
    }

    private void resetTheButtons() {
        player = "Player 1";
        for (int s = 0; s < 9; s++) {
            buttons[s].setText(" ");
        }
    }
}

//If the game ended in a draw then it will not happen anything or stuck

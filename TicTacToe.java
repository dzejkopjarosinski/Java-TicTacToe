import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

  
    JFrame frame = new JFrame();
    JPanel t_panel = new JPanel();
    JPanel bt_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] bton = new JButton[9];
    int chance_flag = 0,co=1,cx=1;
    Random random = new Random();
    boolean pl1_chance;
    private final JLabel lblX = new JLabel();
    private final JLabel lblO = new JLabel();
    

    TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(304, 244);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setTitle("Tic Tac Toe");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setVisible(true);

        
        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.WHITE);
        textfield.setFont(new Font("Ink Free", Font.BOLD, 25));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);

        t_panel.setLayout(new BorderLayout());
        t_panel.setBounds(0, 0, 800, 100);

        bt_panel.setLayout(new GridLayout(3, 3));
        bt_panel.setBackground(Color.BLACK);

        for (int i = 0; i < 9; i++) {
            bton[i] = new JButton();
            bt_panel.add(bton[i]);
            bton[i].setBackground(Color.BLACK);
            bton[i].setFont(new Font("Ink Free", Font.BOLD, 30));
            bton[i].setFocusable(false);
            bton[i].addActionListener(this);
        }
        
        t_panel.add(textfield, BorderLayout.CENTER);
        frame.getContentPane().add(t_panel, BorderLayout.NORTH);
        lblX.setText("X - ");
        lblX.setOpaque(true);
        lblX.setHorizontalAlignment(SwingConstants.CENTER);
        lblX.setForeground(Color.WHITE);
        lblX.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
        lblX.setBackground(Color.RED);
        
        t_panel.add(lblX, BorderLayout.WEST);
        lblO.setText("O - ");
        lblO.setOpaque(true);
        lblO.setHorizontalAlignment(SwingConstants.CENTER);
        lblO.setForeground(Color.WHITE);
        lblO.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
        lblO.setBackground(Color.BLUE);
        
        t_panel.add(lblO, BorderLayout.EAST);
        frame.getContentPane().add(bt_panel, BorderLayout.CENTER);

        startGame();
    }

    public void startGame() {

        try {
            textfield.setText("Loading....");
            Thread.sleep(4000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        int chance=random.nextInt(100);

        if (chance%2 == 0) {
            pl1_chance = true;
            textfield.setText("X turn");
        } else {
            pl1_chance = false;
            textfield.setText("O turn");
        }
    }
    public void gameOver(String s){
        chance_flag = 0;
        Object[] option={"Restart","Exit"};
        int n=JOptionPane.showOptionDialog(frame, "Game Over\n"+s,"Game Over",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        if(n==0){
            frame.dispose();
            new TicTacToe();
        }
        else{
            frame.dispose();
        }
    
    }

    public void matchCheck() {
        if ((bton[0].getText() == "X") && (bton[1].getText() == "X") && (bton[2].getText() == "X")) {
            xWins(0, 1, 2);cx++;
        }
        else if ((bton[0].getText() == "X") && (bton[4].getText() == "X") && (bton[8].getText() == "X")) {
            xWins(0, 4, 8);cx++;
        }
        else if ((bton[0].getText() == "X") && (bton[3].getText() == "X") && (bton[6].getText() == "X")) {
            xWins(0, 3, 6);cx++;
        }
        else if ((bton[1].getText() == "X") && (bton[4].getText() == "X") && (bton[7].getText() == "X")) {
            xWins(1, 4, 7);cx++;
        }
        else if ((bton[2].getText() == "X") && (bton[4].getText() == "X") && (bton[6].getText() == "X")) {
            xWins(2, 4, 6);cx++;
        }
        else if ((bton[2].getText() == "X") && (bton[5].getText() == "X") && (bton[8].getText() == "X")) {
            xWins(2, 5, 8);cx++;
        }
       else if ((bton[3].getText() == "X") && (bton[4].getText() == "X") && (bton[5].getText() == "X")) {
            xWins(3, 4, 5);cx++;
        }
       else if ((bton[6].getText() == "X") && (bton[7].getText() == "X") && (bton[8].getText() == "X")) {
            xWins(6, 7, 8);cx++;
        }
      
        else if ((bton[0].getText() == "O") && (bton[1].getText() == "O") && (bton[2].getText() == "O")) {
            oWins(0, 1, 2);co++;
        }
        else if ((bton[0].getText() == "O") && (bton[3].getText() == "O") && (bton[6].getText() == "O")) {
            oWins(0, 3, 6);co++;
        }
        else if ((bton[0].getText() == "O") && (bton[4].getText() == "O") && (bton[8].getText() == "O")) {
            oWins(0, 4, 8);co++;
        }
        else if ((bton[1].getText() == "O") && (bton[4].getText() == "O") && (bton[7].getText() == "O")) {
            oWins(1, 4, 7);co++;
        }
        else if ((bton[2].getText() == "O") && (bton[4].getText() == "O") && (bton[6].getText() == "O")) {
            oWins(2, 4, 6);co++;
        }
        else if ((bton[2].getText() == "O") && (bton[5].getText() == "O") && (bton[8].getText() == "O")) {
            oWins(2, 5, 8);co++;
        }
        else if ((bton[3].getText() == "O") && (bton[4].getText() == "O") && (bton[5].getText() == "O")) {
            oWins(3, 4, 5);co++;
        } else if ((bton[6].getText() == "O") && (bton[7].getText() == "O") && (bton[8].getText() == "O")) {
            oWins(6, 7, 8);co++;
        }
        else if(chance_flag==9) {
            textfield.setText("Match Tie");
             gameOver("Match Tie");
        }
    }

    public void xWins(int x1, int x2, int x3) {
        bton[x1].setBackground(Color.RED);
        bton[x2].setBackground(Color.RED);
        bton[x3].setBackground(Color.RED);
        lblX.setText("X - "+cx);
        for (int i = 0; i < 9; i++) {
            bton[i].setEnabled(false);
        }
        textfield.setText("X wins");
        gameOver("X Wins");
    }

    public void oWins(int x1, int x2, int x3) {
        bton[x1].setBackground(Color.BLUE);
        bton[x2].setBackground(Color.BLUE);
        bton[x3].setBackground(Color.BLUE);
        lblO.setText("O - "+co);
        for (int i = 0; i < 9; i++) {
            bton[i].setEnabled(false);
        }
        textfield.setText("O Wins");
        gameOver("O Wins");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == bton[i]) {
                if (pl1_chance) {
                    if (bton[i].getText() == "") {
                        bton[i].setForeground(new Color(255, 0, 0));
                        bton[i].setText("X");
                        pl1_chance = false;
                        textfield.setText("O turn");
                        chance_flag++;
                        matchCheck();
                    }
                } else {
                    if (bton[i].getText() == "") {
                        bton[i].setForeground(new Color(0, 0, 255));
                        bton[i].setText("O");
                        pl1_chance = true;
                        textfield.setText("X turn");
                        chance_flag++;
                        matchCheck();
                    }
                }
            }
        }
    }

}
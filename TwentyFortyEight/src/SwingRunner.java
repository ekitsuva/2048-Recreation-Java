import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.Color;
public class SwingRunner implements KeyListener, ActionListener{
    JFrame frame;
    JPanel panel;
    JButton[] buttons = new JButton[16];
    TwentyFortyEight game = new TwentyFortyEight();
    JFrame newFrame;
    JPanel newPanel;
    JTextArea text;
    JButton yesButton, noButton;
    boolean wonGame = false;
    boolean wonGameOnce = false;
    

    public SwingRunner(){
        frame = new JFrame();
        frame.addKeyListener(this);
        panel = new JPanel(); 
        panel.addKeyListener(this);
        panel.setLayout(new GridLayout(4, 4));
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton();
            buttons[i].addKeyListener(this);
            buttons[i].setFont(buttons[i].getFont().deriveFont(25f));
        }
        frame.setContentPane(panel);
        for(int i =0; i < buttons.length; i++){
            panel.add(buttons[i]);
        }
        frame.pack();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        setBoard(game.getBoard());
        
    }
    public void setBoard(Board board){
        String[] text = new String[16];
        Color[] colors = new Color[16];
        int counter = 0;
        for(int i = 0; i < board.getBoard().length; i++){
            for(int j = 0; j < board.getBoard()[0].length; j++){
                if(board.getBoard()[i][j] != null){
                    text[counter] = Integer.toString(board.getBoard()[i][j].getNum());
                    colors[counter] = colorChosen(board.getBoard()[i][j].getNum());
                    
                }else{
                    text[counter] = " ";
                    colors[counter] = Color.GRAY;
                }
                counter++;
            }
        
        }
        for(int i = 0; i < buttons.length; i++){
            buttons[i].setText(text[i]);
            buttons[i].setBackground(colors[i]);
            if(buttons[i].getBackground().equals(Color.BLACK)){
                buttons[i].setForeground(Color.WHITE);
            }else{
                buttons[i].setForeground(Color.BLACK);
            }
        }
        
    }
     public Color colorChosen(int num){
        switch(num){
            case 2:
                return new Color(238, 228, 218);
            case 4:
                return new Color(238, 225, 201);
            case 8:
                return new Color(243, 178, 122);
            case 16:
                return new Color(246, 150, 100);
            case 32:
                return new Color(247, 124, 95);
            case 64:
                return new Color(247, 95, 59);
            case 128:
                return new Color(237, 208, 115);
            case 256:
                return new Color(237, 204, 98);
            case 512:
                return new Color(237, 201, 80);
            case 1024:
                return new Color(237, 197, 63);
            case 2048:
                return new Color(237, 194, 46);
            default:
                return Color.BLACK;
        }
     }
     public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        System.out.println(code);
        String s = " ";
        if(code== 87 || code == 38){
            s = "w";
        }else if(code ==83 || code == 40){
            s = "s";
        }else if(code == 65 || code == 37){
            s = "a";
        }else if(code == 68 || code == 39){
            s = "d";
        }else{
            s = " ";
        }

        if(wonGame){
            wonGame = !game.checkWinnerGameOver();
            wonGameOnce = true;
        }
        
        if(!game.checkGameOver() || wonGame){
            
            game.keyPressed(s);
            game.displayBoard();
            setBoard(game.getBoard());
        }else{
            System.out.println(game.checkGameOver());
                newFrame = new JFrame();
                newPanel = new JPanel();
                text = new JTextArea();
                text.setEditable(false);
                yesButton = new JButton("Yes");
                noButton = new JButton("No");
                newPanel.add(text);
                newPanel.add(yesButton);
                newPanel.add(noButton);
                yesButton.addActionListener(this);
                noButton.addActionListener(this);
                noButton.setActionCommand("No");
            if(game.winner()  && !wonGameOnce){
                System.out.println(game.winner());
                wonGame = true;
                newFrame.setContentPane(newPanel);
                text.setText("YOU WIN! DO YOU WANT TO CONTINUE?");
                yesButton.setActionCommand("Winner Yes");
                newFrame.pack();
                newFrame.setVisible(true);
            }else{
                frame.removeKeyListener(this);
                panel.removeKeyListener(this);
                for(int i = 0; i < buttons.length; i++){
                    buttons[i].removeKeyListener(this);
                }
                yesButton.setActionCommand("Yes");
                newFrame.setContentPane(newPanel);
                text.setText("GAME OVER! YOU LOSE! PLAY AGAIN?");
                newFrame.pack();
                newFrame.setVisible(true);

                
            }
        }
        

     }
     public void keyTyped(KeyEvent e){

     }
     public void keyReleased(KeyEvent e){

     }
     public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()){
            case "Yes":
                System.out.println("Yes");
                addKeyListeners();
                newFrame.setVisible(false);

                game = new TwentyFortyEight();
                setBoard(game.getBoard());
                frame.setVisible(true);
                break;
            case "No":
                frame.setVisible(false);
                newFrame.setVisible(false);
                frame.dispose();
                newFrame.dispose();
                break;
            case "Winner Yes":
                newFrame.setVisible(false);
                newFrame.dispose();
                break;
        }
     }
     public void addKeyListeners(){
        frame.addKeyListener(this);
        panel.addKeyListener(this);
        for(int i = 0; i < buttons.length; i++){
            buttons[i].addKeyListener(this);

        }
     }
     public static void run(){

        SwingRunner runner = new SwingRunner();
        
     }

}
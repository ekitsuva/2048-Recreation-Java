import java.util.Scanner;
public class App
{
    public static void main(String[] args)
    {
        // boolean gameOver = false;
        // Scanner scnr = new Scanner(System.in);
        //TwentyFortyEight game = new TwentyFortyEight();
        
        // while(!gameOver){
        //     System.out.println("Input a key (w, a, s, d): ");
            
        //     String input = scnr.nextLine();
        //     game.keyPressed(input);
        //     System.out.print("\033[H\033[2J"); 
        //     System.out.flush();
        //     game.displayBoard();
        //     runner.setBoard(game.getBoard());
        //     gameOver = game.checkGameOver();
        // }
        // scnr.close();
        // System.out.println("The game has ended. Play again?");
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
    
              SwingRunner.run();
              
            }
          });
    }
    
}
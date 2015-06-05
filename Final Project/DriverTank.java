import javax.swing.JFrame;
public class DriverTank
{
   public static void main(String[] args)
   {
      /*
      Opens the optionsPanel, waits until a player has selected a tank and has clicked play
      */
      JFrame optionsFrame = new JFrame("Laservival");          
      optionsFrame.setSize(500, 200);
      optionsFrame.setLocation(0, 0);
      optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      optionsFrame.setContentPane(new OptionsPanel());
      while(!OptionsPanel.completed)
      {
         optionsFrame.setVisible(true);
      }
      //closes optionsPanel
      optionsFrame.setVisible(false);
      //opens gamePanel with proper tank
      JFrame gameFrame = new JFrame("Game");
      gameFrame.setSize(1366, 768);
      gameFrame.setLocation(0, 0);
      gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gameFrame.setContentPane(new GamePanel());
      gameFrame.setVisible(true);
   }
}

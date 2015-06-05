import javax.swing.JFrame;
public class DriverTank
{
   public static void main(String[] args)
   {
      JFrame optionsFrame = new JFrame("Laservival");
      optionsFrame.setSize(1366, 100);
      optionsFrame.setLocation(0, 0);
      optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      optionsFrame.setContentPane(new OptionsPanel());
      while(!OptionsPanel.completed)
      {
         optionsFrame.setVisible(true);
      }
      
      //optionsFrame.setVisible(false);
      
      JFrame gameFrame = new JFrame("Game");
      gameFrame.setSize(1366, 650);
      gameFrame.setLocation(0, 100);
      gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gameFrame.setContentPane(new GamePanel());
      gameFrame.setVisible(true);
   }
}
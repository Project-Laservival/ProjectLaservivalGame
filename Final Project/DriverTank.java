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
      gameFrame.setSize(600, 600);
      gameFrame.setLocation(350, 150);
      gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gameFrame.setContentPane(new GamePanel());
      gameFrame.setVisible(true);   
   }
}
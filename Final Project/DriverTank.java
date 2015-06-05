import javax.swing.JFrame;
public class DriverTank
{
   public static void main(String[] args)
   {
      JFrame optionsFrame = new JFrame("Laservival");
      optionsFrame.setSize(600, 100);
      optionsFrame.setLocation(50, 50);
      optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      optionsFrame.setContentPane(new OptionsPanel());
      optionsFrame.setVisible(true);
      
      while(!OptionsPanel.completed())
      {
      }
      
      JFrame gameFrame = new JFrame("Game");
      gameFrame.setSize(600, 600);
      gameFrame.setLocation(50, 150);
      gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gameFrame.setContentPane(new GamePanel());
      gameFrame.setVisible(true);   
   }
}
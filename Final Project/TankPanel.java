import javax.swing.*;                        //import GUI
import java.awt.*;                        //import graphics
import java.awt.event.*;                    //import listeners
import java.awt.image.*;
public class TankPanel extends JPanel            //subclass of JPanel
{
   public TankPanel()                        //default constructor
   {
      setLayout(new BorderLayout());
      OptionsPanel options = new OptionsPanel();
      add(options, BorderLayout.NORTH);
      
      while(!OptionsPanel.completed())
      {
      }
      
      GamePanel game = new GamePanel();
      add(game, BorderLayout.CENTER);
   }
}

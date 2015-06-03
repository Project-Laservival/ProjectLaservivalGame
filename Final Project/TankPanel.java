import javax.swing.*;                        //import GUI
import java.awt.*;                        //import graphics
import java.awt.event.*;                    //import listeners
public class TankPanel extends JPanel            //subclass of JPanel
{
   public TankPanel()                        //default constructor
   {
      /*
      Set to border layout
      Instantiate and add OptionPanel()
      */
      
      setLayout(new BorderLayout());
      OptionsPanel options = new OptionsPanel();
      add(options, BorderLayout.NORTH);
   }
   public static void start()
   {
    /*
    Activated by OptionPanel
    Instantiate and add GamePanel()
    */
      GamePanel game = new GamePanel();
      add(game, BorderLayout.CENTER);      
   }
}

class OptionsPanel extends JPanel
{                                    //fields
   private JLabel tankChoice;                    //shows tank selection
   private JButton lightButton, mediumButton, heavyButton;
   private Tank tankType;                    //sets selection
   public OptionsPanel()
   {
      /*
      Instantiate 3 buttons for each tank type
    Each button sets tankType to their respective tanks
      Add same TankTypeListener to each
    Instantiate “Play” button that activates after selection
   */
      setLayout(new BorderLayout());
      
      tankChoice = new JLabel("Choose your tank.");
      add(tankChoice, BorderLayout.NORTH);
      
      lightButton = new JButton("Light Tank");
      lightButton.addActionListener(new TankTypeListener("light"));
      add(lightButton, BorderLayout.CENTER);
      
      mediumButton = new JButton("Medium Tank");
      mediumButton.addActionListener(new TankTypeListener("medium"));
      add(mediumButton, BorderLayout.CENTER);
      
      heavyButton = new JButton("Heavy Tank");
      heavyButton.addActionListener(new TankTypeListener("heavy"));
      add(heavyButton, BorderLayout.CENTER);
      
      JButton playButton = new JButton("Click to play.");
      playButton.addActionListener(new PlayListener());
      playButton.setEnabled(false);
      add(playButton, BorderLayout.SOUTH);
   }
   public Tank getTankType()                    //tank type getter
   {
      return tankType;
   }
   private class TankTypeListener implements ActionListener
   {
      private String myTank;
      public TankTypeListener(String name)
      {
         myTank = name;
      }
      public void actionPerformed(ActionEvent e)
      {
       /*
      Determines which tankType was chosen
      Sets JLabel appropriately
      Enables “Play” button
         */
         if(myTank.equals("light"))
         {
            tankType = new LightTank();
         }
         
         if(myTank.equals("medium"))
         {
            tankType = new MediumTank();
         }
         
         if(myTank.equals("heavy"))
         {
            tankType = new HeavyTank();
         }
         tankChoice.setText(myTank);
      }
   }
   private class PlayListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      /*
      Disable all buttons
      Start TankPanel.start() method
      */
         lightButton.setEnabled(false);
         mediumButton.setEnabled(false);
         heavyButton.setEnabled(false);
         TankPanel.start();
      }
   }
}


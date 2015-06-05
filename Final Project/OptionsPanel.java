import javax.swing.*;                        //import GUI
import java.awt.*;                        //import graphics
import java.awt.event.*;                    //import listeners
import java.awt.image.*;
public class OptionsPanel extends JPanel
{                                                //fields
   private JLabel tankChoice;                    //shows tank selection
   private JButton lightButton, mediumButton, heavyButton, playButton;
   private static Tank tankType;                    //sets selection
   public static boolean completed = false;

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
      
               
      JPanel buttonPanel = new JPanel(new FlowLayout());
      buttonPanel.setBackground(Color.WHITE);
      add(buttonPanel, BorderLayout.CENTER);
   
      lightButton = new JButton("Light Tank");
      lightButton.addActionListener(new TankTypeListener("Light"));
      lightButton.setBackground(Color.BLUE.brighter());
      buttonPanel.add(lightButton);
      
      mediumButton = new JButton("Medium Tank");
      mediumButton.addActionListener(new TankTypeListener("Medium"));
      mediumButton.setBackground(Color.GREEN);
      buttonPanel.add(mediumButton);
            
      heavyButton = new JButton("Heavy Tank");
      heavyButton.addActionListener(new TankTypeListener("Heavy"));
      heavyButton.setBackground(Color.RED);
      buttonPanel.add(heavyButton);
   
      playButton = new JButton("Click to play.");
      playButton.addActionListener(new PlayListener());
      playButton.setEnabled(false);
      add(playButton, BorderLayout.SOUTH);
   }

   public static Tank getTankType()                    //tank type getter
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
      
         if(myTank.equals("Light"))
         {
            tankType = new LightTank();
         }
      
         if(myTank.equals("Medium"))
         {
            tankType = new MediumTank();
         }
      
         if(myTank.equals("Heavy"))
         {
            tankType = new HeavyTank();
         }
         tankChoice.setText(myTank);
         playButton.setEnabled(true);
      }
   }

   private class PlayListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      /*
      Disable all buttons
      */
         lightButton.setEnabled(false);
         mediumButton.setEnabled(false);
         heavyButton.setEnabled(false);
         playButton.setEnabled(false);
         
         completed = true;
      }
   }
}

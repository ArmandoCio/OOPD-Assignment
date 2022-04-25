// Fig. 18.19: Fractal.java
// Fractal user interface.
import java.awt.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Fractal extends JFrame {

  private static final int WIDTH = 680; // define width of GUI
  private static final int HEIGHT = 580; // define height of GUI
  private static final int MIN_LEVEL = 0;
  private static final int MAX_LEVEL = 20;
  


  // set up GUI
  public Fractal() {
    super("Fractal");
    // set up levelJLabel to add to controlJPanel
    final JLabel levelJLabel = new JLabel("Level: 0");
    ListData listData = new ListData();
	  JList list1 = new JList(listData);

    FractalJPanel drawSpace = new FractalJPanel(0);




    JButton btnOpen;
    btnOpen = new JButton("view source code");
    // set up control panel
    final JPanel controlJPanel = new JPanel();
    controlJPanel.setLayout(new FlowLayout());
    
  


    // set up color button and register listener
    final JButton changeColorJButton = new JButton("Color");
    controlJPanel.add(changeColorJButton);
    changeColorJButton.addActionListener(
      new ActionListener() { // anonymous inner class
        // process changeColorJButton event
        @Override
        public void actionPerformed(ActionEvent event) {
          Color color = JColorChooser.showDialog(
            Fractal.this,
            "Choose a color",
            Color.BLUE
          );

          // set default color, if no color is returned
          if (color == null) color = Color.BLUE;

          drawSpace.setColor(color);
        }
      } // end anonymous inner class
    ); // end addActionListener

    // set up decrease level button to add to control panel and
    // register listener
    final JButton decreaseLevelJButton = new JButton("Decrease Level");
    controlJPanel.add(new RedDecorator(decreaseLevelJButton));
    decreaseLevelJButton.addActionListener(
      new ActionListener() { // anonymous inner class
        // process decreaseLevelJButton event
        @Override
        public void actionPerformed(ActionEvent event) {
          int level = drawSpace.getLevel();
          --level;

          // modify level if possible
          if ((level >= MIN_LEVEL) && (level <= MAX_LEVEL)) {
            levelJLabel.setText("Level: " + level);
            drawSpace.setLevel(level);
            repaint();
          }
        }
      } // end anonymous inner class
    ); // end addActionListener

    // set up increase level button to add to control panel
    // and register listener
    final JButton increaseLevelJButton = new JButton("Increase Level");
    controlJPanel.add(new BlueDecorator(increaseLevelJButton));
    increaseLevelJButton.addActionListener(
      new ActionListener() { // anonymous inner class
        // process increaseLevelJButton event
        @Override
        public void actionPerformed(ActionEvent event) {
          int level = drawSpace.getLevel();
          ++level;

          // modify level if possible
          if ((level >= MIN_LEVEL) && (level <= MAX_LEVEL)) {
            levelJLabel.setText("Level: " + level);
            drawSpace.setLevel(level);
            repaint();
          }
        }
      } // end anonymous inner class
    ); // end addActionListener
    controlJPanel.add(new GreenDecorator(btnOpen));

    controlJPanel.add(levelJLabel);

    // create mainJPanel to contain controlJPanel and drawSpace
    final JPanel mainJPanel = new JPanel();
    mainJPanel.add(controlJPanel);
    mainJPanel.add(drawSpace);


    add(mainJPanel); // add JPanel to JFrame

    setSize(WIDTH, HEIGHT); // set size of JFrame
    setVisible(true); // display JFrame

    JFrame frame = this;

    controlJPanel.add(list1);


    btnOpen.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          executeCommand(new OpenCommand(frame));
        }
      }
    );
  } // end constructor Fractal

  private void executeCommand(Command command) {
    // We could keep a command history in a stack here
    command.Execute();
  }

  public static void main(String[] args) {
    Fractal demo = new Fractal();
    demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GUIBuilder builder = new GUIBuilder();
    AbstractWidgetFactory widgetFactory = null;
    //check what platform we're on
    if (System.getProperty("os.name").toLowerCase().contains("mac")){
      widgetFactory  = new MacOSXWidgetFactory();
    } else {
      widgetFactory  = new MsWindowsWidgetFactory();
    }
    builder.buildWindow(widgetFactory, "Fractal");
  }
  

  class OpenCommand implements Command {

    private JFrame parent;

    OpenCommand(JFrame parent) {
      this.parent = parent;
    }

    public void Execute() {
      try {
        //constructor of file class having file as argument
        File file = new File("fig18_20_OLDSwingVersionforInstructorsNotUsingJavaFX/SourceCodeLink.txt");
        if (
          !Desktop.isDesktopSupported()
        ) //check if Desktop is supported by Platform or not
        {
          System.out.println("not supported");
          return;
        }
        Desktop desktop = Desktop.getDesktop();
        if (
          file.exists()
        ) desktop.open(file); //checks file exists or not   //opens the specified file
      } catch (Exception e) {
         System.out.println("File not found");
        e.printStackTrace();
      }
    }
  }

  public Fractal setLevel(int level) {
    return null;
  }
} // end class Fractal
/*************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

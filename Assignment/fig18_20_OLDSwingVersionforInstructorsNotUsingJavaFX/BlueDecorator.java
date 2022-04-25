import java.awt.*;
import java.awt.event.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class BlueDecorator extends Decorator {
    boolean mouse_over;    //true when mose over button
    JComponent thisComp;

    public BlueDecorator(JComponent b) {
        super(b);
        mouse_over = false;
        thisComp = this;//save this component

        //catch mouse movements in inner class
        b.addMouseListener(new MouseAdapter() {
               //set flag when mouse over
               public void mouseEntered(MouseEvent e) {
                       mouse_over = true;
                       thisComp.repaint();
               }
              //clear flag when mouse not over
              public void mouseExited(MouseEvent e) {
                       mouse_over = false;
                       thisComp.repaint();
               }
          });
    }

    //paint the button
    public void paint(Graphics g) {
        super.paint(g);      //first draw the parent button
    
        // Draw a red border if mouse is over
        if (mouse_over) {
            Dimension d = super.getSize();
            g.setColor(Color.blue);
            g.drawRect(0, 0, d.width-1, d.height-1);
            g.drawLine(d.width-1, 0, d.width-1, d.height-1);
            g.drawLine(0, d.height-1, d.width-1, d.height-1);


        }
    }


}

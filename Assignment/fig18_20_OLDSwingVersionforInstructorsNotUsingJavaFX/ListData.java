import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class ListData extends AbstractListModel{
    private Vector data;

    public ListData(){
        data = new Vector();
        data.add("Line 1");
        data.add("xA = 100");
        data.add("yA = 70");
        data.add("xB = 290");
        data.add("yB = 200");
        data.add("Line 2");
        data.add("xA = 10");
        data.add("yA = 70");
        data.add("xB = 90");
        data.add("yB = 20");
    }
    public int getSize(){
        return data.size();
    }
    public Object getElementAt(int index){
        return data.elementAt(index);
    }

}

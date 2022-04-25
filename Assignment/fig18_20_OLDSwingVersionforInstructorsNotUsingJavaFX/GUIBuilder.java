
//Client
public class GUIBuilder{
  public void buildWindow(AbstractWidgetFactory widgetFactory, String title){
    Window window = widgetFactory.createWindow(title);
    window.repaint();
  }
}





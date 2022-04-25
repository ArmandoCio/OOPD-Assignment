
//ConcreteFactory2
public class MacOSXWidgetFactory extends AbstractWidgetFactory{
  //create a MacOSXWindow
  public Window createWindow(String title){
    MacOSXWindow window = new MacOSXWindow(title);
    return window;
  }
}







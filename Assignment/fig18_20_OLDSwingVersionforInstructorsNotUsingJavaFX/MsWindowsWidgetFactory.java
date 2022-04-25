
//ConcreteFactory1
public class MsWindowsWidgetFactory extends AbstractWidgetFactory{
  //create an MSWindow
  public Window createWindow(String title){
    MSWindow window = new MSWindow(title);
    return window;
  }
}






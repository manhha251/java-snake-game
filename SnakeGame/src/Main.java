import Controller.Controller;
import View.View;

/*
 * Main class for executing program
 * Version: Alpha 1.0.0.1
 *
 * @author Luu Pham Manh Ha - 1752001
 */
public class Main{

    public static void main(String[] args){
        Controller controller = new Controller();
        controller.initScreen();
        controller.start();
    }
}
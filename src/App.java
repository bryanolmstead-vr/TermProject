// Java imports
import javax.swing.JFrame;
import javax.swing.JPanel;

// imports from classmates
import edu.bushnell.Home;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("TermProject");
        Home home = new Home();
        JPanel homePanel = home.makeGUI();
        frame.add(homePanel);
        frame.pack();   
        frame.setVisible(true);   
    }
}

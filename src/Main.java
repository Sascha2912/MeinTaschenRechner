import View.TaschenrechnerView;
import controller.TaschenrechnerController;
import model.TaschenrechnerModel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {



       //  Das ist best practice:
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new TaschenrechnerController(new TaschenrechnerView(), new TaschenrechnerModel());
            }
        });
    }
}
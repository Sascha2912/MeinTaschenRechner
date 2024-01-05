package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Display {

    public Display(Container container){

        this.createDisplay(container);

    }

    private void createDisplay(Container container){

        JPanel display = new JPanel();
        display.setLayout(new BorderLayout());
        display.setBorder(new EmptyBorder(10, 10, 10, 10));
        display.setOpaque(false);

        container.add(display, BorderLayout.NORTH);

        JTextField input = createTextField(display);


    }

    private JTextField createTextField(JPanel display) {

        JTextField temp = new JTextField();
        temp.setHorizontalAlignment(JTextField.RIGHT);
        temp.setBorder(null);
        temp.setEditable(false);

        display.add(temp);

        return temp;
    }

}

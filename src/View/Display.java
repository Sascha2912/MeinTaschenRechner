package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Display {
    private JTextField textField;

    public Display(Container container){

        this.createDisplay(container);

    }

    private void createDisplay(Container container){

        JPanel display = new JPanel();
        display.setLayout(new BorderLayout());
        display.setBorder(new EmptyBorder(10, 10, 10, 10));
        display.setOpaque(false);

        container.add(display, BorderLayout.NORTH);

        createTextField(display);


    }

    private void createTextField(JPanel display) {

        this.textField = new JTextField();
        this.textField.setHorizontalAlignment(JTextField.RIGHT);
        this.textField.setBorder(null);
        this.textField.setEditable(false);

        display.add(this.textField);

        // return temp;
    }

    public String getText(){
        return this.textField.getText();
    }

    public void setText(String text){
        this.textField.setText(text);
    }

}

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
        display.setLayout(new GridLayout(1, 1));
        display.setBorder(new EmptyBorder(10, 10, 10, 10));
        display.setOpaque(false);

        container.add(display, BorderLayout.NORTH);

        createTextField(display);


    }

    private void createTextField(JPanel display) {

        this.textField = new JTextField();
        this.textField.setFont(TaschenrechnerView.defaultFont);
        this.textField.setHorizontalAlignment(JTextField.RIGHT);
        this.textField.setBorder(null);
        // this.textField.setEditable(false);

        display.add(this.textField);

        // return temp;
    }

    public void clearDisplay(){
        this.textField.setText("");
    }

    public void deleteCharacterFromDisplay(){

        String displayText = this.textField.getText();

        if(displayText != null && !displayText.isEmpty()){

            this.textField.setText(displayText.substring(0,displayText.length() - 1));
        }

    }

    public String getText(){
        return this.textField.getText();
    }

    public void setText(String text){
        this.textField.setText(text);
    }

/*
public void writeToDisplay(String bntText){


        String text = this.concatInput(bntText);
        this.textField.setText(text);

    }

    // Button-Buffer auslesen
    private String concatInput(String bntText){

        String buffer = this.textField.getText();

        if(bntText.equals(".")){
            if(buffer.isEmpty()){
                buffer += "0";
            }
            boolean hasDecimalDot = this.validateInput(buffer);
            if(hasDecimalDot){
                return buffer;
            }
        }

        if(buffer != null && buffer.length() < 24){
            buffer += bntText;
        }
        return buffer;
    }

    // Wir prüfen ob der String bereits einen Dezimalpunkt enthält.
    private boolean validateInput(String input){

        return input.contains(".");
    }
    */

}

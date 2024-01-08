package controller;

import View.TaschenrechnerView;
import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaschenrechnerController {

    private double firstNumber;
    private TaschenrechnerView taschenrechnerView;
    private TaschenrechnerModel taschenrechnerModel;

    // Zwischen CalculatorController und CalculatorModel besteht eine Ganze-Teilebeziehung. Der Controller ist das
    // Ganze und das Model ist sein Teil. Ein Controller ohne Model bzw. ohne View kann es nicht geben, da wir alle
    // Abhängigkeiten über den Konstruktor injizieren. Es handelt sich also um Aggregationsbeziehungen zwischen
    // Controller und View und Controller und Model.
    public TaschenrechnerController(TaschenrechnerView taschenRechnerView, TaschenrechnerModel taschenrechnerModel){
        this.taschenrechnerView = taschenRechnerView;
        this.taschenrechnerModel = taschenrechnerModel;

        this.addActionListener(this.taschenrechnerView.getSpecialButtonPanel().getButton(0), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taschenrechnerView.getDisplay().clearDisplay();
            }
        });

        this.addActionListener(this.taschenrechnerView.getSpecialButtonPanel().getButton(1), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taschenrechnerView.getDisplay().deleteCharacterFromDisplay();
            }
        });

        this.addActionListener(this.taschenrechnerView.getSpecialButtonPanel().getButton(2), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taschenrechnerModel.setArithmeticStrategy(new moduloStrategie());

            }
        });

        this.taschenrechnerView.setArithmeticClickListener(new ArithmeticButtonClickListener());
    }

    private double calculateResult(){
        double result = 0.0D;
        double secondNumber;

        secondNumber = Double.parseDouble(taschenrechnerView.getTextFromDisplay());

        try{
            result = taschenrechnerModel.calculate(firstNumber, secondNumber);

        }catch(ArithmeticException ex){

            taschenrechnerView.showErrorMessage(ex.getMessage());

        }catch(NumberFormatException ex){
            taschenrechnerView.showErrorMessage(ex.getMessage());
        }
        return result;
    }

    // TODO: Mache if-else oder switch-case
    class ArithmeticButtonClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

            if(e.getActionCommand().equals("=")){
                double result = calculateResult();
                taschenrechnerView.getDisplay().clearDisplay();

                taschenrechnerView.writeToDisplay(String.valueOf(result));

                return;
            }

            String buffer = taschenrechnerView.getTextFromDisplay();
            try{
                firstNumber = Double.parseDouble(buffer);
                taschenrechnerView.getDisplay().clearDisplay();
            }catch(NumberFormatException ex){
                taschenrechnerView.showErrorMessage("Fehlerhafte Eingabe!");
            }


            if(e.getActionCommand().equals("+")){
                taschenrechnerModel.setArithmeticStrategy(new additionsStrategie());
                return;
            }

            if(e.getActionCommand().equals("-")){
                taschenrechnerModel.setArithmeticStrategy(new subtrationStrategie());
                return;
            }

            if(e.getActionCommand().equals("*")){
                taschenrechnerModel.setArithmeticStrategy(new multiplyStrategie());
                return;
            }

            if(e.getActionCommand().equals("/")){
                taschenrechnerModel.setArithmeticStrategy(new divisionStrategie());
                return;
            }

        }
    }

    private void addActionListener(JButton button, ActionListener actionListener){

        button.addActionListener(actionListener);

    }

}

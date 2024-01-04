package controller;

import View.TaschenrechnerView;
import model.*;

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

        this.taschenrechnerView.setArithmeticClickListener(new ArithmeticButtonClickListener());
    }

    private double calculateResult(){
        double result = 0.0D;
        double secondNumber;

        secondNumber = Double.parseDouble(taschenrechnerView.getInputFromDisplay());

        try{
            result = taschenrechnerModel.calculate(firstNumber, secondNumber);

        }catch(ArithmeticException ex){

            taschenrechnerView.displayErrorMessage(ex.getMessage());

        }catch(NumberFormatException ex){
            taschenrechnerView.displayErrorMessage(ex.getMessage());
        }

        System.out.println(result);
        return result;
    }

    // TODO: einfacher machen ...
    class ArithmeticButtonClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

            if(e.getActionCommand().equals("=")){
                double result = calculateResult();
                taschenrechnerView.clearDisplay();

                taschenrechnerView.writeToDisplay(String.valueOf(result));

                return;
            }

            String buffer = taschenrechnerView.getInputFromDisplay();
            try{
                firstNumber = Double.parseDouble(buffer);
                taschenrechnerView.clearDisplay();
            }catch(NumberFormatException ex){
                taschenrechnerView.displayErrorMessage("Fehlerhafte Eingabe!");
            }


            if(e.getActionCommand().equals("+")){
                taschenrechnerModel.setArithmeticStrategy(new additionsStrategie());

                System.out.println(firstNumber);
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

}

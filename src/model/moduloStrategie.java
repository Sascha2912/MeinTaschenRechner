package model;

public class moduloStrategie implements IArithmeticStrategy{

    @Override
    public double calculate(double firstNumber, double secondNumber){
        if(secondNumber == 0){

            throw new NumberFormatException("Teilen durch 0 ist nicht definiert");
        }
        return firstNumber % secondNumber;
    }

}


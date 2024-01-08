package model;

public class divisionStrategie implements IArithmeticStrategy{

    // TODO: double ist zu ungenau, nimm Math.BigDecimal stattdessen.
    @Override
    public double calculate(double firstNumber, double secondNumber){

        if(secondNumber == 0){

            throw new NumberFormatException("Teilen durch 0 ist nicht definiert");
        }
        return firstNumber / secondNumber;
    }

}

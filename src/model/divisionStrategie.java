package model;

public class divisionStrategie implements IArithmeticStrategy{

    @Override
    public double calculate(double firstNumber, double secondNumber){
/*        if(firstNumber != 0 && secondNumber != 0){
            return firstNumber / secondNumber;
        }
        return 0;*/

        if(secondNumber == 0){

            throw   new NumberFormatException("Teilen durch 0 ist nicht definiert");
        }
        return firstNumber / secondNumber;
    }

}

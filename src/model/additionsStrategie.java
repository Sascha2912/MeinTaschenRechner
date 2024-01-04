package model;

public class additionsStrategie implements IArithmeticStrategy {
    @Override
    public double calculate(double firstNumber, double secondNumber){
        return firstNumber + secondNumber;
    }

}

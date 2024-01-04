package model;

public class multiplyStrategie implements IArithmeticStrategy{

    @Override
    public double calculate(double firstNumber, double secondNumber){
        return firstNumber * secondNumber;
    }

}

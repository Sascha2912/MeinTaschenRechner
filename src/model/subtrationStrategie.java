package model;

public class subtrationStrategie implements  IArithmeticStrategy{

    @Override
    public double calculate(double firstNumber, double secondNumber){
        return firstNumber - secondNumber;
    }

}

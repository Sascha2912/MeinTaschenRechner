package model;

public class TaschenrechnerModel {

    private IArithmeticStrategy arithmeticStrategy;

    public void setArithmeticStrategy(IArithmeticStrategy arithmeticStrategy){
        this.arithmeticStrategy = arithmeticStrategy;
    }

    public double calculate(double firstNumber, double secondNumber){

        return this.arithmeticStrategy.calculate(firstNumber,secondNumber);
    }

}

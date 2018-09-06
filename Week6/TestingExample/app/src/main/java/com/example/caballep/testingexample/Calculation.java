package com.example.caballep.testingexample;

public class Calculation {

    int val1;
    int val2;

    Addition addition;
    Subtract subtract;
    Multiplication multiplication;
    Division division;

    public Calculation(Addition addition, Subtract subtract, Multiplication multiplication, Division division) {
        this.addition = addition;
        this.subtract = subtract;
        this.multiplication = multiplication;
        this.division = division;
    }

    public int addition() {

        addition.doNothing();
        return addition.add(val1, val2) + 5;
    }

    public int subtraction() {
        return subtract.subtract(val1, val2) + 10;
    }

    public int multiplication() {
        return multiplication.multiply(val1, val2) + 20;
    }

    public int divide() {
        return division.divide(val1, val2) + 30;
    }

    public void clear(){
        val1 = 0;
        val2 = 0;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }
}

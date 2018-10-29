package ru.job4j.calculator;

/**
 * Данный класс
 * служит для:
 * сложения, умножения, деления и вычитания
 * @author MKG
 * @version 1.0
 */
public class Calculator {
    private double result;

    /**
     * Method addition
     * @param first - first number
     * @param second - second number
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method substract
     * @param first - first number
     * @param second - second number
     */
    public void substract(double first, double second) {
        this.result = first - second;
    }
    /**
     * Method div
     * @param first - first number
     * @param second - second number
     */
    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     * Method multiple
     * @param first - first number
     * @param second - second number
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
    /**
     * Method getResult
     * @return result of calculation
     */
    public double getResult() {
        return this.result;
    }
}

package org.example;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public double div(int a, int b) {
        if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return (double) a / b;
    }

    public int mod(int a, int b) {
        if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return a % b;
    }

    public double pow(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}

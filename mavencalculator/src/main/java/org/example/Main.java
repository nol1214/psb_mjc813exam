package org.example;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("덧셈: " + calc.add(2, 3));
        System.out.println("뺄셈: " + calc.sub(10, 4));
        System.out.println("곱셈: " + calc.mul(2, 7));
        System.out.println("나눗셈: " + calc.div(8, 2));
        System.out.println("나머지: " + calc.mod(9, 4));
        System.out.println("제곱: " + calc.pow(2, 5));
        System.out.println("배열합: " + calc.sumArray(new int[]{1,2,3,4,5}));
    }
}

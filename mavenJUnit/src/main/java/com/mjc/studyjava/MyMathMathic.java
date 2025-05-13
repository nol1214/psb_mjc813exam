package com.mjc.studyjava;

/*public class MyMathMathic {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public long mul(int a, int b) {
        return (long) a * b;
    }

    public int divM(int a, int b) {
        return a / b;
    }

    public int divN(int a, int b) {
        return a % b;
    }

    public boolean same(int a, int b) {
        return a == b;
    }

    public boolean same(String a, String b) {
        return a.equals(b);
    }

    public boolean notSame(int a, int b) {
        return a != b;
    }

    public boolean big(int a, int b) {
        return a > b;
    }

    public boolean small(int a, int b) {
        return a < b;
    }

    public int shiftLeft(int a, byte b) {
        return a << b;
    }

    public int shiftRight(int a, byte b) {
        return a >> b;
    }

    public int shiftRight0(int a, byte b) {
        return a >>> b;
    }

    public long square(int a, byte b) {
        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    public int absolute(int a) {
        return Math.abs(a);
    }

    public String toHex(int a) {
        return Integer.toHexString(a);
    }

    public String toBin(int a) {
        return Integer.toBinaryString(a);
    }

    public String toOct(int a) {
        return Integer.toOctalString(a);
    }

    public int toDec(String a) {
        return Integer.parseInt(a);
    }
}*/


import java.math.BigDecimal;
import java.util.Random;

public class MyMathMathic {

    public BigDecimal getBigDecimal(Integer n, Integer s) {
        if (n == null || s == null) return BigDecimal.ZERO;
        String sStr = String.format("%07d", s);
        return new BigDecimal(n + "." + sStr);
    }

    public Integer[] getIntegerArray(int[] array) {
        if (array == null) return null;
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public int[] makeRandomIntArray(int n) {
        if (n <= 0) return new int[0];
        Random rand = new Random();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = rand.nextInt(10000); // 0~9999 범위
        }
        return result;
    }

    public String makeEncryptString(String text, int n) {
        if (text == null || n < 5) return "";
        Random rand = new Random();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int len = text.length();
        int totalLen = len * n;
        char[] result = new char[totalLen];

        for (int i = 0; i < totalLen; i++) {
            result[i] = chars.charAt(rand.nextInt(chars.length()));
        }

        for (int i = 0; i < len; i++) {
            result[i * n] = text.charAt(i);
        }

        return new String(result);
    }

    public String makeDecryptString(String code, int n) {
        if (code == null || n < 5) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < code.length(); i += n) {
            sb.append(code.charAt(i));
        }
        return sb.toString();
    }
}
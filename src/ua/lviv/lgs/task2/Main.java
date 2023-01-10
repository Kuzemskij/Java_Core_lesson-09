package ua.lviv.lgs.task2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Throwable{

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the value a");
        int a = s.nextInt();
        System.out.println("Enter the value b");
        int b = s.nextInt();

        try{
            if ((a < 0) && (b < 0)) {
                throw new IllegalArgumentException("числа від'мні");
            }
            if (((a == 0) && (b != 0)) || ((a != 0) && (b == 0))) {
                throw new ArithmeticException("одне з чисел дорівнює нолю, а інше ні");
            }
            if ((a == 0) && (b == 0)) {
                throw new IllegalAccessException("числа дорівнюють нулю");
            }
            if ((a > 0) && (b > 0)) {
                throw new MyException("числа додатні");
            }
        } catch (IllegalArgumentException | ArithmeticException | IllegalAccessException | MyException e) {
            System.err.println(e.getMessage());
        }

        Methods methods = new Methods(a, b);

        System.out.println("Summ: " + methods.pluss(a, b));
        System.out.println("Substraction: " + methods.minus(a, b));
        System.out.println("Multiply: " + methods.multiply(a, b));
        System.out.println("Devide: " + methods.devide(a, b));


    }

}

class Methods {
    private final int a;
    private final int b;

    public Methods(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int pluss(int a, int b){
        return a + b;
    }

    public int minus(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public double devide(int a, int b){
        return a / b;
    }

}


class MyException extends Exception{

    MyException(String message) {
        message = "числа додатні";
        System.out.println(message);
    }
}



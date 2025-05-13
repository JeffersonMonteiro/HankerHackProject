package codeinterviewquestions.mathoperations;

public class PowerCalculator {
    public static void main(String[] args) {

        double x = 2; // example base

        int n = 5; // example exponent

        double result = power(x, n);

        System.out.println(x + " raised to the power of " + n + " is " + result);

    }

    public static double power(double x, int n) {

        // Base case: any number raised to the power of 0 is 1

        if (n == 0) {

            return 1;

        }

        // If n is negative, compute the power for -n and take reciprocal

        if (n < 0) {

            return 1 / power(x, -n);

        }

        // Recursive call

        return x * power(x, n - 1);

    }


    public static int pow(int x, int n) {

        // Base case

        if (n == 0) {

            return 1;

        }

        // Recursive call

        return x * pow(x, n - 1);

    }

}

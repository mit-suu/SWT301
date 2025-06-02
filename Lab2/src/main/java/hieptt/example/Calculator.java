package hieptt.example;

public class Calculator {

    // Phương thức cộng hai số nguyên
    public int add(int a, int b) {
        return a + b;
    }

    // Phương thức chia hai số nguyên, kiểm tra chia cho 0
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
}


import java.util.Scanner;

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

public class UserDefinedException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your age:");
        int age = scanner.nextInt();

        try {
            checkAge(age);
            System.out.println("Age is valid.");
        } catch (MyException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void checkAge(int age) throws MyException {
        if (age < 18) {
            throw new MyException("Age should be 18 or above.");
        }
    }
}

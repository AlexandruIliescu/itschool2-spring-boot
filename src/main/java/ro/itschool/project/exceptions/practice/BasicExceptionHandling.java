package ro.itschool.project.exceptions.practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicExceptionHandling {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter two numbers:");
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException exception) {
            System.out.println("Cannot divide by 0.");
        } catch (InputMismatchException exception) {
            System.out.println("Please enter an integer.");
        }
    }
}
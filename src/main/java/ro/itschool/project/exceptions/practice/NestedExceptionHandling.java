package ro.itschool.project.exceptions.practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NestedExceptionHandling {

    public static void main(String[] args) {
        String filePath = "src/main/resources/test.txt";
        try (BufferedReader read = new BufferedReader(new FileReader(filePath))) {
            String line;
            int sum = 0;

            while ((line = read.readLine()) != null) {
                sum += Integer.parseInt(line);
            }
            System.out.println("Result: " + sum);
        } catch (NumberFormatException | IOException exception) {
            System.out.println("Something went wrong.");
        }
    }
}
package ro.itschool.project.utils;

public class Greeter {

    public String greet(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return "Hello, " + name + "!";
    }
}
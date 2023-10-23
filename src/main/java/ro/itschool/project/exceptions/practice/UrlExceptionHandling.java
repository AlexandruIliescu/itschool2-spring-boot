package ro.itschool.project.exceptions.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class UrlExceptionHandling {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://en.wikipedia.org/wiki/Text_file");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(Arrays.stream(e.getStackTrace()).toList());
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
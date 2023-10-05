package ro.itschool.project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class ProjectApplicationTests {

    @Test
    void contextLoads() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("https://www.google.com/", String.class);
        System.out.println(result);
    }
}
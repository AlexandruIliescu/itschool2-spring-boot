package ro.itschool.project.integration_tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ro.itschool.project.models.dtos.UserDTO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@Transactional
@AutoConfigureTestDatabase
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateUserShouldPass() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Maria");
        userDTO.setLastName("Popescu");
        userDTO.setEmail("maria@gmail.com");
        userDTO.setAge(24);

        MvcResult result = mockMvc.perform(post("/api/users")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isOk())
                .andReturn();

        String resultAsString = result.getResponse().getContentAsString();
        UserDTO userDTOConverted = objectMapper.readValue(resultAsString, new TypeReference<>() {
        });

        assertEquals(userDTOConverted.getFirstName(), userDTO.getFirstName());
        assertEquals(userDTOConverted.getLastName(), userDTO.getLastName());
        assertEquals(userDTOConverted.getEmail(), userDTO.getEmail());
    }

    @Test
    void testCreateUserWithInvalidEmailShouldFail() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("ab");

        MvcResult result = mockMvc.perform(post("/api/users")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isBadRequest())
                .andReturn();

        String resultAsString = result.getResponse().getContentAsString();
        assertTrue(resultAsString.contains("Invalid input"));
    }

    @Test
    void testGetAllUsers() throws Exception {
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setFirstName("Maria");
        userDTO1.setLastName("Popescu");
        userDTO1.setEmail("maria@gmail.com");
        userDTO1.setAge(24);

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setFirstName("Maria");
        userDTO2.setLastName("Popescu");
        userDTO2.setEmail("maria@gmail.com");
        userDTO2.setAge(24);

        List<UserDTO> users = new ArrayList<>();
        users.add(userDTO1);
        users.add(userDTO2);

        for (UserDTO userDTO : users) {
            mockMvc.perform(post("/api/users")
                            .contentType(APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(userDTO)))
                    .andExpect(status().isOk());
        }

        MvcResult result = mockMvc.perform(get("/api/users")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String resultAsString = result.getResponse().getContentAsString();
        List<UserDTO> userDTOConvertedList = objectMapper.readValue(resultAsString, new TypeReference<>() {
        });
        userDTOConvertedList.forEach(user -> log.info(user.getFirstName() + " -------- user from get all users API"));

        assertEquals(users.size(), userDTOConvertedList.size());
    }
}
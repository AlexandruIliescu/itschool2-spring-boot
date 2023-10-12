package ro.itschool.project.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.itschool.project.models.dtos.UserDTO;
import ro.itschool.project.models.entities.User;
import ro.itschool.project.repositories.UserRepository;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public UserServiceImpl(UserRepository userRepository,
                           ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User userEntity = objectMapper.convertValue(userDTO, User.class);

        User userResponseEntity = userRepository.save(userEntity);
        log.info("Created user with id: {}", userResponseEntity.getId());

        return objectMapper.convertValue(userResponseEntity, UserDTO.class);
    }
}
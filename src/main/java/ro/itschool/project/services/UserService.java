package ro.itschool.project.services;

import ro.itschool.project.models.dtos.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getUsers();
}
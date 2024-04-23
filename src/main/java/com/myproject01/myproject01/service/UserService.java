package com.myproject01.myproject01.service;


import com.myproject01.myproject01.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

 public UserDTO createUser(UserDTO userDTO);
 public UserDTO getUserById(Integer id);
 public void deleteUser(Integer id);
 public UserDTO updateUser(UserDTO userDTO, Integer id);
 public List<UserDTO> getAllUser();
}

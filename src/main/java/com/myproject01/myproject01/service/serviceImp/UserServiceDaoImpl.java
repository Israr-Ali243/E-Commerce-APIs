package com.myproject01.myproject01.service.serviceImp;

import com.myproject01.myproject01.dto.UserDTO;
import com.myproject01.myproject01.entity.User;
import com.myproject01.myproject01.exception.ResourceNotFoundException;
import com.myproject01.myproject01.repository.UserRepository;
import com.myproject01.myproject01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceDaoImpl implements UserService {

    @Autowired(required = true)
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = this.UserdtoToUser(userDTO);
        User SavedUser = this.userRepository.save(user);
        UserDTO userDTO1 = this.UsertoUserDTO(SavedUser);

        return userDTO1;
    }

    @Override
    public UserDTO getUserById(Integer id) {

        Optional<User> user = this.userRepository.findById(Long.valueOf(id));


        UserDTO userDTO = this.UsertoUserDTO(user.get());

        return userDTO;
    }

    @Override
    public void deleteUser(Integer id) {

        this.userRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer id) {

        if(userDTO==null){
            throw new ResourceNotFoundException("user", "id", Long.valueOf(id));
        }
        Optional<User> user = this.userRepository.findById(Long.valueOf(id));

        if(user.isPresent()){
       User updateUser = user.get();

       updateUser.setPassword(userDTO.getPassword());
       updateUser.setName(userDTO.getName());
       updateUser.setEmail(userDTO.getEmail());
       updateUser.setPhoneNumber(userDTO.getPhoneNumber());
       updateUser.setUserAddress(userDTO.getUserAddress());
       this.userRepository.save(updateUser);
       return this.UsertoUserDTO(updateUser);
        }

        return null;
    }

    @Override
    public List<UserDTO> getAllUser() {

    List<User> Userlist= this.userRepository.findAll();

  List<UserDTO> dtoList = Userlist.stream().map(user -> this.UsertoUserDTO(user)).collect(Collectors.toList());

        return dtoList;
    }

    public User UserdtoToUser(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setUserAddress(userDTO.getUserAddress());



        return user;
    }

    public UserDTO UsertoUserDTO(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setUserAddress(user.getUserAddress());
        userDTO.setPhoneNumber(user.getPhoneNumber());


        return userDTO;
    }
}

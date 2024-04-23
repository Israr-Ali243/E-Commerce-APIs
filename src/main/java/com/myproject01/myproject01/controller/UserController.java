package com.myproject01.myproject01.controller;


import com.myproject01.myproject01.dto.ProductDTO;
import com.myproject01.myproject01.dto.UserDTO;
import com.myproject01.myproject01.service.ProductService;
import com.myproject01.myproject01.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "user/")
@Slf4j
public class UserController {

@Autowired
private UserService userService;
@Autowired
private ProductService productService;

@PostMapping("/upload-file")
public String uploadFile(@RequestParam("file")MultipartFile file){
    System.out.println(file.getName());
    System.out.println(file.getSize());
    return "added succefully";
}


    @PostMapping("/add")
    public ResponseEntity<UserDTO> adduser(@Valid @RequestBody UserDTO userDTO){
        log.info("adduser() -> request received");
      UserDTO userDTO11=  this.userService.createUser(userDTO);
        log.info("adduser() -> request complete {}", userDTO11.toString());
      return new ResponseEntity<>(userDTO11, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity <UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable("id") Integer id) {

        return new ResponseEntity<>(this.userService.updateUser(userDTO, id), HttpStatus.OK);
    }

@GetMapping("id/{id}")
    public ResponseEntity<UserDTO> getUser(@Valid @PathVariable("id") Integer id){
        return ResponseEntity.ok(this.userService.getUserById(id));
    }

    @CrossOrigin
    @GetMapping("/getall")
    public ResponseEntity<List<UserDTO>> getAllUser(){

        return ResponseEntity.ok(this.userService.getAllUser());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@Valid @PathVariable("id") Integer id){
        log.info("adduser() -> request received");
     this.userService.deleteUser(id);
        log.info("adduser() -> request complete {}");
     return new ResponseEntity(Map.of("message", "User Deleted Succesfully"), HttpStatus.OK);
    }
}

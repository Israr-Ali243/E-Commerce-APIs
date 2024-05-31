package com.myproject01.myproject01.controller;


import com.myproject01.myproject01.dto.ProductDTO;
import com.myproject01.myproject01.dto.UserDTO;
import com.myproject01.myproject01.service.ProductService;
import com.myproject01.myproject01.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "user/")
@Slf4j
@Tag(name="User-Controller")
public class UserController {

@Autowired
private UserService userService;
@Autowired
private ProductService productService;

@PostMapping("/upload-file")
@Operation(summary = "Upload User-Profile")
public String uploadFile(@RequestParam("file")MultipartFile file){
    System.out.println(file.getName());
    System.out.println(file.getSize());
    return "added succefully";
}


    @PostMapping("/add")
    @Operation(summary = "Add new User ")
    public ResponseEntity<UserDTO> adduser(@Valid @RequestBody UserDTO userDTO){
        log.info("adduser() -> request received");
      UserDTO userDTO11=  this.userService.createUser(userDTO);
        log.info("adduser() -> request complete {}", userDTO11.toString());
      return new ResponseEntity<>(userDTO11, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    @Operation(summary = "Update User Record ")
    public ResponseEntity <UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable("id") Integer id) {

        return new ResponseEntity<>(this.userService.updateUser(userDTO, id), HttpStatus.OK);
    }

@GetMapping("id/{id}")
@Operation(summary = "Find User by Id")
    public ResponseEntity<UserDTO> getUser(@Valid @PathVariable("id") Integer id){
        return ResponseEntity.ok(this.userService.getUserById(id));
    }


    @GetMapping("/getall")
    @Operation(summary = "Find All Users ")
    public ResponseEntity<List<UserDTO>> getAllUser(){
        log.info("getuser() -> request received");
        return ResponseEntity.ok(this.userService.getAllUser());
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete User ")
    public ResponseEntity<?> deleteUser(@Valid @PathVariable("id") Integer id){
        log.info("adduser() -> request received");
     this.userService.deleteUser(id);
        log.info("adduser() -> request complete {}");
     return new ResponseEntity(Map.of("message", "User Deleted Succesfully"), HttpStatus.OK);
    }
}

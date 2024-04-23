package com.myproject01.myproject01.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDTO {

    private int id;
    @Size(min = 2 , message = "Enter Name size Greater than 2 charcters")
    private String name;
    @Size(min = 8, message = "Password must be 8 characters.")
    private String password;
    @Email(message = "Please Provide Valid Email")
    private String email;
    @Size( message = "Please Provide the valid Phone Number")
    private String phoneNumber;
    private  String userAddress;

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}

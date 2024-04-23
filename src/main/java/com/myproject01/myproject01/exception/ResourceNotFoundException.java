package com.myproject01.myproject01.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Setter
@Getter
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String recourseName;
    private String fieldName;
    private Long fieldValue;

    public ResourceNotFoundException(String recourseName, String fieldName, Long fieldValue) {
      super(String.format("%s not found with %s  : %d", recourseName, fieldName, fieldValue));
        this.recourseName = recourseName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}

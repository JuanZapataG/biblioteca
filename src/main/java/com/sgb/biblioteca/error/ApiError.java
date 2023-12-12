package com.sgb.biblioteca.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiError {


    private String message;

    public ApiError(String message) {
        this.message = message;
    }

}

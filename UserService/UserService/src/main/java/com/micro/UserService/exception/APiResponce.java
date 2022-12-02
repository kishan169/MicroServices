package com.micro.UserService.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class APiResponce {

    private String message;

    private boolean success;

    private HttpStatus status;
}

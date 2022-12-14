package com.nobarefeet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class Response {
    private HttpStatus status;
    private String mensagem;
}

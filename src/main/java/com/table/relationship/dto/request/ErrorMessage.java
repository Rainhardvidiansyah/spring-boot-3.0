package com.table.relationship.dto.request;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
public class ErrorMessage {

    private HttpStatus httpStatus;
    private int statusCode;
    private String message;
}

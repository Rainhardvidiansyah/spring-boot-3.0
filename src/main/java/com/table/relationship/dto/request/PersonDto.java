package com.table.relationship.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
public class PersonDto {

    @NotBlank(message = "Person id must not be null")
    @NotEmpty
    private String PersonID;

    @NotBlank(message = "User name not allowed if empty")
    @NotEmpty
    @Size(min = 4, max = 30, message = "User name must be between 4 to 30 characters")
    private String Name;

    @NotBlank(message = "User's email must be written")
    @NotEmpty
    @Email
    private String email;

    @Valid
    @NotNull(message = "Address Cannot be null")
    private List<AddressDto> addresses = new ArrayList<>();
}

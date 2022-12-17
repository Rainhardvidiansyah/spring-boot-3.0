package com.table.relationship.dto.request;

import com.table.relationship.validate.password.MatchPasswordAnnotation;
import com.table.relationship.validate.password.PasswordMustANumberAnnotation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@MatchPasswordAnnotation(message = "Confirm password doesn't match with password")
public class UserRegistrationRequestDto {

    @NotBlank(message = "Name is mandatory")
    private String userName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Your email must contain email format")
    private String email;

    @PasswordMustANumberAnnotation(message = "Password must be a number")
    @Size(min = 8, max = 8, message = "Password must contain 8 characters")
    private String password;

    @NotBlank(message = "Confirmation password must be written")
    private String confirmPassword;
}

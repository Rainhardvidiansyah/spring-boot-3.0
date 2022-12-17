package com.table.relationship.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
public class AddressDto {

    @NotBlank(message = "Street name must be written")
    @NotNull(message = "Street name cannot be null")
    private String streetName;

    @NotBlank(message = "District Must be written")
    @NotNull(message = "District name cannot be null")
    private String district;
}

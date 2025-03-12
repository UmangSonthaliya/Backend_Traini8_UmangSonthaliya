package com.traini8.backend_traini8.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable   // This annotation is used to specify that a class will be embedded by other entities
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String detailedAddress;
    private String city;
    private String state;

    @Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be 6 digits") // This annotation is used to validate the pincode
    private String pincode;
}

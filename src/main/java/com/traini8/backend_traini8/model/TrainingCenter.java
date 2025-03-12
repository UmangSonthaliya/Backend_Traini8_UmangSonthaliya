package com.traini8.backend_traini8.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Entity  //
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingCenter {

    @Id   //this annotation is used to specify the primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 40)
    @NotBlank
    private String centerName;

    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "CenterCode must be exactly 12 alphanumeric characters")
    @NotBlank
    private String centerCode;

    @Embedded  //this annotation is used to specify that a class will be embedded by other entities
    private Address address;

    private Integer studentCapacity;

    @ElementCollection      //this annotation is used to specify a collection of basic types
    private List<String> coursesOffered;

    @Column(updatable = false)    //this annotation is used to specify that a column will not be updated
    private Instant createdOn; //instant is used to store date and time

    @Email(message = "Invalid email format")
    private String contactEmail;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    @NotBlank
    private String contactPhone;

    @PrePersist  //jpa annotation for lifecycle . for example, this method will be called before persisting the object
    protected void onCreate() {
        this.createdOn = Instant.now();
    }
}

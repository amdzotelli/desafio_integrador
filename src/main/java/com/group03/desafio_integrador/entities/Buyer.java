package com.group03.desafio_integrador.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buyerId;

    @NotBlank
    @Size(min = 3, max = 40, message = "The buyer name must have at least 3 characters and cannot exceed 40 characters")
    private String buyerName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 11, max = 11, message = "The cpf must have 11 characters")
    private String cpf;

    @NotBlank
    @Size(min = 3, max = 40, message = "The city must have at least 3 characters and cannot exceed 40 characters")
    private String city;

    @NotBlank
    @Size(min = 3, max = 40, message = "The state must have at least 3 characters and cannot exceed 40 characters")
    private String state;

    @NotBlank
    private String cep;

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
    @Past
    private LocalDate birthDate;

    @NotBlank
    private String gender;

}

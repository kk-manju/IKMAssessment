package com.ikm.filemanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
@Table(name="fm_citizen")
public class CitizenData {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

    @NotBlank
    @Column(name="name")
    String name;

    @NotEmpty
    @Column(name="address")
    String address;

    @Column(name="phone")
    String phone;


    @Past(message = "Birth date must be past date")
    @Column(name="dateOfBirth")
    Date dateOfBirth;
}

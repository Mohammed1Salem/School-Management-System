package com.example.schoolmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(15) not null")
    private String area;
    @Column(columnDefinition = "varchar(20) not null")
    private String street;
    @Column(columnDefinition = "varchar(5) not null")
    private String buildingNumber;

    @OneToOne
    @JsonIgnore
    @MapsId
    private Teacher teacher;

}

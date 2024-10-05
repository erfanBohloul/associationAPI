package com.api.assocaitionAPI.model.account;

import jakarta.persistence.*;
import lombok.Data;


@MappedSuperclass
@Data
public abstract class Person {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

}

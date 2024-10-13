package com.api.assocaitionAPI.model.event;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date startDate;
    private Date endDate;

    @OneToMany(mappedBy = "event", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<Staff> staffs = new HashSet<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.PERSIST)
    private Set<Sponsor> sponsors = new HashSet<>();
}

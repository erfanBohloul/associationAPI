package com.api.assocaitionAPI.model.event;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double supportAmount;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}

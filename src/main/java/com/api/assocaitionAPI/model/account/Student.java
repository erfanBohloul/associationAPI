package com.api.assocaitionAPI.model.account;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Student extends User {

    private String studentNumber;
    private String major;

    // TODO list of events
}

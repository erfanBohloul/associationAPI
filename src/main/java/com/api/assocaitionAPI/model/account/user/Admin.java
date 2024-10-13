package com.api.assocaitionAPI.model.account.user;

import com.api.assocaitionAPI.model.account.Role;
import com.api.assocaitionAPI.model.account.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Admin extends User {
}

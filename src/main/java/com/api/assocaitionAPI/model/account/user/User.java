package com.api.assocaitionAPI.model.account.user;

import com.api.assocaitionAPI.model.account.GrantedAuthority;
import com.api.assocaitionAPI.model.account.Person;
import com.api.assocaitionAPI.model.account.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public abstract class User extends Person {
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<GrantedAuthority> authorities = new HashSet<>();

}

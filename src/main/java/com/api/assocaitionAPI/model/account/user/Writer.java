package com.api.assocaitionAPI.model.account.user;

import com.api.assocaitionAPI.model.event.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Writer extends User {

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Post> posts = new HashSet<>();
}

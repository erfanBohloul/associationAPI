package com.api.assocaitionAPI.model.account;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String objectType;

    @Column(nullable = false)
    private Long objectId;

    @Column(nullable = false)
    private String permission;

    @Transient
    private String grantedAuthorityString;

    @PostLoad
    private void compileGrantedAuthorityString() {
        grantedAuthorityString = objectId + "_" +
                objectType + "_" + permission;
    }

    public String getAuthority() {
        return grantedAuthorityString;
    }

}

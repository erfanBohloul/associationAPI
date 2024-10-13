package com.api.assocaitionAPI.model.event;

import com.api.assocaitionAPI.model.account.user.Writer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Writer writer;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + getId() +
                ", writer=" + getWriter().getUsername() +
                ", title=" + getTitle();
    }

}

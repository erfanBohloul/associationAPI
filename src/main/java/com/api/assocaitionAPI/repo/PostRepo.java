package com.api.assocaitionAPI.repo;

import com.api.assocaitionAPI.model.event.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
}

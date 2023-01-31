package com.example.restmysql.repositories;

import com.example.restmysql.models.PlaylistModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PlaylistRepository extends CrudRepository<PlaylistModel, Long> {
    ArrayList<PlaylistModel> findByUserEmail(String email);
    ArrayList<PlaylistModel> findByUserId(Long id);
}

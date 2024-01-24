package com.jackhodge.DataViewTool.repository;

import com.jackhodge.DataViewTool.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}

package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.UserEntity;
@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
	public Optional<UserEntity> findByEmail(String email);
}

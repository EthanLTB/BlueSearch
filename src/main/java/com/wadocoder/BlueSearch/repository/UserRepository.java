package com.wadocoder.BlueSearch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wadocoder.BlueSearch.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}

package com.wadocoder.BlueSearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wadocoder.BlueSearch.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
@Query("select u from User u"+
       " left join fetch u.authorities"+
	   " where u.username = :username")
	User findByUsername(String username);

}

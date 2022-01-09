package com.wadocoder.BlueSearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wadocoder.BlueSearch.domain.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}

package com.wadocoder.BlueSearch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wadocoder.BlueSearch.domain.Comment;
import com.wadocoder.BlueSearch.domain.Post;
import com.wadocoder.BlueSearch.domain.User;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

	List<Comment> findAllByUser(Optional<User> user);

	

	List<Comment> findAllByPost(Post post);



	void deleteByCommentId(Long commentId);



	Comment findByCommentId(Long commentId);

}

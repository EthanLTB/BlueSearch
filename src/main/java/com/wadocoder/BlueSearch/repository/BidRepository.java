package com.wadocoder.BlueSearch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wadocoder.BlueSearch.domain.Bid;
import com.wadocoder.BlueSearch.domain.User;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long>{

	List<Bid> findAllByUser(Optional<User> user);

}

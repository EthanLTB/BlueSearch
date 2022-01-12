package com.wadocoder.BlueSearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wadocoder.BlueSearch.domain.Bid;
import com.wadocoder.BlueSearch.repository.BidRepository;
import com.wadocoder.BlueSearch.repository.UserRepository;

@Service
public class BidService {
	@Autowired
	private BidRepository bidRepo;
	@Autowired
	private UserRepository userRepo;

	public List<Bid> findAllByUserId(Long userId) {
		
		return bidRepo.findAllByUser(userRepo.findById(userId));
	}

}

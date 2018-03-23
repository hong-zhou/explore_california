package com.hongzhou.ec.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hongzhou.ec.domain.TourRating;
import com.hongzhou.ec.domain.TourRatingPk;

@RepositoryRestResource(exported=false)
public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingPk> {
	 
	// lookup all the TourRatings for a tour
	List<TourRating> findByPkTourId(Integer tourId);
	
	Page<TourRating> findByPkTourId(Integer tourId, Pageable pageable);
	
	// lookup a TourRating by the TourId and Customer Id
	TourRating findByPkTourIdAndPkCustomerId(Integer tourId, Integer customerId);
}

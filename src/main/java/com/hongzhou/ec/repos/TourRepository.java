package com.hongzhou.ec.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.hongzhou.ec.domain.Tour;

public interface TourRepository extends /*CrudRepository<Tour, Integer>*/ PagingAndSortingRepository<Tour, Integer> {
	//List<Tour> findByTourPackageCode(@Param("code") String code);
	Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);

	@Override
	@RestResource(exported=false)
	void delete(Integer arg0);

	@Override
	@RestResource(exported=false)
	void delete(Iterable<? extends Tour> arg0);

	@Override
	@RestResource(exported=false)
	void delete(Tour arg0);

	@Override
	@RestResource(exported=false)
	void deleteAll();

	@Override
	@RestResource(exported=false)
	<S extends Tour> Iterable<S> save(Iterable<S> arg0);

	@Override
	@RestResource(exported=false)
	<S extends Tour> S save(S arg0);
	
	
}

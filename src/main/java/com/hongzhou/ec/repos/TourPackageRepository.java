package com.hongzhou.ec.repos;

import org.springframework.data.repository.CrudRepository;

import com.hongzhou.ec.domain.TourPackage;

public interface TourPackageRepository extends CrudRepository<TourPackage, String> {

	TourPackage findByName(String name);
}

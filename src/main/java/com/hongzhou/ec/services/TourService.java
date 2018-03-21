package com.hongzhou.ec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hongzhou.ec.domain.Difficulty;
import com.hongzhou.ec.domain.Region;
import com.hongzhou.ec.domain.Tour;
import com.hongzhou.ec.domain.TourPackage;
import com.hongzhou.ec.repos.TourPackageRepository;
import com.hongzhou.ec.repos.TourRepository;

@Service
public class TourService {
	private TourPackageRepository tourPackageRepository;
	private TourRepository tourRepository;
	
	@Autowired
	public TourService(TourPackageRepository tourPackageRepository, TourRepository tourRepository) {
		super();
		this.tourPackageRepository = tourPackageRepository;
		this.tourRepository = tourRepository;
	}
	
	public Tour createTour(String title, String description, String blurb, Integer price, String duration,
			String bullets, String keywords, String /*tourPackageCode*/ tourPackageName, Difficulty difficulty, Region region) {
		
		TourPackage tourPackage = tourPackageRepository./*findOne(tourPackageCode)*/findByName(tourPackageName);
		if (tourPackage == null) {
			throw new RuntimeException("Tour package does not exist: " + tourPackageName);
		}
		
		return tourRepository.save(new Tour(title, description, blurb, price, duration,
			bullets, keywords, tourPackage, difficulty, region));
	}
	
	public Iterable<Tour> lookup(){
		return tourRepository.findAll();
	}

	public long total() {
		return tourRepository.count();
	}
}

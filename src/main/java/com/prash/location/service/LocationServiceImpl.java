package com.prash.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prash.location.entities.Location;
import com.prash.location.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public Location saveLocation(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		 locationRepository.delete(location);

	}

	@Override
	public Location getLocationById(int id) {
		return locationRepository.getOne(id);
	}

	@Override
	public List<Location> getAllLocation() {
		return locationRepository.findAll();	
	}

	public LocationRepository getLocationRepository() {
		return locationRepository;
	}

	public void setLocationRepository(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

}

package com.prash.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.prash.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}

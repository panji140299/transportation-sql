package com.hacktiv8.transportation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hacktiv8.transportation.models.bus.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {

	@Query(value = "SELECT trip.* FROM trip INNER JOIN agency ON (trip.agency_id = agency.id) "
			+ "INNER JOIN bus ON (trip.bus_id = bus.id) INNER JOIN stop destStop ON (trip.deststop_id = destStop.id) "
			+ "INNER JOIN stop sourceStop ON (trip.sourcestop_id = sourceStop.id) WHERE trip.deststop_id=?1 AND trip.sourcestop_id=?2", 
			nativeQuery = true) 
    List<Trip> findByStops(Integer destStop, Integer sourceStop);

}

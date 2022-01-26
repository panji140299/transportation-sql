package com.hacktiv8.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hacktiv8.transportation.models.bus.TripSchedule;

public interface TripScheduleRepository extends JpaRepository<TripSchedule, Long> {

}

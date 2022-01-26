package com.hacktiv8.transportation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hacktiv8.transportation.models.bus.Stop;

@Repository
public interface StopRepository extends JpaRepository<Stop, Long> {
	@Modifying
    @Query(value = "SELECT * FROM public_stop WHERE id NOT IN (SELECT id FROM public_stop WHERE id =?1)", nativeQuery = true)
    List<Stop> findStop(int idstop);
}

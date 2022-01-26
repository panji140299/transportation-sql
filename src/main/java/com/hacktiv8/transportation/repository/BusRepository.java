package com.hacktiv8.transportation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hacktiv8.transportation.models.bus.Bus;

public interface BusRepository extends JpaRepository<Bus, Long> {

	@Modifying
    @Query(value = "SELECT * FROM public_bus inner join public_agency on public_bus.agency_id=public_agency.id where public_bus.agency_id=?1", nativeQuery = true)
    List<Bus> findByAgency(int idagency);

}

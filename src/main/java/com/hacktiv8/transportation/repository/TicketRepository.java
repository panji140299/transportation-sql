package com.hacktiv8.transportation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hacktiv8.transportation.models.User;
import com.hacktiv8.transportation.models.bus.Ticket;
import com.hacktiv8.transportation.models.bus.TripSchedule;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	List<Ticket> findByPassenger(User passenger);

	List<Ticket> findByTripschedule(TripSchedule tripschedule);

	List<Ticket> findBySeatNumber(int seatNumber);

}

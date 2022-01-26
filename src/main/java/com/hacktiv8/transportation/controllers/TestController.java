package com.hacktiv8.transportation.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hacktiv8.transportation.models.ERole;
import com.hacktiv8.transportation.models.Role;
import com.hacktiv8.transportation.models.User;
import com.hacktiv8.transportation.models.bus.Agency;
import com.hacktiv8.transportation.models.bus.Bus;
import com.hacktiv8.transportation.models.bus.Stop;
import com.hacktiv8.transportation.models.bus.Ticket;
import com.hacktiv8.transportation.models.bus.Trip;
import com.hacktiv8.transportation.models.bus.TripSchedule;
import com.hacktiv8.transportation.payload.request.BookTicketRequest;
import com.hacktiv8.transportation.payload.request.SignupRequest;
import com.hacktiv8.transportation.payload.response.AgencyResp;
import com.hacktiv8.transportation.payload.response.BusResp;
import com.hacktiv8.transportation.payload.response.MessageResponse;
import com.hacktiv8.transportation.payload.response.TripResp;
import com.hacktiv8.transportation.payload.response.Trip.TripDTO;
import com.hacktiv8.transportation.payload.response.TripSchedule.TripScheduleDTO;
import com.hacktiv8.transportation.repository.AgencyRepository;
import com.hacktiv8.transportation.repository.BusRepository;
import com.hacktiv8.transportation.repository.RoleRepository;
import com.hacktiv8.transportation.repository.StopRepository;
import com.hacktiv8.transportation.repository.TicketRepository;
import com.hacktiv8.transportation.repository.TripRepository;
import com.hacktiv8.transportation.repository.TripScheduleRepository;
import com.hacktiv8.transportation.repository.UserRepository;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

import com.hacktiv8.transportation.payload.request.agency.AgencyDTO;
import com.hacktiv8.transportation.payload.request.bus.BusDto;
import com.hacktiv8.transportation.payload.request.user.UserDto;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@SecurityScheme(name = "apiAuth", type = SecuritySchemeType.HTTP, scheme = "bearer")
@RequestMapping("/api/v1")
public class TestController {
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	StopRepository stopRepository;
	
	@Autowired
	BusRepository busRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AgencyRepository agencyRepository;
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	TripRepository tripRepository;
	
	@Autowired
	TripScheduleRepository tripScheduleRepository;
	
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  @Operation(description = "Auth API KEY")
  @SecurityRequirement(name = "apiAuth")
  @PreAuthorize("hasAuthority('PASSENGER') or hasAuthority('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/admin")
  @Operation(description = "Auth API KEY")
  @SecurityRequirement(name = "apiAuth")
  @PreAuthorize("hasAuthority('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }
  
 
  @GetMapping("/reservation/tripsbystops") 
  public ResponseEntity<?> tripsbystops(@RequestBody Trip trip) { 
      Integer destStop = trip.getDeststop().getId().intValue(); 
      Integer sourceStop = trip.getSourcestop().getId().intValue(); 
      List<Trip> byStops = tripRepository.findByStops(destStop, sourceStop); 
      return ResponseEntity.ok().body(byStops); 
  }
  @GetMapping("/reservation/user")
  public List<User> user(){
	  return userRepository.findAll();   
  }
  
  @GetMapping("/reservation/getagency")
  public List<Agency> agency(){
	  return agencyRepository.findAll();
  }
  @GetMapping("/reservation/getbus")
  public List<Bus> bus(){
	  return busRepository.findAll();
  }
  @GetMapping("reservation/byrole")
  public ResponseEntity<?> readByRole(@Valid @RequestParam long roleId) { 
      Role role = new Role(); 
      role.setId(roleId); 
      List<User> byRole = userRepository.findByRoles(role); 

      if (byRole.isEmpty()) { 
          return ResponseEntity.status(404).body("Daftar User dengan role id = " + roleId + " tidak ditemukan."); 
      } else { 
          return ResponseEntity.ok(byRole); 
      } 
  }
  @GetMapping("reservation/byagency")
  public ResponseEntity<?> readByAgency(@Valid @RequestParam int agencyId) { 
	  List<Bus> bus = busRepository.findByAgency(agencyId);
	  List<BusResp> busDto = bus.stream()
			  .map(t->new BusResp(
					  t.getId(),
					  t.getCode(),
					  t.getCapacity(),
					  t.getMake(),
					  t.getAgency().getName()))
			  .collect(Collectors.toList());
	  
	  return ResponseEntity.ok(busDto);
  }
  @GetMapping("reservation/bystop")
  public ResponseEntity<?> readByStop(@Valid @RequestParam int stopid) { 
	  List<Stop> stop = stopRepository.findStop(stopid);
	  
	  return ResponseEntity.ok(stop);
  }
  
  
  @GetMapping("/reservation/stops")
	public List<Stop> getStop(){
		return stopRepository.findAll();
	}
 
  
  @GetMapping("/reservation/tripschedule")
 	public ResponseEntity<?> getTripSchedule(){
	  List<TripSchedule> tripSchedule = tripScheduleRepository.findAll();
	  List<TripScheduleDTO> tripScheduleDto = tripSchedule.stream()
			  .map(t-> new TripScheduleDTO(
					  t.getFare(),
					  t.getTripDate(),
					  t.getAvailableSeat(),
					  t.getTripDetail(),
					  t.getTicketSold(),
					  t.getTrip().getId().intValue()))
			  .collect(Collectors.toList());
	  return ResponseEntity.ok(tripScheduleDto);
 	}
  @GetMapping("/reservation/trip")
  public ResponseEntity<?> getTrip(){
	  List<Trip> trips = tripRepository.findAll();
	  List<TripResp> tripDto = trips.stream()
			  .map(t->new TripResp(
					  t.getFare(),
					  t.getJourneyTime(),
					  t.getAgency().getName(),
					  t.getSourcestop().getName(),
					  t.getDeststop().getName(),
					  t.getBus().getCode()))
			  .collect(Collectors.toList());
	  
	  return ResponseEntity.ok(tripDto);
  }
  
  @GetMapping("/reservation/agency")
  public ResponseEntity<?> getAgency(){
	  List<Agency> agency = agencyRepository.findAll();
	  List<AgencyResp> agencyDto = agency.stream()
			  .map(t->new AgencyResp(
					  t.getCode(),
					  t.getName(),
					  t.getDetails(),
					  t.getOwner().getFirstname()+" "+t.getOwner().getLastname()))
			  .collect(Collectors.toList());
	  
	  return ResponseEntity.ok(agencyDto);
  }
  @GetMapping("/reservation/bus")
  public ResponseEntity<?> getBus(){
	  List<Bus> bus = busRepository.findAll();
	  List<BusResp> busDto = bus.stream()
			  .map(t->new BusResp(
					  t.getId(),
					  t.getCode(),
					  t.getCapacity(),
					  t.getMake(),
					  t.getAgency().getName()))
			  .collect(Collectors.toList());
	  
	  return ResponseEntity.ok(busDto);
  }
  
  
  
  
  
  
//  @PreAuthorize("hasAuthority('owner') or hasAuthority('passenger') or hasAuthority('admin')") 
  @PostMapping("/reservation/bookticket") 
  public ResponseEntity<?> bookticket(@Valid @RequestBody Ticket ticket) { 
      User passenger = new User(); 
      passenger.setId(ticket.getPassenger().getId()); 
      TripSchedule tripSchedule = new TripSchedule(); 
      tripSchedule.setId(ticket.getTripschedule().getId()); 
      List<Ticket> byPassenger = ticketRepository.findByPassenger(passenger); 
      List<Ticket> byTripSchedule = ticketRepository.findByTripschedule(tripSchedule); 
      List<Ticket> bySeatNumber = ticketRepository.findBySeatNumber(ticket.getSeatNumber()); 
      if (!byPassenger.isEmpty() && !byTripSchedule.isEmpty() && !bySeatNumber.isEmpty()) { 
          return ResponseEntity.status(HttpStatus.NOT_FOUND) 
                  .body("Ticket dengan id passenger = " + ticket.getPassenger().getId() 
                          + " dan dengan id trip schedule " + ticket.getTripschedule().getId() 
                          + " dan dengan seat number " + ticket.getSeatNumber() + " sudah ada."); 
      } else { 
          TripSchedule tripScheduleNew = tripScheduleRepository.findById(ticket.getTripschedule().getId()).get(); 
          if (tripScheduleNew.getAvailableSeat() > 0) { 
              tripSchedule.setAvailableSeat(tripScheduleNew.getAvailableSeat() - 1); 
              tripSchedule.setTicketSold(tripScheduleNew.getTicketSold() + 1); 
              tripSchedule.setTrip(tripScheduleNew.getTrip()); 
              tripSchedule.setFare(tripScheduleNew.getFare());
              tripSchedule.setTripDate(tripScheduleNew.getTripDate());
              tripScheduleRepository.save(tripSchedule); 
              ticketRepository.save(ticket);
              return ResponseEntity.ok().body("Ticket Berhasil di Booking"); 
          } else { 
              return ResponseEntity.status(HttpStatus.NOT_FOUND) 
                      .body("Trip Schedule yang anda pilih, sudah tidak tersedia bangkunya."); 
          } 
      } 
  }
  
  	@PostMapping("/reservation/agency-add")
//  	@PreAuthorize("hasAuthority('admin')")
  	public ResponseEntity<?> agencycreate(@Valid @RequestBody AgencyDTO agencyDto){
  		Agency agency = new Agency();
  		User owner = new User();
  		
  		owner.setId(agencyDto.getOwner());
  		
  		agency.setCode(agencyDto.getCode());
  		agency.setDetails(agencyDto.getDetails());
  		agency.setName(agencyDto.getName());
  		agency.setOwner(owner);
  		
//  		Set<String> strRoles = agencyDto.getRole();
//  		Set<Role> roles = new HashSet<>();
  		
//  		if (strRoles == null) {
//  	      Role userRole = roleRepository.findByName(ERole.OWNER)
//  	          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//  	    roles.add(userRole);
//  		}
  	    
//  		owner.setRoles(roles);
  		return ResponseEntity.ok(agencyRepository.save(agency));
  	}
  	@PostMapping("/reservation/trip-add")
  	public ResponseEntity<?> tripcreate(@Valid @RequestBody TripDTO tripDto){
  		Trip trip = new Trip();
  		Bus bus = new Bus();
  		Stop sourcestop = new Stop();
  		Stop deststop = new Stop();
  		Agency agency = new Agency();
  		
  		bus.setId(tripDto.getBus());
  		agency.setId(tripDto.getAgency());
  		sourcestop.setId(tripDto.getSourcestop());
  		deststop.setId(tripDto.getDeststop());
  		
  		trip.setFare(tripDto.getFare());
  		trip.setJourneyTime(tripDto.getJourneyTime());
  		trip.setBus(bus);
  		trip.setAgency(agency);
  		trip.setSourcestop(sourcestop);
  		trip.setDeststop(deststop);
  		
  		return ResponseEntity.ok(tripRepository.save(trip));
  	}
  	
  	@PostMapping("/reservation/bus-add")
  	public ResponseEntity<?> buscreate(@Valid @RequestBody BusDto busDto){
  		Bus bus = new Bus();
  		Agency agency = new Agency();
  		
  		agency.setId(busDto.getAgency());
  		
  		bus.setCode(busDto.getCode());
  		bus.setCapacity(busDto.getCapacity());
  		bus.setMake(busDto.getMake());
  		bus.setAgency(agency);
  		
  		
  		
  		return ResponseEntity.ok(busRepository.save(bus));
  	}
  	
}

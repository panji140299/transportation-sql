package com.hacktiv8.transportation.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hacktiv8.transportation.models.ERole;
import com.hacktiv8.transportation.models.Role;
import com.hacktiv8.transportation.models.User;
import com.hacktiv8.transportation.payload.request.LoginRequest;
import com.hacktiv8.transportation.payload.request.SignupRequest;
import com.hacktiv8.transportation.payload.request.user.UserDto;
import com.hacktiv8.transportation.payload.response.JwtResponse;
import com.hacktiv8.transportation.payload.response.MessageResponse;
import com.hacktiv8.transportation.repository.RoleRepository;
import com.hacktiv8.transportation.repository.UserRepository;
import com.hacktiv8.transportation.security.jwt.JwtUtils;
import com.hacktiv8.transportation.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/auth")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());
    

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         roles));
  }
  @GetMapping("/user/profile/{id}")
  public User profile (@PathVariable(value = "id") long id){
	  Optional<User> user = userRepository.findById(id);
	  User users = user.get();
	  return users;
  }
  @PutMapping("/user/update/{id}")
  public ResponseEntity<?> updateProfile(@PathVariable(value = "id") long id, @Valid @RequestBody UserDto userDto){
	  Optional<User> user = userRepository.findById(id);
	  if (user.isPresent()) {
		  User updateUser = user.get();
		  
		  updateUser.setEmail(userDto.getEmail());
		  updateUser.setFirstname(userDto.getFirstname());
		  updateUser.setLastname(userDto.getLastname());
		  updateUser.setMobilenumber(userDto.getMobilenumber());
		  updateUser.setPassword(encoder.encode(userDto.getPassword()));
		  
		  return ResponseEntity.ok(userRepository.save(updateUser));
	  } else {
		  return ResponseEntity.status(404).body("User tidak ditemukan");
	  }
	  
  }

  @PostMapping("/user/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User(
               signUpRequest.getEmail(),
               signUpRequest.getFirstname(),
               signUpRequest.getLastname(),
               signUpRequest.getMobilenumber(),
               encoder.encode(signUpRequest.getPassword()
            		   ));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.PASSENGER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);
        case "owner":
            Role ownerRole = roleRepository.findByName(ERole.OWNER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(ownerRole);
          
          break;
          
        default:
          Role userRole = roleRepository.findByName(ERole.PASSENGER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
  
  
  
  
  @PostMapping("/auth/logout")
  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
      if (auth != null){      
         new SecurityContextLogoutHandler().logout(request, response, auth);  
      }  
       return "/login";  
   }  
}


package com.firatergun.gatewaydemo.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firatergun.gatewaydemo.entity.ApplicationUser;
import com.firatergun.gatewaydemo.repository.ApplicationUserRepository;
import com.firatergun.gatewaydemo.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/v3/merchant/users")
public class UserController {
	
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;
    
	private ApplicationUserRepository userRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserController(ApplicationUserRepository userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userRepo = userRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("/sign-up")
	public void signup(@RequestBody ApplicationUser userInfo){
		userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
		userRepo.save(userInfo);
	}
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody ApplicationUser userInfo){try {
        String username = userInfo.getUsername();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userInfo.getPassword()));
        String token = jwtTokenProvider.createToken(userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found")).getUsername());

        Map<Object, Object> model = new HashMap<>();
        //TODO update username to status approved enum !..
        model.put("status", username);
        model.put("token", token);
        return ok(model);
    } catch (AuthenticationException e) {
        throw new BadCredentialsException("Invalid username/password supplied");
    }}
}

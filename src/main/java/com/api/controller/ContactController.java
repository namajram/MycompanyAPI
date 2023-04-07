package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.beans.Contact;

import com.api.repository.ContactRepository;

@RestController
public class ContactController {
	@Autowired
	ContactRepository Contactrepository;
	
	
	
	
	@PostMapping("/Contact")
	public ResponseEntity postContact(@RequestBody Contact n) {
		String emailaddress = n.getEmailAddress();
		long phoneNumber = n.getPhoneNumber();
		Contact findByEmailAddress = Contactrepository.findByEmailAddress(emailaddress);
		Contact findByPhoneNumber = Contactrepository.findByPhoneNumber(phoneNumber);
		if (findByEmailAddress!= null ) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exist");
		}
		else if (findByPhoneNumber !=null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Phone Number already exist");
			} 
		else {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(Contactrepository.save(n));
		}
		
	}
	
	

}

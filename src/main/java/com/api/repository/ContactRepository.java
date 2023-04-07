package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.beans.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {

	Contact findByEmailAddress (String e);
	Contact findByPhoneNumber (Long e);
}

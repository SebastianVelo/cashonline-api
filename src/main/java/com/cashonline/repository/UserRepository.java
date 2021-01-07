package com.cashonline.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cashonline.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable>{

	public abstract User findById(long id);
	public abstract User findByEmail(String email);
	
}

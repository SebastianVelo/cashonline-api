package com.myecommerce.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myecommerce.entity.UserData;

@Repository("userDataRepository")
public interface UserDataRepository extends JpaRepository<UserData, Serializable>{

	public abstract UserData findById(long id);
	public abstract UserData findByIdUser(long idUser);
	
}

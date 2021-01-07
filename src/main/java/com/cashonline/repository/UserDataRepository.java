package com.cashonline.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cashonline.entity.UserData;

@Repository("userDataRepository")
public interface UserDataRepository extends JpaRepository<UserData, Serializable>{

	public abstract UserData findById(long id);
	public abstract UserData findByIdUser(long idUser);
	public abstract Long deleteByIdUser(long idUser);
}

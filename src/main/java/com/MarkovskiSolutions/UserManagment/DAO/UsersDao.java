package com.MarkovskiSolutions.UserManagment.DAO;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MarkovskiSolutions.UserManagment.Entity.User;

@Repository
public interface UsersDao extends JpaRepository<User, Long> {
	
	public Collection<User> findByFirstNameLikeOrLastNameLikeOrderByLastNameAsc(String firstName, String lastName);
	
	public Collection<User> findByFirstNameLikeOrLastNameLikeOrderByLastNameDesc(String firstName, String lastName);
	
	public Collection<User> findByFirstNameLikeOrLastNameLikeOrderByDateOfBirthAsc(String firstName, String lastName);
	
	public Collection<User> findByFirstNameLikeOrLastNameLikeOrderByDateOfBirthDesc(String firstName, String lastName);
	
	public Collection<User> findByFirstNameLikeOrLastNameLikeOrderByIdDesc(String firstName, String lastName);
	
}

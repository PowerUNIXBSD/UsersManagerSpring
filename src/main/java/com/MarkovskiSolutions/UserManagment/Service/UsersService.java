package com.MarkovskiSolutions.UserManagment.Service;

import java.util.Collection;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.annotation.Transactional;

import com.MarkovskiSolutions.UserManagment.DAO.UsersDao;
import com.MarkovskiSolutions.UserManagment.Entity.User;

import Exceptions.InputException;
import Exceptions.UserNotFoundException;

@Service
public class UsersService {

	@Autowired
	private UsersDao dao;

	public Collection<User> getAllUsers() {
		return dao.findAll();
	}

	public User getUserById(Long id) throws UserNotFoundException {
		if (!dao.exists(id))
			throw new UserNotFoundException();
		return dao.findOne(id);
	}

	public User addUser(User user) throws InputException {
		user.setId(null);
		try {
			return dao.save(user);
		} catch (ConstraintViolationException ex) {
			throw new InputException(ex);
		}
	}

	public User updateUser(User user, Long id) throws UserNotFoundException, InputException {
		if (!dao.exists(id))
			throw new UserNotFoundException();

		user.setId(id);
		try {
			return dao.saveAndFlush(user);
		} catch (ConstraintViolationException ex) {
			throw new InputException(ex);
		} 
	}

	public User deleteUserById(Long id) throws UserNotFoundException {
		if (!dao.exists(id))
			throw new UserNotFoundException();

		User user = dao.findOne(id);
		dao.delete(id);
		return user;
	}

	public Collection<User> searchUsers(String name, String sort, String type) {
		if (sort.equals("lastName")) {
			if (type.equals("desc")) {
				return dao.findByFirstNameLikeOrLastNameLikeOrderByLastNameDesc("%" + name + "%", "%" + name + "%");
			} else {
				return dao.findByFirstNameLikeOrLastNameLikeOrderByLastNameAsc("%" + name + "%", "%" + name + "%");
			}
		} else if (sort.equals("dateOfBirth")) {
			if (type.equals("desc")) {
				return dao.findByFirstNameLikeOrLastNameLikeOrderByDateOfBirthDesc("%" + name + "%", "%" + name + "%");
			} else {
				return dao.findByFirstNameLikeOrLastNameLikeOrderByDateOfBirthAsc("%" + name + "%", "%" + name + "%");
			}
		}

		return dao.findByFirstNameLikeOrLastNameLikeOrderByIdDesc("%" + name + "%", "%" + name + "%");
	}

}

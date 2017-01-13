package com.MarkovskiSolutions.UserManagment.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MarkovskiSolutions.UserManagment.Entity.User;
import com.MarkovskiSolutions.UserManagment.Service.UsersService;

import Exceptions.InputException;
import Exceptions.UserNotFoundException;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

	@Autowired
	private UsersService service;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<User> index() {
		return service.getAllUsers();
	}

	@RequestMapping(value = "/search")
	public Collection<User> search(@RequestParam(value = "name", defaultValue = "", required = false) String name,
			@RequestParam(value = "sort", defaultValue = "", required = false) String sort,
			@RequestParam(value = "type", defaultValue = "", required = false) String type) {
		return service.searchUsers(name, sort, type);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable Long id) throws UserNotFoundException {
		return service.getUserById(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User user) throws InputException {
		return service.addUser(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User editUser(@RequestBody User user, @PathVariable Long id) throws UserNotFoundException, InputException {
		return service.updateUser(user, id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public User deleteUserById(@PathVariable Long id) throws UserNotFoundException {
		return service.deleteUserById(id);
	}
}

package com.HomeHubV1.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.HomeHubV1.entities.Home;
import com.HomeHubV1.entities.Room;
import com.HomeHubV1.entities.User;
import com.HomeHubV1.services.HomeServices;
import com.HomeHubV1.services.RoomServices;
import com.HomeHubV1.services.UserServices;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


class UserServicesTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void addUserTest() {
		UserServices us = new UserServices();

		User user = new User("firstName","lastName","username","password", "emial" );
		
		int expected = 1;
		
		//2 When : execute : get actual
		
		int actual = us.addUser(user);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void getUserByIdTest() {
		UserServices us = new UserServices();
		User user = new User("firstName","lastName","username","password", "emial"  ); 
		User expected = user;
		
		//2 When : execute : get actual
		
		User actual = us.getUserById(5);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void getUserByUsernameTest() {
		UserServices us = new UserServices();
		User user = us.getUserById(1);
		User expected = user;
		
		//2 When : execute : get actual
		
		User actual = us.getUserByUsername(user.getUsername());
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void updateUserTest() {
		UserServices us = new UserServices();
		User user = new User("firstName","lastName","username","password", "emial"  );
		us.addUser(user);
		int expected = 1;
		
		//2 When : execute : get actual
		
		int actual = us.updateUser(user);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void validateUserTest() {
		UserServices us = new UserServices();
		boolean expected = true;
		boolean actual = us.validateUser("aadre44", "123");
		assertEquals(expected, actual);
		
	}
	@Test
	void addHomeToUserTest() {
		UserServices us = new UserServices();
		User user = us.getUserById(5) ;
		Home home = new Home();
		
		int expected = 1;
		
		
		//2 When : execute : get actual
		
		int actual = us.addHomeToUser(5, home);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void addHomeToUserTest2() {
		UserServices us = new UserServices();
		User user = us.getUserById(1) ;
		Home home = new Home();
		HomeServices hs = new HomeServices();
		home = hs.getHomeById(201);
		int expected = 1;
		
		
		//2 When : execute : get actual
		
		int actual = us.addHomeToUser(1, home);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void removeHomeFromUser() {
		UserServices us = new UserServices();
		User user = us.getUserById(1) ;
		Home home = new Home();
		HomeServices hs = new HomeServices();
		home = hs.getHomeById(201);
		int expected = 1;
		
		
		//2 When : execute : get actual
		
		int actual = us.removeHomeFromUser(1, home);
		
		//3 Then : assert
		assertEquals(expected, actual);
	};
	@Test
	void deleteUser() {
		UserServices hs = new UserServices();
		User expected = hs.getUserById(1001);
		User user = new User( "firstName","lastName","username","password", "emial" ); 
		hs.addUser(user);
		
		
		//2 When : execute : get actual
		
		User actual = hs.deleteUser(1001);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	

}

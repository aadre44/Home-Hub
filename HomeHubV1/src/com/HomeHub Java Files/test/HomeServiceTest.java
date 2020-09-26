package com.HomeHubV1.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.HomeHubV1.entities.Home;
import com.HomeHubV1.entities.Room;
import com.HomeHubV1.services.HomeServices;
import com.HomeHubV1.services.RoomServices;

class HomeServiceTest {
	
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
	void addTest() {
		HomeServices hs = new HomeServices();

		Home home = new Home( "123 address", "Edison", "08817", "state", "home");
		
		int expected = 1;
		
		//2 When : execute : get actual
		
		int actual = hs.addHome(home);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void updateTest() {
		HomeServices hs = new HomeServices();
		Home home = new Home( "123 address", "Edison", "08817", "state", "home");
		hs.addHome(home);
		int expected = 1;
		
		//2 When : execute : get actual
		
		int actual = hs.updateHome(home);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}

	void deleteTest() {
		HomeServices hs = new HomeServices();
		Home expected = hs.getHomeById(1001);
		Home home = new Home( "123 address", "Edison", "08817", "state", "home"); 
		hs.addHome(home);
		
		
		//2 When : execute : get actual
		
		Home actual = hs.deleteHome(1001);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void getByIdTest() {
		HomeServices hs = new HomeServices();
		Home home = new Home( 5, "123 address", "Edison", "08817", "state", "home"); 
		Home expected = home;
		
		//2 When : execute : get actual
		
		Home actual = hs.getHomeById(5);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void addRoomToHomeTest() {
		HomeServices hs = new HomeServices();
		Home home = hs.getHomeById(5) ;
		Room room = new Room("room215");
		
		int expected = 1;
		
		
		//2 When : execute : get actual
		
		int actual = hs.addRoomToHome(5, room);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void removeRoomFromHomeTest() {
		HomeServices hs = new HomeServices();
		Home home = hs.getHomeById(151) ;
		Room room = new Room("room215");
		RoomServices rs = new RoomServices();
		room = rs.getRoomById(201);
		int expected = 1;
		
		
		//2 When : execute : get actual
		
		int actual = hs.removeRoomFromHome(151, room);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	
}

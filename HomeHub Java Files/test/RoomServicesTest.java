package com.HomeHubV1.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.HomeHubV1.entities.Device;
import com.HomeHubV1.entities.Home;
import com.HomeHubV1.entities.Room;
import com.HomeHubV1.services.DeviceServices;
import com.HomeHubV1.services.HomeServices;
import com.HomeHubV1.services.RoomServices;

class RoomServicesTest {

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
		RoomServices rs = new RoomServices();

		Room room = new Room("room name");
		
		int expected = 1;
		
		//2 When : execute : get actual
		
		int actual = rs.addRoom(room);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void updateTest() {
		RoomServices rs = new RoomServices();
		Room room = new Room( "room name");
		rs.addRoom(room);
		int expected = 1;
		
		//2 When : execute : get actual
		room.setHomeId(12);
		int actual = rs.updateRoom(room);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}

	void deleteTest() {
		RoomServices rs = new RoomServices();
		Room expected = rs.getRoomById(1001);
		
		
		//2 When : execute : get actual
		
		Room actual = rs.deleteRoom(1001);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void getByIdTest() {
		RoomServices rs = new RoomServices();
		Room room = new Room( "room name"); 
		Room expected = room;
		
		//2 When : execute : get actual
		
		Room actual = rs.getRoomById(5);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void addDeviceToRoomTest() {
		RoomServices rs = new RoomServices();
		Room room = rs.getRoomById(5) ;
		Device device = new Device();
		
		int expected = 1;
		
		
		//2 When : execute : get actual
		
		int actual = rs.addDeviceToRoom(5, device);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void removeDeviceFromRoomTest() {
		RoomServices rs = new RoomServices();
		Room room = rs.getRoomById(151) ;
		Device device = new Device();
		DeviceServices ds = new DeviceServices();
		device = ds.getDeviceById(201);
		int expected = 1;
		
		
		//2 When : execute : get actual
		
		int actual = rs.removeDeviceFromRoom(151, device);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void getRoomByNameTest(String name, int homeId) {
		RoomServices rs = new RoomServices();
		Room room = new Room( "room name"); 
		Room expected = room;
		
		//2 When : execute : get actual
		
		Room actual = rs.getRoomByName("room name", 5);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	

}

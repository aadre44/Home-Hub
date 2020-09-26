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

class DeviceServicesTest {

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
		DeviceServices ds = new DeviceServices();

		Device device = new Device( );
		
		int expected = 1;
		
		//2 When : execute : get actual
		
		int actual = ds.addDevice(device);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void updateTest() {
		DeviceServices ds = new DeviceServices();
		Device device = new Device( );
		ds.addDevice(device);
		int expected = 1;
		
		//2 When : execute : get actual
		
		int actual = ds.updateDevice(device);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}

	void deleteTest() {
		DeviceServices ds = new DeviceServices();
		Device expected = ds.getDeviceById(1001);
		Device device = new Device(); 
		ds.addDevice(device);
		
		
		//2 When : execute : get actual
		
		Device actual = ds.deleteDevice(1001);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void getByIdTest() {
		DeviceServices ds = new DeviceServices();
		Device device = new Device(); 
		Device expected = device;
		
		//2 When : execute : get actual
		
		Device actual = ds.getDeviceById(5);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void addRoomToDeviceTest() {
		DeviceServices ds = new DeviceServices();
		Device device = ds.getDeviceById(5) ;
		
		int expected = 1;
		
		
		//2 When : execute : get actual
		
		int actual = ds.addDeviceToRoom(5,device);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}

}

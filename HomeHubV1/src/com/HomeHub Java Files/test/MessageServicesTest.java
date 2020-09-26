package com.HomeHubV1.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.HomeHubV1.entities.Home;
import com.HomeHubV1.entities.Message;
import com.HomeHubV1.services.HomeServices;
import com.HomeHubV1.services.MessageServices;

class MessageServicesTest {

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
	void getMessageByIdTest() {
		MessageServices ms = new MessageServices();
		Message message = new Message( ); 
		Message expected = message;
		
		//2 When : execute : get actual
		
		Message actual = ms.getMessageById(5);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void getMessageByEmailTest() {
		MessageServices ms = new MessageServices();
		Message message = new Message(); 
		Message expected = message;
		
		//2 When : execute : get actual
		
		Message actual = ms.getMessageById(5);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void sendMessageTest() {
		MessageServices ms = new MessageServices();

		Message message = new Message( "123 address", "Edison", "08817", "state", "message");
		
		int expected = 1;
		
		//2 When : execute : get actual
		
		int actual = ms.sendMessage(message);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}
	@Test
	void deleteMessageByIdTest() {
		MessageServices ms = new MessageServices();
		Message expected = ms.getMessageById(1001);
		Message message = new Message( ); 
		ms.sendMessage(message);
		
		
		//2 When : execute : get actual
		
		Message actual = ms.deleteMessageById(1001);
		
		//3 Then : assert
		assertEquals(expected, actual);
	}

}

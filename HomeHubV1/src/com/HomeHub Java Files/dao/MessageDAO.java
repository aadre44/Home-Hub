package com.HomeHubV1.dao;

import java.util.List;

import com.HomeHubV1.entities.Message;



public interface MessageDAO {

	public Message getMessageById(int id);
	public List<Message> getMessageByEmail(String email);
	public int sendMessage(Message message);
	public Message deleteMessageById(int id);
}

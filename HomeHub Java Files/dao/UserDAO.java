package com.HomeHubV1.dao;

import com.HomeHubV1.entities.Home;
import com.HomeHubV1.entities.User;

public interface UserDAO {

	public int addUser(User user);
	public User getUserById(int id);
	public User getUserByUsername(String username);
	public int updateUser(User user);
	public boolean validateUser(String username, String password);
	public int addHomeToUser(int userId, Home home);
	public int addHomeToUser(int userId, int homeId);
	public int removeHomeFromUser(int userId, Home home);
	public User deleteUser(int id);
}

package com.HomeHubV1.dao;

import com.HomeHubV1.entities.Home;
import com.HomeHubV1.entities.Room;

public interface HomeDAO {
	public int updateHome(Home home);
	public int addHome(Home home);
	public 	Home deleteHome(int homeId);
	public Home getHomeById(int id);
	public int addRoomToHome(int homeId, Room room);
	public int removeRoomFromHome(int homeId, Room room);
}

package com.HomeHubV1.dao;

import com.HomeHubV1.entities.Device;
import com.HomeHubV1.entities.Room;

public interface RoomDAO {
	public int updateRoom( Room room);
	public int addRoom(Room room);
	public Room deleteRoom(int id);
	public Room getRoomById(int roomId);
	public int addDeviceToRoom(int roomId, Device device);
	public int removeDeviceFromRoom(int roomId, Device device);
	public Room getRoomByName(String name, int homeId);
}

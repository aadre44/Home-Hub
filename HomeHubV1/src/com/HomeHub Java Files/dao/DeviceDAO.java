package com.HomeHubV1.dao;

import com.HomeHubV1.entities.Device;
import com.HomeHubV1.entities.LightDevice;

public interface DeviceDAO {
	public int addDevice(Device device);
	public int updateDevice( Device device);
	public 	Device deleteDevice(int deviceId);
	public Device getDeviceById(int deviceId);
	public int addDeviceToRoom(int roomId, Device device);
}

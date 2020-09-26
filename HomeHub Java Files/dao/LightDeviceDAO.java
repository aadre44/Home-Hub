package com.HomeHubV1.dao;

import com.HomeHubV1.dao.DeviceDAO;
import com.HomeHubV1.entities.Device;
import com.HomeHubV1.entities.LightDevice;
import com.HomeHubV1.entities.LightDevice.State;

public interface LightDeviceDAO extends DeviceDAO {

	public int addLightDevice(LightDevice device);
	public int updateDevice( LightDevice device);
	public 	LightDevice deleteDevice(int deviceId);
	public LightDevice getDeviceById(int deviceId);
	public int addDeviceToRoom(int roomId, LightDevice device);
}

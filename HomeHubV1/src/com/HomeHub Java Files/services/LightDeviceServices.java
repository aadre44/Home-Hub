package com.HomeHubV1.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.HomeHubV1.dao.LightDeviceDAO;
import com.HomeHubV1.entities.Device;
import com.HomeHubV1.entities.Home;
import com.HomeHubV1.entities.LightDevice;
import com.HomeHubV1.entities.LightDevice.State;
import com.HomeHubV1.entities.Room;

public class LightDeviceServices extends DeviceServices implements LightDeviceDAO {
	final static String persistenceUnitName = "HomeHubV1";

	public static void main(String[] args) {
		
		LightDevice device = new LightDevice();
		device.setModel("my model");
		device.setName("new light");
		device.setType("Light");
		device.setRoom(301);
		LightDeviceServices ds = new LightDeviceServices();
		ds.addDeviceToRoom(301, device);
		/*
		LightDevice device = new LightDevice();
		device.setModel("my model");
		device.setName("new light");
		device.setType("Light");
		device.setRoom(301);
		LightDeviceServices ds = new LightDeviceServices();
		ds.addDevice(device);*/
	}
	
	
	
	public int addLightDevice(LightDevice device) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(device);
			em.getTransaction().commit();
		} catch(Exception e) {
			System.out.println("error adding light device");
		} 
		finally {
			em.close();
			emf.close();
		}
		return 0;
	}
	@Override
	public int updateDevice(LightDevice device) {
		DeviceServices ds = new DeviceServices();
		int num = ds.updateDevice((Device) device);
		return num;
	}

	@Override
	public LightDevice deleteDevice(int deviceId) {
		DeviceServices ds = new DeviceServices();
		LightDevice device =(LightDevice) ds.deleteDevice(deviceId);
		return device;
	}

	@Override
	public LightDevice getDeviceById(int deviceId) {
		DeviceServices ds = new DeviceServices();
		LightDevice device =(LightDevice) ds.getDeviceById(deviceId);
		return device;
	}

	@Override
	public int addDeviceToRoom(int roomId, LightDevice device) {
		Room room = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		
		try {
			if(em == null) System.out.println("em does not exist");
		room = em.find(Room.class, roomId);
			if(room == null) {
				System.out.println("room does not exist");
			//	throw new Exception();
			}
			if(device == null) System.out.println("device is null");
			else System.out.println("device is not null");
			/*
			em.getTransaction().begin();
			room.addDevice(device);
			em.getTransaction().commit();
			*/
			RoomServices rs = new RoomServices();
			rs.addDeviceToRoom(room.getId(), (Device) device) ;
			rs.updateRoom(room);
			return 1;
		} catch(Exception e) {
			System.out.println("error adding device to room");
		} 
		finally {
			em.close();
			emf.close();
		}
		return 0;
	}

}

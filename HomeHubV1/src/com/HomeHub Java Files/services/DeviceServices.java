package com.HomeHubV1.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.HomeHubV1.dao.DeviceDAO;
import com.HomeHubV1.entities.Device;
import com.HomeHubV1.entities.Home;
import com.HomeHubV1.entities.LightDevice;
import com.HomeHubV1.entities.Room;

public class DeviceServices implements DeviceDAO {
	final static String persistenceUnitName = "HomeHubV1";
	public static void main(String[] args) {
		
		DeviceServices ds = new DeviceServices();
		Device device = new Device("name", "modelDeafaultsdf", 1151, "Default");
		ds.addDeviceToRoom(1151, device);
		RoomServices rs = new RoomServices();
		Room room = rs.getRoomById(1151);
		System.out.println(room);

	}
	
	
	
	public int addDevice(Device device) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(device);
			em.getTransaction().commit();
		} catch(Exception e) {
			System.out.println("error updating home");
			return 0;
		} 
		finally {
			em.close();
			emf.close();
		}
		return 1;
	}

	@Override
	public int updateDevice(Device newDevice) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		
		try {
			Device device = em.find(Device.class, newDevice.getId());
			em.getTransaction().begin();
			device.setModel(newDevice.getModel());
			device.setName(newDevice.getName());
			device.setType(newDevice.getType());
			device.setRoom(newDevice.getRoom());
			em.getTransaction().commit();
		} catch(Exception e) {
			System.out.println("error updating device");
			return 0;
		} 
		finally {
			em.close();
			emf.close();
		}
		return 1;
	}
	@Override
	public int addDeviceToRoom(int roomId, Device device) {
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
			em.getTransaction().begin();
			room.addDevice(device);
			em.getTransaction().commit();
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

	@Override
	public Device deleteDevice(int deviceId) {
		Device device = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			device = em.find(Device.class, deviceId);
			if(device != null) {
				em.remove(device);
			}
			else System.out.println("error finding Device. Did not delete");
			em.getTransaction().commit();
		} catch(Exception e) {
			System.out.println("error deleting Device");
		} finally {
			em.close();
			emf.close();
		}
		return device;
	}

	@Override
	public Device getDeviceById(int deviceId) {
		Device device = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			device = em.find(Device.class, deviceId);
			if(device != null) {
				System.out.println("found");
			}
			else System.out.println("error finding Device. Did not delete");
		} catch(Exception e) {
			System.out.println("error deleting Device");
		} finally {
			em.close();
			emf.close();
		}
		return device;
	
	}
	
	
}

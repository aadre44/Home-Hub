package com.HomeHubV1.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.HomeHubV1.dao.RoomDAO;
import com.HomeHubV1.entities.Device;
import com.HomeHubV1.entities.Home;
import com.HomeHubV1.entities.Room;
import com.HomeHubV1.entities.User;

public class RoomServices implements RoomDAO {

	final static String persistenceUnitName = "HomeHubV1";
	public static void main(String[] args) {
		RoomServices rs = new RoomServices();
		Room room = rs.getRoomByName("NH", 751);
		System.out.println(room);
	}
	
	
	
	@Override
	public int updateRoom(Room newRoom) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		Room room = em.find(Room.class, newRoom.getId());
		if(room == null) {
			System.out.println("room no there");
			return 0;
		}
			em.getTransaction().begin();
			room.setName(newRoom.getName());
			room.setDevices(newRoom.getDevices());
			em.getTransaction().commit();
			
			System.out.println(" updating Room");
		try {
			
		} catch(Exception e) {
			System.out.println("error updating Room");
			return 0;
		} 
		finally {
			em.close();
			emf.close();
		}
		return 1;
	}

	@Override
	public Room deleteRoom(int id) {
		Room room = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			room = em.find(Room.class, id);
			if(room != null) {
				em.remove(room);
			}
			else System.out.println("error finding Room. Did not delete");
			em.getTransaction().commit();
		} catch(Exception e) {
			System.out.println("error deleting Room");
		} finally {
			em.close();
			emf.close();
		}
		return room;
	}

	@Override
	public Room getRoomById(int id) {
		Room room = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			room = em.find(Room.class, id);
			if(room == null) System.out.println("home does not exist");
			em.getTransaction().commit();
		} catch(Exception e) {
			System.out.println("error getting all students");
		} 
		finally {
			em.close();
			emf.close();
		}
		return room;
	}

	@Override
	public int addDeviceToRoom(int roomId, Device device) {
		if(device == null ) return 0;
		Room room = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		
		try {
			room = em.find(Room.class, roomId);
			if(room == null) {
				System.out.println("room does not exist");
			}
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
	public int removeDeviceFromRoom(int roomId, Device device) {
		if(device == null ) return 0;
		Room room = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			room = em.find(Room.class, roomId);
			if(room == null) {
				System.out.println("user does not exist");
				throw new Exception();
			}
			em.getTransaction().begin();
			room.removeDevice(device);
			em.getTransaction().commit();
			return 1;
		} catch(Exception e) {
			System.out.println("error getting user");
		} 
		finally {
			em.close();
			emf.close();
		}
		return 0;
	}

	@Override
	public int addRoom(Room newRoom) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		Room room = null;
		try {
			em.getTransaction().begin();
			em.persist(newRoom);
			em.getTransaction().commit();
			return 1;
		} catch(Exception e) {
			System.out.println("error updating home");
		} 
		finally {
			em.close();
			emf.close();
		}
		return 0;
	}



	@Override
	public Room getRoomByName(String name, int homeId) {
		Room room = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		
		try {
			Query query = em.createQuery("SELECT r FROM Room r WHERE r.name = :givenName AND r.homeId = :givenHomeId");
			query.setParameter("givenName", name);
			query.setParameter("givenHomeId", homeId);
			List result = query.getResultList();
			
			if(result.isEmpty()) return room;
			else room = (Room) result.get(0);
		} catch(Exception e) {
			System.out.println("error getting user by username");
		} 
		finally {
			em.close();
			emf.close();
		}
		return room;
	}

}


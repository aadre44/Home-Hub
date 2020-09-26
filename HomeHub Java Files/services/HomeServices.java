package com.HomeHubV1.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.HomeHubV1.dao.HomeDAO;
import com.HomeHubV1.entities.Home;
import com.HomeHubV1.entities.Room;
import com.HomeHubV1.entities.User;


public class HomeServices implements HomeDAO {

	final static String persistenceUnitName = "HomeHubV1";
	
	
	public static void main(String[] args) {
		
		HomeServices service = new HomeServices();
		Home home = service.getHomeById(1);
		Room room = new Room(home.getId(), "bedroom");
		service.addRoomToHome(1, room);

	}
	
	
	@Override
	public int updateHome(Home newHome) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		
		try {
			Home home = em.find(Home.class, newHome.getId());
			em.getTransaction().begin();
			home.setAddress(newHome.getAddress());
			home.setCity(home.getCity());
			home.setName(newHome.getName());
			home.setState(newHome.getState());
			home.setZipcode(newHome.getZipcode());
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
	public Home deleteHome(int id) {
		Home home = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			home = em.find(Home.class, id);
			if(home != null) {
				em.remove(home);
			}
			else System.out.println("error finding home. Did not delete");
			em.getTransaction().commit();
		} catch(Exception e) {
			System.out.println("error deleting home");
		} finally {
			em.close();
			emf.close();
		}
		return home;
	}

	@Override
	public Home getHomeById(int id) {
		Home home = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			home = em.find(Home.class, id);
			if(home == null) System.out.println("home does not exist");
			else System.out.println("home Found id: "+id);
		} catch(Exception e) {
			System.out.println("error getting all students");
		} 
		finally {
			em.close();
			emf.close();
		}
		return home;
	}


	@Override
	public int addHome(Home newHome) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(newHome);
			em.getTransaction().commit();
			System.out.println("success added home");
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
	public int addRoomToHome(int homeId, Room room) {
		if(room == null ) return 0;
		Home home = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		
		try {
			home = em.find(Home.class, homeId);
			if(home == null) {
				System.out.println("home does not exist");
			//	throw new Exception();
			}
			else System.out.println("home is here");
			em.getTransaction().begin();
			home.addRoom(room);
			em.getTransaction().commit();
			return 1;
		} catch(Exception e) {
			System.out.println("error adding room to home");
		} 
		finally {
			em.close();
			emf.close();
		}
		return 0;
	}


	@Override
	public int removeRoomFromHome(int homeId, Room room) {
		if(room == null ) return 0;
		Home home = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			home = em.find(Home.class, homeId);
			if(home == null) {
				System.out.println("user does not exist");
				throw new Exception();
			}
			em.getTransaction().begin();
			home.removeRoom(room);
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
	
}

package com.HomeHubV1.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.HomeHubV1.dao.UserDAO;
import com.HomeHubV1.entities.Home;
import com.HomeHubV1.entities.User;

public class UserServices implements UserDAO{

	final static String persistenceUnitName = "HomeHubV1";
	public static void main(String[] args) {

	}
	@Override
	public User getUserById(int id) {
		User user = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			user = em.find(User.class, id);
			if(user == null) System.out.println("user does not exist");
			em.getTransaction().commit();
		} catch(Exception e) {
			System.out.println("error getting user");
		} 
		finally {
			em.close();
			emf.close();
		}
		return user;
	}

	@Override
	public int updateUser(User newUser) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		
		try {
			User user = em.find(User.class, newUser.getId());
			em.getTransaction().begin();
			user.setFirstName(newUser.getFirstName());
			user.setLastName(newUser.getLastName());
			user.setUsername(newUser.getUsername());
			user.setPassword(newUser.getPassword());
			user.setEmail(newUser.getEmail());
			user.setHomeId(newUser.getHomeId());
			user.setHomes(newUser.getHomes());
			if(newUser.getHomes() != null) {
				user.setHomes(newUser.getHomes());
			}
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
	public User deleteUser(int id) {
		User user = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			user = em.find(User.class, id);
			if(user != null) {
				em.remove(user);
			}
			else System.out.println("error finding user. Did not delete");
			em.getTransaction().commit();
		} catch(Exception e) {
			System.out.println("error deleting user");
		} finally {
			em.close();
			emf.close();
		}
		return user;
	}

	@Override
	public boolean validateUser(String username, String password) {
		List result = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		
		
		try {
			Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :givenUser AND u.password = :givenPassword");
			query.setParameter("givenUser", username);
			query.setParameter("givenPassword", password);
			result = query.getResultList();
			if(result.isEmpty()) System.out.println("found nothing");
			else return true;
			if(result.isEmpty()) return false;
			else return true;
		} catch(Exception e) {
			System.out.println("error validating user");
		} 
		finally {
			em.close();
			emf.close();
		}
		return false;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		
		try {
			
			Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :givenUsername");
			query.setParameter("givenUsername", username);
			List result = query.getResultList();
			if(result.isEmpty()) return user;
			else user = (User) result.get(0);
		} catch(Exception e) {
			System.out.println("error getting user by username");
		} 
		finally {
			em.close();
			emf.close();
		}
		return user;
	}
	
	
	@Override
	public int addHomeToUser(int userId, Home home) {
		if(home == null ) return 0;
		User user = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		
		try {
			user = em.find(User.class, userId);
			if(user == null) {
				System.out.println("user does not exist");
			}
			em.getTransaction().begin();
			user.addHome(home);
			em.getTransaction().commit();
			User same = em.find(User.class, user.getId());
			System.out.println("success adding home to user "+user);
			System.out.println("success adding home to user "+same);
			return 1;
		} catch(Exception e) {
			System.out.println("error adding home to user");
		} 
		finally {
			em.close();
			emf.close();
		}
		return 0;
	}
	@Override
	public int addHomeToUser(int userId, int homeId) {
		User user = null;
		Home home = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			user = em.find(User.class, userId);
			home = em.find(Home.class, homeId);
			if(user == null) {
				System.out.println("user does not exist");
				throw new Exception();
			}
			em.getTransaction().begin();
			user.addHome(home);
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
	public int removeHomeFromUser(int userId, Home home) {
		if(home == null ) return 0;
		User user = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			user = em.find(User.class, userId);
			if(user == null) {
				System.out.println("user does not exist");
				throw new Exception();
			}
			em.getTransaction().begin();
			user.removeHome(home.getName());
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
	public int addUser(User user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return 1;
		} catch(Exception e) {
			System.out.println("error creating user");
		} 
		finally {
			em.close();
			emf.close();
		}
		return 0;
	}

}

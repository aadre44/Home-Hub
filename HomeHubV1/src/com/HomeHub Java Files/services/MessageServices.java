package com.HomeHubV1.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.HomeHubV1.dao.MessageDAO;
import com.HomeHubV1.entities.Home;
import com.HomeHubV1.entities.Message;

public class MessageServices implements MessageDAO{

	final static String persistenceUnitName = "HomeHubV1";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Message getMessageById(int id) {
		Message message = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			message = em.find(Message.class, id);
			if(message == null) System.out.println("message does not exist");
			em.getTransaction().commit();
		} catch(Exception e) {
			System.out.println("error getting message");
		} 
		finally {
			em.close();
			emf.close();
		}
		return message;
	}

	@Override
	public List<Message> getMessageByEmail(String email) {
		List<Message> messages = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("SELECT m FROM Messages m WHERE m.email = :givenEmail");
			query.setParameter(":givenEmail", email);
			messages = query.getResultList();
		} catch(Exception e) {
			System.out.println("error getting all emails");
		} 
		finally {
			em.close();
			emf.close();
		}
		return messages;
	}

	@Override
	public int sendMessage(Message message) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(message);
			em.getTransaction().commit();
			System.out.println("success sent message");
		} catch(Exception e) {
			System.out.println("error sending message");
			return 0;
		} 
		finally {
			em.close();
			emf.close();
		}
		return 1;
	}

	@Override
	public Message deleteMessageById(int id) {
		Message message = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			message = em.find(Message.class, id);
			if(message != null) {
				em.remove(message);
			}
			else System.out.println("error finding message. Did not delete");
			em.getTransaction().commit();
		} catch(Exception e) {
			System.out.println("error deleting message");
		} finally {
			em.close();
			emf.close();
		}
		return message;
	}

}

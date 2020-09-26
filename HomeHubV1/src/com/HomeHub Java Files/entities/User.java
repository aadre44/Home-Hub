package com.HomeHubV1.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.HomeHubV1.entities.Home;

@Entity
@Table(name = "Users")
public class User {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int id;
	@Column(name = "firstName", length = 15, nullable = false)
	String firstName;
	@Column(name = "lastName", length = 15, nullable = false)
	String lastName;
	@Column(name = "username", length = 15, nullable = false)
	private String username;
	@Column(name = "password", length = 50, nullable = false)
	String password;
	@Column(name = "email", length = 50, nullable = false)
	String email;
	@Column(name = "homeId")
	int homeId = 0;
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)  
	List<Home> homes = new ArrayList<Home>();
	
	public int getHome() {
		return homeId;
	}
	public void setHome(int homeId) {
		this.homeId = homeId;
	}
	public User(int id, String firstName, String lastName, String username, String password, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.homes = new ArrayList<Home>();
	}
	public User( String firstName, String lastName, String username, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.homes = new ArrayList<Home>();
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", homes=" + homes + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int userId) {
		this.id = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Home> getHomes() {
		return homes;
	}
	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}
	public void addHome(Home newHome) {
		if(this.homes == null) {
			this.homes = new ArrayList<Home>();
		}
		for(Home home: homes) {
			if(home.name.equals( newHome.name)) {
				System.out.println("Cannot have the same name house");
				return;
			}
		}
		if(newHome != null) {
			this.homes.add(newHome);
			if(this.homeId == 0) {
				this.homeId = newHome.getId();
			}
			
		}
	}
	public Home removeHome(String name) {
		if(this.homes == null) {
			this.homes = new ArrayList<Home>();
			System.out.println("sorry cant remove, no homes to remove");
			return null;
		}
		if(name != null) {
			Home home = this.getHomeByName(name);
			if(home != null) {
				this.homes.remove(home);
				if(this.homeId == home.getId()) {
					this.homeId = 0;
				}
				if(this.getHomeId() == 0 && this.getHomes().isEmpty() == false) {
					List<Home> homes = this.getHomes();
					this.setHomeId(homes.get(0).getId());
				}
				System.out.println("found home and removed");
			}
			else System.out.println("sorry cant remove, home is null");
			return home;
		}
		System.out.println("sorry cant remove,name is null");
		return null;
	}
	public Home getHomeById(int id) {
		for(Home home: this.homes) {
			if(home.id == id) return home;
		}
		return null;
	}
	public Home getHomeByName(String name) {
		
		for(Home home: this.homes) {
			System.out.println("homes: "+home.name);
			if(home.name.equals(name)) return home;
		}
		System.out.println("sorry cant home not found");
		return null;
	}
	public Home getSelectedHome() {
		try {
			for(Home home: homes) {
				if(home.getId() == this.getHomeId()) {
					return home;
				}
			}throw new NoHomeFound( " Home not found");
		}
		catch( NoHomeFound e ){
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	public int getHomeId() {
		if(homeId == 0 && homes.size() > 0) {
			homeId = homes.get(0).getId();
		}
		return homeId;
	}
	public void setHomeId(int homeId) {
		this.homeId = homeId;
	}
	public int resetHomeId() {
		int currentId = homeId;
		for(Home home: homes) {
			if(home.getId()== currentId) {
				return 1;
			}
		}
		System.out.println("HomeId is "+homeId);
		if(getSelectedHome() == null) {
			System.out.println("reset checking home, home is not in homes list");
			if(homes.isEmpty() == false) {
				System.out.println("Homelist is full will set homeid to one on the list");
				List<Home> homes = this.getHomes();
				this.setHomeId(homes.get(0).getId());
				return 1;
			}
			else {
				System.out.println("Homelist is empty will set homeid to 0");
				homeId = 0;
				return 0;
			}
		}
		else return 1;
		//id is not in the list
	}
	public class NoHomeFound extends Exception { 
	    public NoHomeFound(String errorMessage) {
	        super(errorMessage);
	    }
	}
	
	
}

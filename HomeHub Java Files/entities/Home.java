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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.HomeHubV1.entities.Device;
import com.HomeHubV1.entities.Room;

@Entity
@Table(name = "Homes")
public class Home {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int id;
	@Column(name = "address", length = 50, nullable = false)
	String address;
	@Column(name = "city", length = 50)
	String city;
	@Column(name = "state", length = 50)
	String state;
	@Column(name = "zipcode", length = 5, nullable = false)
	String zipcode;
	@Column(name = "name", length = 15, nullable = false)
	String name;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)  
	List<Room> rooms; 

	
	public Home(int id, String address, String city, String zipcode, String state, String name) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
		this.name = name;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public Home() {
		super();
	}
	public Home( String address, String city, String zipcode, String state, String name){
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
		this.name = name;

	}
	// getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addRoom(Room newRoom) {
		if(this.rooms == null) this.rooms = new ArrayList<Room>();
		for(Room room: this.rooms) {
			if(room.name.contentEquals(newRoom.name)) {
				System.out.println("Can not have the same name house");
				return;
			}
		}
		if(newRoom != null) {
			this.rooms.add(newRoom);
		}
		else System.out.println("ROOOM IS NULL CANT ADD ROOM");
	}
	public void removeRoom(Room room) {
		if(this.rooms == null) {
			this.rooms = new ArrayList<Room>();
			return;
		}
		if(room != null) {
			this.rooms.remove(room);
		}
	}
	public List<Device> getAllDevices()
	{
		List<Device> deviceList = new ArrayList<Device>();
		for(Room room: rooms) {
			deviceList.addAll(room.getDevices());
		}
		return deviceList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rooms == null) ? 0 : rooms.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Home other = (Home) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rooms == null) {
			if (other.rooms != null)
				return false;
		} else if (!rooms.equals(other.rooms))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Home [id=" + id + ", address=" + address + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + ", name=" + name + ", rooms=" + rooms + "]";
	}
	
}

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.HomeHubV1.entities.Device;
import com.HomeHubV1.entities.Home;


@Entity
@Table(name = "Rooms")
public class Room {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name = "home")
	int homeId;
	@Column(name = "name", length = 15, nullable = false)
	String name;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)  
	List<Device> devices;

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHomeId() {
		return homeId;
	}
	public void setHomeId(int homeId) {
		this.homeId = homeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Device> getDevices() {
		return devices;
	}
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Room(  String name) {
		super();
		this.name = name;
		this.devices = new ArrayList<Device>();
	}
	public Room( int homeId, String name) {
		super();
		this.homeId = homeId;
		this.name = name;
		this.devices = new ArrayList<Device>();
	}
	public Room( int homeId, String name, List<Device> devices) {
		super();
		this.homeId = homeId;
		this.name = name;
		this.devices = devices;
	}
	
	public void addDevice(Device newDevice) {
		if(this.devices == null) this.devices = new ArrayList<Device>();
		for(Device device: this.devices) {
			if(device.name == newDevice.name) {
				System.out.println("Can not have the same named device");
				return;
			}
		}
		if(newDevice != null) {
			this.devices.add(newDevice);
			System.out.println("added device");
		}
	}
	public void removeDevice(Device device) {
		if(this.devices == null) {
			this.devices = new ArrayList<Device>();
			return;
		}
		if(device != null) {
			this.devices.remove(device);
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((devices == null) ? 0 : devices.hashCode());
		result = prime * result + homeId;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Room other = (Room) obj;
		if (devices == null) {
			if (other.devices != null)
				return false;
		} else if (!devices.equals(other.devices))
			return false;
		if (homeId != other.homeId)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", homeId=" + homeId + ", name=" + name + ", devices=" + devices + "]";
	}
	
	
}

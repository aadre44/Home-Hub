package com.HomeHubV1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.HomeHubV1.entities.Room;
import com.HomeHubV1.entities.LightDevice.Color;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Devices")
public class Device {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int id;
	@Column(name = "model", length = 50)
	String model;
	@Column(name = "serial", length = 50)
	String serial;
	@Column(name = "name", length = 50, nullable = false)
	String name;
	@Column(name = "type", length = 50)
	String type = "Default";
	@Column(name = "room")
	int roomId;
//	@Column(name = "state")
//	State state = new State();
	
	public class State{
		boolean active;
		
		public State(){
			super();
			this.active = false;
			
		}
	}
	

	public Device(int id, String model, String name, int room) {
		super();
		this.id = id;
		this.model = model;
		this.name = name;
		this.roomId = room;
	}
	public Device( String name, int room) {
		super();
		this.name = name;
		this.roomId = room;
	}
	public Device(String model, String name, int room) {
		super();

		this.model = model;
		this.name = name;
		this.roomId = room;
	}
	public Device(String model, String serial, String name, int room) {
		super();
		this.serial = serial;
		this.model = model;
		this.name = name;
		this.roomId = room;
	}
	public Device(String model, String name, int room, String type) {
		super();
		this.type = type;
		this.model = model;
		this.name = name;
		this.roomId = room;
	}
	public Device() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getRoom() {
		return roomId;
	}
	public void setRoom(int room) {
		this.roomId = room;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + roomId;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Device other = (Device) obj;
		if (id != other.id)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (roomId != other.roomId)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Device [id=" + id + ", model=" + model + ", name=" + name + ", type=" + type + ", roomId=" + roomId
				+ "]";
	}
	
		
	
}

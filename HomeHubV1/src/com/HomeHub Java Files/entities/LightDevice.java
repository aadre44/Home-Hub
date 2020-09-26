package com.HomeHubV1.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.HomeHubV1.entities.LightDevice;
import com.HomeHubV1.entities.LightDevice.Color;
import com.HomeHubV1.entities.LightDevice.State;


public class LightDevice extends Device{
	@Column(name = "state")
	State state;
	@Column(name = "colors")
	List<Color> savedColors;
	
	public class State{
		boolean active = false;
		Color color = new Color();
		int brightness = 50;
		public State(){
			super();			
		}
	}
	public class Color{
		int red;
		int green;
		int blue;
	}
	
	public LightDevice( String model, String name, int room) {
		super( model, name, room);
		// TODO Auto-generated constructor stub
	}

	public LightDevice(String name, int room) {
		super(name, room);
		// TODO Auto-generated constructor stub
	}

	public LightDevice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public List<Color> getSavedColors() {
		return savedColors;
	}
	public void setSavedColors(List<Color> savedColors) {
		this.savedColors = savedColors;
	}
	
	public static void main(String[] args) {
		LightDevice l1 = new LightDevice();
	}
}

package com.HomeHubV1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.HomeHubV1.entities.Device;
import com.HomeHubV1.entities.Home;
import com.HomeHubV1.entities.LightDevice;
import com.HomeHubV1.entities.Message;
import com.HomeHubV1.entities.Room;
import com.HomeHubV1.entities.User;
import com.HomeHubV1.services.DeviceServices;
import com.HomeHubV1.services.HomeServices;
import com.HomeHubV1.services.LightDeviceServices;
import com.HomeHubV1.services.MessageServices;
import com.HomeHubV1.services.RoomServices;
import com.HomeHubV1.services.UserServices;

@Controller
public class MainController {
	//@RequestMapping(value = {"/", "/home"})
	@RequestMapping("/index")
	public String indexHandler(HttpServletRequest request) {
		return "index";
	}
	@RequestMapping(value = {"/", "/home"})
	public ModelAndView homeHandler(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
	@RequestMapping(value =  "/login")
	public ModelAndView loginHandler() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	@RequestMapping(value =  "/contactUs")
	public ModelAndView contactUsHandler() {
		ModelAndView mav = new ModelAndView("contactUs");
		return mav;
	}
	@RequestMapping(value = "/faq")
	public ModelAndView faqHandler() {
		ModelAndView mav = new ModelAndView("faq");
		return mav;
	}
	@RequestMapping(value =  "/dash", method = RequestMethod.GET)
	public ModelAndView dashHandler(HttpServletRequest request ) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("dash");
		User user = (User) session.getAttribute("user");
		System.out.println("first check: \n"+user);
		if(user == null) {
			/*
			UserServices service = new UserServices();
			user = service.getUserById(151);
			session.setAttribute("user", user);
			
			HomeServices homeServices = new HomeServices();
			Home home = homeServices.getHomeById(user.getHomeId());
			session.setAttribute("home", home);
			System.out.println(user);*/
			mav = new ModelAndView("login");
			return mav;
		}
		user.resetHomeId();
		System.out.println("dash user homeId is set to: "+user.getHomeId());
		Home home = user.getSelectedHome();
		System.out.println("dash home is set to: "+home);
		if(home != null) {
			System.out.println("dash home rooms is set to: "+home.getRooms());
		}
		
		session.setAttribute("home", home);
		System.out.println("2nd set: "+user);
		return mav;
	}
	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public ModelAndView settingsHandler(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("settings");
		User user = (User) session.getAttribute("user");
		if(user == null) {
			/*
			UserServices service = new UserServices();
			user = service.getUserById(151);
			session.setAttribute("user", user);
			System.out.println(user);
			*/
			mav = new ModelAndView("login");
			return mav;
		}
		System.out.println("SETTINGS: USER "+user);
		Home home = user.getSelectedHome();
		List<Device> deviceList = new ArrayList<Device>();
		if(home == null) home = new Home();
		else deviceList = home.getAllDevices();
		System.out.println("setting set: "+user);
		mav.addObject("user", user);
		mav.addObject("home", home);
		mav.addObject("deviceList", deviceList);
		session.setAttribute("home", home);
		session.setAttribute("deviceList", deviceList);

		return mav;
	}

	@RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
	public ModelAndView validateLoginHandler(HttpServletRequest request , @RequestParam("username") String username, @RequestParam("password") String password ) {
		ModelAndView mav = new ModelAndView("/login");;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(username == null || password == null) {
			 String message = "Password and User cannot Be null";
			 mav.addObject("message", message);
			 return mav;
		}
		UserServices userServices = new UserServices();
		if(userServices.validateUser(username, password)) {
			mav = new ModelAndView("dash");
			user = userServices.getUserByUsername(username);
			List<Home> homes = user.getHomes();
			System.out.println("initial homes: \n"+user);
			System.out.println("initial set: \n"+user);
			user = userServices.getUserById(user.getId());
			System.out.println("initial set2: \n"+user);
			session.setAttribute("user", user);
			mav.addObject("user", user);
		}
		else {
			String message = "Password and User do not match";
			System.out.println(message);
			 mav.addObject("message", message);
		}
		return mav;
	}
	
	@RequestMapping(value = "/validateSignUp", method = RequestMethod.POST)
	public ModelAndView validateSignUpHandler(HttpServletRequest request , @RequestParam("username") String username, @RequestParam("username") String firstName, @RequestParam("username") String lastName,@RequestParam("password") String password, @RequestParam("password") String email) {
		ModelAndView mav = new ModelAndView("login");;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if(username == null || password == null || firstName == null || lastName == null || email == null) {
			System.out.println("Password and User cannot Be null");
			 String message = "Password and User cannot Be null";
			 mav.addObject("message", message);
			 return mav;
		}
		UserServices userServices = new UserServices();
		User newUser = new User(firstName, lastName, username, password, email);
		int tryPersist = userServices.addUser(newUser);
		if(tryPersist == 1) {
			System.out.println("Successfully signed up! Login!");
			String message = "Successfully signed up! Login!";
			System.out.println(message);
			 mav.addObject("message", message);
		}
		else {
			System.out.println("Sorry sign in failed! Try again");
			String message = "Sorry sign in failed! Try again";
			System.out.println(message);
			 mav.addObject("message", message);
		}
		return mav;
	}
	
	@RequestMapping(value = "/addHome", method = RequestMethod.POST)
	public ModelAndView addHomeHandler(HttpServletRequest request , @RequestParam( "address" )String address, @RequestParam( "city" )String city, 
		@RequestParam( "zipcode" )String zipcode, @RequestParam( "state" ) String state, @RequestParam( "name" )String name) {
		ModelAndView mav = new ModelAndView("settings");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			mav = new ModelAndView("login");
			return mav;
		}
		Home newHome = new Home(address, city, zipcode, state, name);

		user = (User) session.getAttribute("user");
		UserServices userServices = new UserServices();
		userServices.addHomeToUser(user.getId(), newHome);
//		userServices.updateUser(user);
		System.out.println("Setting after add home user "+ user);
		user = userServices.getUserById(user.getId());
		session.setAttribute("user", user);
		
		return mav;
	}
	
	@RequestMapping(value = "/removeHome", method = RequestMethod.POST)
	public ModelAndView removeHomeHandler(HttpServletRequest request ,  @RequestParam( "name" )String name) {
		ModelAndView mav = new ModelAndView("settings");;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			mav = new ModelAndView("login");
			return mav;
		}
		HomeServices homeServices = new HomeServices();
		
		Home home = user.removeHome(name);
		if(home != null) {
			System.out.println("home is not null going to remove");
			homeServices.deleteHome(home.getId());
		}
		else System.out.println("home is  null");
		UserServices us = new UserServices();
		us.updateUser(user);
		return mav;
	}
	
	@RequestMapping(value = "/changeSettings", method = RequestMethod.POST)
	public ModelAndView removeHomeHandler(HttpServletRequest request , @RequestParam( "username" )String username, @RequestParam( "firstName" )String firstName, 
			@RequestParam( "lastName" )String lastName, @RequestParam( "email" ) String email, @RequestParam( "password" )String password, @RequestParam( "password2" )String password2) {
		ModelAndView mav = new ModelAndView("settings");;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			mav = new ModelAndView("login");
			return mav;
		}
		System.out.println("before changed user "+user);
		UserServices service = new UserServices();
		User changed = new User();
		changed.setId(user.getId());
		if(!username.equals("") && username != null) {
			changed.setUsername(username);
		}
		else changed.setUsername(user.getUsername());
		
		if(!firstName.contentEquals("") && firstName != null) {
			changed.setFirstName(firstName);
			
		}else changed.setFirstName(user.getFirstName());
		
		if(!lastName.contentEquals("") && lastName != null) {
			changed.setLastName(lastName);
		}
		else changed.setLastName(user.getLastName());
		
		if(!email.contentEquals("") && email != null) {
			changed.setEmail(email);
		}
		else changed.setEmail(user.getEmail());

		
		if((!password.contentEquals("") && password != null)&& (!password2.contentEquals("") && password2 != null)) {
			if(password.contentEquals(password2)) {
				//validate the password structure
				changed.setPassword(password);
			}
		}
		else changed.setPassword(user.getPassword());
		changed.setHomeId(user.getHomeId());
		changed.setHomes(user.getHomes());
		System.out.println("changed user "+changed);
		service.updateUser(changed);
		session.setAttribute("user", changed);
		mav.addObject("user", changed);
		
		return mav;
	}
	
	@RequestMapping(value = "/addDevice", method = RequestMethod.POST)
	public ModelAndView addDevice(HttpServletRequest request , @RequestParam("name") String name, @RequestParam("model") String model, @RequestParam("type") String type,  @RequestParam("room") String roomName, @RequestParam("homeId") int homeId) {
		ModelAndView mav = new ModelAndView("dash");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			mav = new ModelAndView("login");
			return mav;
		}
		//get room
		RoomServices roomServices = new RoomServices();
		Room room = roomServices.getRoomByName(roomName, homeId);
		if(room == null) {
			System.out.println("room is null");
			return mav;
		}
			
		//validate info entered
		//create new device
		
		if(type.equals("default")) {
			DeviceServices deviceServices = new DeviceServices();
			Device device = new Device(model, name, room.getId());
			if(roomServices.addDeviceToRoom(room.getId(), device) == 1) {
				String message= "Successfully added device";
				mav.addObject("message", message);
			}else {
				String message = "Device not added";
				mav.addObject("message", message);
			}
			//add Device to room
		}
		else if(type.contentEquals("Light")) {
			LightDeviceServices deviceServices = new LightDeviceServices();
			LightDevice device = new LightDevice(model, name, room.getId());
			if(roomServices.addDeviceToRoom(room.getId(),(Device) device) == 1) {
				String message= "Successfully added device";
				mav.addObject("message", message);
			}else {
				String message = "Device not added";
				mav.addObject("message", message);
			}
			//add Device to room
		}
		
		//return to updated dash with success message or error message
		//set updated user to session attribute
		UserServices userServices = new UserServices();
		user = userServices.getUserById(((User) session.getAttribute("user")).getId());
		session.setAttribute("user", user);
		return mav;
	}
	@RequestMapping(value = "/deleteDevice", method = RequestMethod.POST)
	public ModelAndView deleteDevice(HttpServletRequest request , @RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView("dash");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			mav = new ModelAndView("login");
			return mav;
		}
		//create new device
		DeviceServices ds = new DeviceServices();
		if(ds.deleteDevice(id) != null) {
			String message= "Successfully added device";
			mav.addObject("message", message);
		}else {
			String message = "Device not added";
			mav.addObject("message", message);
		}
		
		//return to updated dash with success message or error message
		//set updated user to session attribute
		UserServices userServices = new UserServices();
		user = userServices.getUserById(((User) session.getAttribute("user")).getId());
		session.setAttribute("user", user);
		return mav;
	}
	@RequestMapping(value = "/addRoom", method = RequestMethod.POST)
	public ModelAndView addRoomHandler(HttpServletRequest request , @RequestParam("name") String name) {
		
		ModelAndView mav = new ModelAndView("dash");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			mav = new ModelAndView("login");
			return mav;
		}
		//get user
		user = (User) session.getAttribute("user");
		//get Home
		HomeServices homeService = new HomeServices();
		Home home = homeService.getHomeById(user.getHomeId());
		//validate info entered
		//create new Room
		RoomServices roomServices = new RoomServices();
		Room room = new Room(home.getId(), name);

		//return to updated dash with success message or error message
		if(homeService.addRoomToHome(room.getHomeId(), room) == 1) {//roomServices.addRoom(room) == 1) {
			String message= "Successfully added Room";
			mav.addObject("message", message);
		}else {
			String message = "Room not added";
			mav.addObject("message", message);
		}
		//addRoomTo Home

		//set updated user to session attribute
		UserServices userServices = new UserServices();
		session = request.getSession();
		user = userServices.getUserById(((User) session.getAttribute("user")).getId());
		session.setAttribute("user", user);
		return mav;
	}
	@RequestMapping(value = "/updateDeviceStatus", method = RequestMethod.POST)
	public ModelAndView updateDeviceStatusHandler(HttpServletRequest request, @RequestParam("deviceId")  int deviceId) {
		ModelAndView mav = new ModelAndView("dash");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			mav = new ModelAndView("login");
			return mav;
		}
		//get device id
		//get device type
		//update device
		
		DeviceServices deviceServices = new DeviceServices();
		Device device = deviceServices.getDeviceById(deviceId);
		deviceServices.updateDevice(device);
		
		
		return mav;
		
	}
	@RequestMapping(value="/sendMessage", method = RequestMethod.POST)
	public ModelAndView sendMessageHandler(HttpServletRequest request,  @RequestParam("firstName")  String firstName, @RequestParam("lastName")  String lastName, @RequestParam("message")  String message, @RequestParam("email")  String email, @RequestParam("phone")  String phone) {
		ModelAndView mav = new ModelAndView("contactUs");
		Message newMessage = new Message(firstName, lastName, phone, email, message);
		MessageServices ms = new MessageServices();
		if(ms.sendMessage(newMessage) == 1) {
			String text =" Message sent";
			System.out.println(text);
			mav.addObject("message", text);
		}
		else {
			String text =" Message failed to send";
			System.out.println(text);
			mav.addObject("message", text);
		}
		return mav;
	}
	@RequestMapping(value="/setHome", method = RequestMethod.POST)
	public ModelAndView setHomeHandler(HttpServletRequest request,  @RequestParam("setHomeId")  int id) {
		ModelAndView mav = new ModelAndView("settings");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			mav = new ModelAndView("login");
			return mav;
		}
		user.setHomeId(id);
		user.resetHomeId();
		System.out.println("selected home: "+user.getHomeId());
		session.setAttribute("user", user);
		return mav;
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logoutHandler(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("home");
		HttpSession session = request.getSession();
		User user = null;
		System.out.println("logging out user: "+user);
		session.setAttribute("user", user);
		session.invalidate();
		return mav;
	}
}

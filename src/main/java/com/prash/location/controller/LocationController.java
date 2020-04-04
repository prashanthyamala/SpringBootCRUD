package com.prash.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prash.location.entities.Location;
import com.prash.location.service.LocationService;
import com.prash.location.util.EmailUtil;

@Controller
public class LocationController {
	@Autowired
	private LocationService service;
	@Autowired
	EmailUtil email;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
		
	}
	@RequestMapping("/saveLoc")
	public String saveLOcation(@ModelAttribute("location") Location location,ModelMap Modelmap ) {
		Location saveLocation = service.saveLocation(location);
		String msg = "Location saved with id: " +saveLocation.getId();
		Modelmap.addAttribute("msg",msg);
		email.sendEmail("pracoderhere@gmail.com", "First message", "hey you got the message buddy");
		return "createLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id,ModelMap modelMap) {
		//Location location = service.getLocationById(id);
		Location location = new Location();
		location.setId(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";
	}
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id,ModelMap modelMap) {
		Location location = service.getLocationById(id);
		modelMap.addAttribute("location",location);	
		return "updateLocation";
	}
	
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location,ModelMap Modelmap) {
		service.updateLocation(location);
		List<Location> locations = service.getAllLocation();		
		Modelmap.addAttribute("locations",locations);	
		return "displayLocations";	
	}

}

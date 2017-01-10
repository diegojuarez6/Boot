package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Harvest;
import boot.service.HarvestService;



@Controller
public class HarvestController {
	
	@Autowired
	private HarvestService harvestService;
	
	@GetMapping("/harvests")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "harvests";
	}
	
	@GetMapping("/all-harvests")
	public String allHarvests(HttpServletRequest request) {
		request.setAttribute("harvests", harvestService.findAll());
		request.setAttribute("mode", "MODE_HARVESTS");
		return "harvests";
	}
	
	@GetMapping("/new-harvest")
	public String newHarvest(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "harvests";
	}

	
	@PostMapping("/save-harvest")
	public String saveHarvest(@ModelAttribute Harvest harvest, 
			BindingResult bindingResult, HttpServletRequest request) {
		harvestService.save(harvest);
		request.setAttribute("harvests", harvestService.findAll());
		request.setAttribute("mode", "MODE_HARVESTS");		
		return "harvests";
	}
	
	@GetMapping("/update-harvest")
	public String updateHarvest(@RequestParam int id, HttpServletRequest request) {
	request.setAttribute("harvest", harvestService.finOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "harvests";
	}	
	
	
	@GetMapping("/delete-harvest")
	public String deleteHarvest(@RequestParam int id, HttpServletRequest request) {
		harvestService.delete(id);
	request.setAttribute("harvests",harvestService.findAll());
		request.setAttribute("mode", "MODE_HARVESTS");
		return "harvests";
	}
}

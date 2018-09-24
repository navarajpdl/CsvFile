package com.navaraj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.navaraj.model.ProjectData;
import com.navaraj.services.MyProjectService;

@RestController
@RequestMapping("/")

public class ProjectController {

	@Autowired
	MyProjectService myProjectService;

	 @GetMapping("/hello")
	 public String showMe() {
	 //return "Hello how are you";
	 return myProjectService.showMe();
	 }

	@GetMapping("/api/stats/all")
	public List<ProjectData> getAll() {

		return myProjectService.getAllProjectData();
	}

	@GetMapping("/api/stats")
	public ResponseEntity <List<ProjectData>> getTeam(@RequestParam("company") String company, @RequestParam("project") String project) {
		
		if(myProjectService.getAllTeams(project, company).size()>0) {
			return new ResponseEntity<List<ProjectData>>(myProjectService.getAllTeams(project, company), HttpStatus.OK);
//			return myProjectService.getAllTeams(project, company);
		}else {
			return new ResponseEntity<List<ProjectData>>(myProjectService.getAllTeams(project, company), HttpStatus.NOT_FOUND);
		}

		
	}

	@GetMapping("/api/stats/budget")
	public List<String> getBudget() {
		List<String> budgets = new ArrayList<String>();
		
		for(ProjectData data : myProjectService.getAllBudget()) {
			
			budgets.add(data.getBudget());
			
		}

		return budgets;
	}

}

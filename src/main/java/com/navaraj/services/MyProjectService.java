package com.navaraj.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navaraj.model.ProjectData;
import com.navaraj.repo.ProjectDataRepo;
@Service
public class MyProjectService {
	
	@Autowired
	ProjectDataRepo projectDataRepo;
	
	public List<ProjectData> getAllProjectData(){
		return projectDataRepo.getAllData();
	}
	
	
	public List<ProjectData> getAllTeams(String project, String company){
		return projectDataRepo.getAllTeam(project, company);
	}
	
	public List<ProjectData> getAllBudget(){
		return projectDataRepo.getAllBudget();
	}

	public String showMe() {
		 return "Hello how are you";
	}
}


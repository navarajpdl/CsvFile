package com.navaraj.repo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.navaraj.model.ProjectData;
import com.navaraj.utility.CsvReader;

@Component
public class ProjectDataRepo {
	
	CsvReader csv = new CsvReader();
	List<String[]> allData = csv.getAllDataASStringArray();
	
	public List<ProjectData> getAllData() {
		return getAsProjectDataList(allData);
	}

	// return which has teams working on "offshore drilling" project in "acme"
	// company.

	public List<ProjectData> getAllTeam(String project, String company) {
		

		List<String[]> teamData = new ArrayList<String[]>();
		// get data of Acme company
		// working on offshore drilling project ony
		for (String[] data : allData) {
			if (data[0].equals(company) && data[1].equals(project)) {
				teamData.add(data);
			}
		}

		return getAsProjectDataList(teamData);
	}

	// project info which are project = gred and team = development

	public List<ProjectData> getAllBudget() {

		List<String[]> BudgetData = new ArrayList<String[]>();

		// output Dev teams budget for project "GERD"

		for (String[] data : allData) {
			if (data[2].equals("GERD") && data[4].equals("Development")) {
				BudgetData.add(data);
			}
		}

		return getAsProjectDataList(BudgetData);
	}

	private List<ProjectData> getAsProjectDataList(List<String[]> list) {

		List<ProjectData> pd = new ArrayList<ProjectData>();

		for (String[] data : list) {
			
			if(! (data[0].equals("Company"))) {
				ProjectData prjData = new ProjectData();
				prjData.setCompany(data[0]);

				prjData.setProject(data[1]);
				prjData.setBudget(data[3]);
				prjData.setTeam(data[4]);

				pd.add(prjData);
				
			}
			
		}

		// remove projectCode row
		// no need to print projectcode
		//// remove

		Set<ProjectData> uniqueElements = new HashSet<ProjectData>(pd);

		pd.clear();

		pd.addAll(uniqueElements);

		return pd;

	}

}

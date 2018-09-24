package com.navaraj.scvSpring;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.navaraj.model.ProjectData;
import com.navaraj.services.MyProjectService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CsvSpringApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MyProjectService projectService;
	@Autowired
	List<ProjectData> mockProject;


	@Test
	public void testGetAllData() throws Exception {

	Mockito.when(
				projectService.getAllBudget()).thenReturn(mockProject);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/stats/all").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		
		assertEquals(projectService.getAllProjectData().size(), 11);
		
//		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	
	@Test
	public void testGetBudget() throws Exception {

		Mockito.when(
			projectService.getAllBudget()).thenReturn(mockProject);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/stats/budget").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		

		assertEquals(projectService.getAllBudget().size(), 1);
		
		
//		String expected = "{:12345$}";
//		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	
	@Test
	public void testGetTeam() throws Exception {


		Mockito.when(
			projectService.getAllTeams("project", "company")).thenReturn(mockProject);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/stats?company=Acme&project=Offshoredrilling").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		
		assertEquals(projectService.getAllTeams("Offshoredrilling", "Acme").size(), 3);


//		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	
	}
	
}


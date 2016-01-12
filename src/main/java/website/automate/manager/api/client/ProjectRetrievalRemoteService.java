package website.automate.manager.api.client;

import static java.util.Arrays.asList;

import java.util.List;

import website.automate.manager.api.client.model.Authentication;
import website.automate.manager.api.client.model.Project;
import website.automate.manager.api.client.model.Scenario;
import website.automate.manager.api.client.support.RestTemplate;

public class ProjectRetrievalRemoteService {

	private static final ProjectRetrievalRemoteService INSTANCE = new ProjectRetrievalRemoteService();
	
	public static ProjectRetrievalRemoteService getInstance(){
		return INSTANCE;
	}

	private ScenarioRetrievalRemoteService scenarioRetrievalRemoteService = ScenarioRetrievalRemoteService.getInstance();
	
	private RestTemplate restTemplate = RestTemplate.getInstance();
	
	public List<Project> getProjectsByPrincipal(Authentication principal) {
		return asList(restTemplate.performGet(Project [].class, 
				"/public/project/my?profile=BRIEF",
				principal));
	}
	
	public List<Project> getProjectsWithScenariosByPrincipal(Authentication principal){
		List<Project> projects = getProjectsByPrincipal(principal);
		
		for(Project project : projects){
			List<Scenario> scenarios = scenarioRetrievalRemoteService.getScenariosByProjectIdAndPrincipal(project.getId(), principal);
			project.setScenarios(scenarios);
		}
		
		return projects;
	}
	
}

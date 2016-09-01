package website.automate.manager.api.client;

import static java.util.Arrays.asList;

import java.util.List;

import website.automate.manager.api.client.model.Authentication;
import website.automate.manager.api.client.model.Scenario;
import website.automate.manager.api.client.support.RestTemplate;

public class ScenarioRetrievalRemoteService {

	private static final ScenarioRetrievalRemoteService INSTANCE = new ScenarioRetrievalRemoteService();
	
	public static ScenarioRetrievalRemoteService getInstance(){
		return INSTANCE;
	}
	
	private RestTemplate restTemplate = RestTemplate.getInstance();
	
	public List<Scenario> getExecutableScenariosByProjectIdAndPrincipal(String projectId, Authentication principal){
	    return asList(restTemplate.performGet(Scenario [].class, 
                "/public/project/" + projectId + "/scenario?profile=BRIEF&fragment=false", 
                principal));
	}
	
	public List<Scenario> getScenariosByProjectIdAndPrincipal(String projectId, Authentication principal) {
		return asList(restTemplate.performGet(Scenario [].class, 
				"/public/project/" + projectId + "/scenario?profile=BRIEF", 
				principal));
	}
	
	
}

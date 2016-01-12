package website.automate.manager.api.client;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import website.automate.manager.api.client.ProjectRetrievalRemoteService;
import website.automate.manager.api.client.model.Project;
import website.automate.manager.api.client.support.AuthenticationUtils;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ProjectRetrievalRemoteServiceIT extends MockServerIT {

	private ProjectRetrievalRemoteService retrievalRemoteService = ProjectRetrievalRemoteService.getInstance();
	
	@Test
	public void projectsShouldBeRetrievedByPrincipal() throws JsonProcessingException{
		List<Project> actualProjects = retrievalRemoteService.getProjectsByPrincipal(AuthenticationUtils.getIntegrationTestAccountPrincipal());
		
		assertNotNull(actualProjects);
		assertFalse(actualProjects.isEmpty());
		Project actualProject = actualProjects.get(0);
		assertEquals(getProject(), actualProject);
	}
}

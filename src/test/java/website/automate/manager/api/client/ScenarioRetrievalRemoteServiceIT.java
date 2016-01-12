package website.automate.manager.api.client;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import website.automate.manager.api.client.ScenarioRetrievalRemoteService;
import website.automate.manager.api.client.model.Authentication;
import website.automate.manager.api.client.model.Scenario;
import website.automate.manager.api.client.support.AuthenticationUtils;

public class ScenarioRetrievalRemoteServiceIT extends MockServerIT {

	private Authentication principal = AuthenticationUtils.getIntegrationTestAccountPrincipal();
	private ScenarioRetrievalRemoteService retrievalRemoteService = ScenarioRetrievalRemoteService.getInstance();
	
	@Test
	public void scenariosShouldBeRetrievedByPrincipal(){
		List<Scenario> acutalScenarios = retrievalRemoteService.getScenariosByProjectIdAndPrincipal(getProject().getId(), principal);
		
		assertNotNull(acutalScenarios);
		assertFalse(acutalScenarios.isEmpty());
		Scenario actualScenario = acutalScenarios.get(0);
		assertEquals(getScenario(), actualScenario);
	}
}

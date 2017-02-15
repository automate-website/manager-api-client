package website.automate.manager.api.client;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import website.automate.manager.api.client.model.Box;
import website.automate.manager.api.client.support.AuthenticationUtils;

import com.fasterxml.jackson.core.JsonProcessingException;

public class BoxRetrievalRemoteServiceIT extends MockServerIT {

	private BoxRetrievalRemoteService retrievalRemoteService = BoxRetrievalRemoteService.getInstance();
	
	@Test
	public void boxesShouldBeRetrievedByPrincipal() throws JsonProcessingException{
		List<Box> actualBoxes = retrievalRemoteService.getBoxesByPrincipal(AuthenticationUtils.getIntegrationTestAccountPrincipal());
		
		assertNotNull(actualBoxes);
		assertFalse(actualBoxes.isEmpty());
		Box actualBox = actualBoxes.get(0);
		assertEquals(getBox(), actualBox);
	}
}

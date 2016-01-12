package website.automate.manager.api.client;

import static java.util.Arrays.asList;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;

import website.automate.manager.api.client.JobManagementRemoteService;
import website.automate.manager.api.client.model.Authentication;
import website.automate.manager.api.client.model.Job;
import website.automate.manager.api.client.model.Job.JobProfile;
import website.automate.manager.api.client.support.AuthenticationUtils;

public class JobManagementRemoteServiceIT extends MockServerIT {

	private Authentication principal = AuthenticationUtils.getIntegrationTestAccountPrincipal();
	private JobManagementRemoteService jobManagementRemoteService = JobManagementRemoteService.getInstance();
	
	@Test
	public void jobsShouldBeCreatedAndRetrieved(){
		List<Job> actualCreatedJobs = jobManagementRemoteService.createJobs(asList(getRequestJob()), principal);
		assertContains(actualCreatedJobs, getJob());
		
		List<Job> retrievedJobs = jobManagementRemoteService.getJobsByIdsAndPrincipal(asList(getJob().getId()), principal, JobProfile.BRIEF);
		assertContains(retrievedJobs, getSuccessfulJob());
	}
	
	private void assertContains(List<Job> actualCreatedJobs, Job expectedJob){
	    assertNotNull(actualCreatedJobs);
        Job actualCreatedJob = actualCreatedJobs.get(0);
        assertEquals(getJob(), actualCreatedJob);
	}
}

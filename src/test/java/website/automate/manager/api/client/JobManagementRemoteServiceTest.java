package website.automate.manager.api.client;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import website.automate.manager.api.client.model.Authentication;
import website.automate.manager.api.client.model.Job;
import website.automate.manager.api.client.support.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class JobManagementRemoteServiceTest {

    @InjectMocks private JobManagementRemoteService service;
    
    @Mock private Collection<Job> jobs;
    @Mock private Authentication principal;
    @Mock private RestTemplate restTemplate;
    @Mock private Job createdJob;
    
    @Test
    public void jobsAreCreated(){
        when(restTemplate.performPost(Job [].class, "/public/job/batch", principal, jobs)).thenReturn(new Job [] {createdJob});
        Collection<Job> actualCreatedJobs = service.createJobs(jobs, principal);
        
        assertTrue(actualCreatedJobs.contains(createdJob));
    }
    
}

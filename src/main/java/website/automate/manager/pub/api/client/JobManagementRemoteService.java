package website.automate.manager.pub.api.client;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.List;

import website.automate.manager.pub.api.client.model.Authentication;
import website.automate.manager.pub.api.client.model.Job;
import website.automate.manager.pub.api.client.model.Job.JobProfile;
import website.automate.manager.pub.api.client.support.RestTemplate;

public class JobManagementRemoteService {

	private static final JobManagementRemoteService INSTANCE = new JobManagementRemoteService();
	
	public static JobManagementRemoteService getInstance(){
		return INSTANCE;
	}
	
	private RestTemplate restTemplate = RestTemplate.getInstance();
	
	public List<Job> getJobsByIdsAndPrincipal(Collection<String> jobIds, Authentication principal, JobProfile jobProfile) {
		return asList(restTemplate.performPost(Job [].class, 
				"/public/job/subset?profile=" + jobProfile,
				principal, jobIds));
	}
	
	public List<Job> createJobs(Collection<Job> jobs, Authentication principal){
	    return asList(restTemplate.performPost(Job [].class, "/public/job/batch", principal, jobs));
	}
	
}

package website.automate.manager.api.client;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static java.util.Collections.singleton;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;

import website.automate.manager.api.client.model.Box;
import website.automate.manager.api.client.model.Job;
import website.automate.manager.api.client.model.Project;
import website.automate.manager.api.client.model.Scenario;
import website.automate.manager.api.client.model.Job.JobStatus;
import website.automate.manager.api.client.model.Job.TakeScreenshots;
import website.automate.manager.api.client.support.Constants;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

public abstract class MockServerIT {

    private static final String 
        PROJECT_ID = "1654de39e7405a41c0920d52",
        SCENARIO_ID = "2654de39e7405a41c0920d52",
        JOB_ID = "3654de39e7405a41c0920d52",
        CONTEXT_KEY = "key",
        CONTEXT_VALUE = "value",
        RESOLUTION = "1280x768x24",
        BOX_ID = "3654de39e7405a41c0920d52",
        BROWSER = "Firefox 50.0",
        OS = "Windows 10";
    
    private static final Integer TEST_PORT = 9999;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(TEST_PORT);

	private Project project;
	
	private Scenario scenario;
	
	private Box box;
	
	private Job
	    requestJob,
	    successfulJob,
	    job;
	
	@BeforeClass
	public static void beforeClass(){
	    Constants.setBaseUrl("http://localhost:" + TEST_PORT);
	}
	
	@Before
	public void before() throws JsonProcessingException{
	    mapBoxEndpoint();  
	    mapProjectsEndpoint();
	    mapScenariosEndpoint();
	    mapJobsBatchEndpoint();
	    mapJobsSubsetEndpoint();
	    mapExecutableScenariosEndpoint();
	}
	
	private void mapBoxEndpoint() throws JsonProcessingException{
	  box = createTestBox();
	  
	  stubFor(get(urlPathEqualTo("/api/public/box"))
	      .willReturn(aResponse()
              .withStatus(200)
              .withHeader("Content-Type", "application/json")
              .withBody(objectMapper.writeValueAsString(new Box [] { box }))));
	}
	
	private void mapProjectsEndpoint() throws JsonProcessingException{
	    project = createTestProject();
	    
	    stubFor(get(urlPathEqualTo("/api/public/project/my?profile=BRIEF"))
                .willReturn(aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", "application/json")
                    .withBody(objectMapper.writeValueAsString(new Project [] { project }))));
	}
	
	private void mapScenariosEndpoint() throws JsonProcessingException {
        scenario = createTestScenario();
        
        stubFor(get(urlPathEqualTo("/api/public/project/" + project.getId() + "/scenario?profile=BRIEF"))
                .willReturn(aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", "application/json")
                    .withBody(objectMapper.writeValueAsString(new Scenario [] { scenario }))));
    }
	
	private void mapExecutableScenariosEndpoint() throws JsonProcessingException {
        scenario = createTestScenario();
        
        stubFor(get(urlPathEqualTo("/api/public/project/" + project.getId() + "/scenario?profile=BRIEF&fragment=false"))
                .willReturn(aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", "application/json")
                    .withBody(objectMapper.writeValueAsString(new Scenario [] { scenario }))));
    }
	
	private void mapJobsBatchEndpoint() throws JsonProcessingException {
	    requestJob = createTestJob();
	    job = createTestJob(JOB_ID, JobStatus.SCHEDULED);
        
        stubFor(post(urlPathEqualTo("/api/public/job/batch"))
                .withRequestBody(equalToJson(objectMapper.writeValueAsString(new Job [] { requestJob })))
                .willReturn(aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", "application/json")
                    .withBody(objectMapper.writeValueAsString(new Job [] { job }))));
    }
	
	private void mapJobsSubsetEndpoint() throws JsonProcessingException {
	    successfulJob = createTestJob(JOB_ID, JobStatus.SUCCESS);
	    
        stubFor(post(urlPathEqualTo("/api/public/job/subset"))
                .withRequestBody(equalToJson(objectMapper.writeValueAsString(new String [] { job.getId() })))
                .willReturn(aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", "application/json")
                    .withBody(objectMapper.writeValueAsString(new Job [] { successfulJob }))));
    }
	
	private Job createTestJob(){
	    return createTestJob(null, null);
	}
	
	private Job createTestJob(String id, JobStatus status){
	    Job job = new Job();
	    job.setTakeScreenshots(TakeScreenshots.ON_FAILURE);
	    job.setScenarioIds(singleton(SCENARIO_ID));
	    job.getContext().put(CONTEXT_KEY, CONTEXT_VALUE);
	    job.setTimeout(1.0);
	    job.setResolution(RESOLUTION);
	    job.setBoxId(BOX_ID);
	    if(status != null){
	        job.setStatus(status);
	    }
	    if(id != null){
	        job.setId(id);
	    }
	    return job;
	}
	
	private Scenario createTestScenario(){
	    Scenario scenario = new Scenario();
	    scenario.setName("My awesome scenario");
	    scenario.setId(SCENARIO_ID);
	    return scenario;
	}
	
	private Project createTestProject(){
	    Project project = new Project();
	    project.setTitle("My awesome project");
	    project.setId(PROJECT_ID);
	    return project;
	}
	
	private Box createTestBox(){
	  Box box = new Box();
	  box.setBrowser(BROWSER);
	  box.setOs(OS);
	  return box;
	}
	
	protected Job getRequestJob(){
	    return requestJob;
	}
	
	protected Job getJob(){
	    return job;
	}
	
    protected Project getProject() {
        return project;
    }
    
    protected Job getSuccessfulJob(){
        return successfulJob;
    }
    
    protected Scenario getScenario(){
        return scenario;
    }
    
    protected Box getBox(){
      return box;
    }
}

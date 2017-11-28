 package website.automate.manager.api.client.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Job extends AbstractEntity {

  public enum JobProfile {
		MINIMAL,
		BRIEF,
        COMPLETE;
    }

    public enum JobStatus {
        SCHEDULED,
        RUNNING,
        SUCCESS,
        FAILURE,
        ERROR
    }

    public enum TakeScreenshots {
    	NEVER,
    	ON_FAILURE,
    	ON_EVERY_STEP;
    }

    private String title;

    private String resolution;

    private String boxId;
    
    private JobStatus status;
    
    private Set<String> scenarioIds;
    
    private Report report;
    
    private TakeScreenshots takeScreenshots;
    
	private Map<String, String> context = new HashMap<String, String>();
	
	private Double timeout;
    	
	
    public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TakeScreenshots getTakeScreenshots() {
        return takeScreenshots;
    }

    public void setTakeScreenshots(TakeScreenshots takeScreenshots) {
        this.takeScreenshots = takeScreenshots;
    }
    
    public Set<String> getScenarioIds() {
        return scenarioIds;
    }

    public void setScenarioIds(Set<String> scenarioIds) {
        this.scenarioIds = scenarioIds;
    }
    
    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public Double getTimeout() {
      return timeout;
    }

    public void setTimeout(Double timeout) {
      this.timeout = timeout;
    }

    public Map<String, String> getContext() {
		return context;
	}

	public void setContext(Map<String, String> context) {
		this.context = context;
	}

    public String getResolution() {
      return resolution;
    }

    public void setResolution(String resolution) {
      this.resolution = resolution;
    }

    public String getBoxId() {
      return boxId;
    }

    public void setBoxId(String boxId) {
      this.boxId = boxId;
    }

	@Override
	public String toString() {
		return "Job [title=" + title + ", resolution=" + resolution + ", boxId=" + boxId + ", status=" + status
				+ ", scenarioIds=" + scenarioIds + ", report=" + report + ", takeScreenshots=" + takeScreenshots
				+ ", context=" + context + ", timeout=" + timeout + "]";
	}
    
    
}

package website.automate.manager.pub.api.client.model;

public class Job extends AbstractEntity {

    public enum JobProfile {
        BRIEF,
        COMPLETE;
    }
    
    public enum JobStatus {
        RUNNING,
        SCHEDULED,
        FAILED,
        SUCCESS;
    }
    
    public enum TakeScreenshots {
        ON_EVERY_STEP,
        ON_FAILURE,
        NEVER;
    }

    private String title;
    
    private JobStatus status;
    
    private String scenarioId;
    
    private TakeScreenshots takeScreenshots;
    
    private TestResults testResults;
    
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
    
    public String getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(String scenarioId) {
        this.scenarioId = scenarioId;
    }
    
    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }
    
    public TestResults getTestResults() {
        return testResults;
    }

    public void setTestResults(TestResults testResults) {
        this.testResults = testResults;
    }
}

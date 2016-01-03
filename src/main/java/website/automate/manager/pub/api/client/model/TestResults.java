package website.automate.manager.pub.api.client.model;

import java.util.List;

public class TestResults {

    private double totalTime;
    
    private boolean failed;
    
    private List<TestStep> steps;
    
    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

    public List<TestStep> getSteps() {
        return steps;
    }

    public void setSteps(List<TestStep> steps) {
        this.steps = steps;
    }
}

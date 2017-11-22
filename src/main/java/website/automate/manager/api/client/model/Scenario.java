package website.automate.manager.api.client.model;

import java.util.Set;

public class Scenario extends AbstractEntity {

    private String name;
    
    private boolean fragment;
    
    int numStepFailures;
    
    int numStepPasses;
    
    enum STATUS {
    	SUCCESS,
    	ERROR
    }
    
    private STATUS status;
    
    Set<Step> steps;
        
    
    public Set<Step> getSteps() {
		return steps;
	}

	public void setSteps(Set<Step> steps) {
		this.steps = steps;
	}

	public int getNumStepFailures() {
		return numStepFailures;
	}

	public void setNumStepFailures(int numStepFailures) {
		this.numStepFailures = numStepFailures;
	}

	public int getNumStepPasses() {
		return numStepPasses;
	}

	public void setNumStepPasses(int numStepPasses) {
		this.numStepPasses = numStepPasses;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFragment() {
        return fragment;
    }

    public void setFragment(boolean fragment) {
        this.fragment = fragment;
    }
}

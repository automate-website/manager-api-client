package website.automate.manager.api.client.model;

import java.util.ArrayList;
import java.util.List;

public class Project extends AbstractEntity {

	private String title;
    
    private List<Scenario> scenarios = new ArrayList<Scenario>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Scenario> getScenarios() {
		return scenarios;
	}

	public void setScenarios(List<Scenario> scenarios) {
		this.scenarios = scenarios;
	}
}

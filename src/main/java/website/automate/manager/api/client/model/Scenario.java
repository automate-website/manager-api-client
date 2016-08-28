package website.automate.manager.api.client.model;

public class Scenario extends AbstractEntity {

    private String name;
    
    private boolean fragment;
    
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

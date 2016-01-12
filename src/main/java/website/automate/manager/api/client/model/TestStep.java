package website.automate.manager.api.client.model;

public class TestStep {

    private int index;
    
    private boolean failed;
    
    private String command;
    
    private String parameters;

    private String value;
    
    private String errorMessage;
    
    private String screenshotId;
    
    private String thumbnailId;
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getScreenshotId() {
        return screenshotId;
    }

    public void setScreenshotId(String screenshotId) {
        this.screenshotId = screenshotId;
    }

    public String getThumbnailId() {
        return thumbnailId;
    }

    public void setThumbnailId(String thumbnailId) {
        this.thumbnailId = thumbnailId;
    }
}

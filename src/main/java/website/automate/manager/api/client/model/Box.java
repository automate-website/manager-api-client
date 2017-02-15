package website.automate.manager.api.client.model;


public class Box extends AbstractEntity {

  private String os;
  
  private String browser;

  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public String getBrowser() {
    return browser;
  }

  public void setBrowser(String browser) {
    this.browser = browser;
  }
}

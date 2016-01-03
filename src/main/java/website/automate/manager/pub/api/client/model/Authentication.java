package website.automate.manager.pub.api.client.model;

public class Authentication {

    private String username;
    
    private String password;

    private Authentication(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public static Authentication of(String username, String password){
    	return new Authentication(username, password);
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

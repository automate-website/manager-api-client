package website.automate.manager.api.client.model;

import java.util.Objects;

public class Authentication {

    private String username;

    private String password;

    private Authentication(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public static Authentication of(String username, String password) {
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

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Authentication other = (Authentication) obj;
        return Objects.equals(username, other.username) && Objects.equals(password, other.password);
    }
}

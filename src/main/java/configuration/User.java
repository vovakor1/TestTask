package configuration;

import lombok.Getter;
import org.json.simple.JSONObject;
import utils.JsonUtils;

@Getter
public class User {
    private final String company;
    private final String login;
    private final String password;

    public User() {
        JSONObject properties = JsonUtils.getJsonFromFile("/data/login.json");
        this.company = String.valueOf(properties.get("Company"));
        this.login = String.valueOf(properties.get("User"));
        this.password = String.valueOf(properties.get("Password"));
    }
}
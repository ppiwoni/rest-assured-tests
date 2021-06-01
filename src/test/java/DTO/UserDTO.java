package DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    public String login;
    public int id;
    public String url;
    public String type;
    public boolean site_admin;
    public String updated_at;


}

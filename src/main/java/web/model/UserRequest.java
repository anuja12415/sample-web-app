package web.model;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String id;

    public UserRequest(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public UserRequest(){

    }
}

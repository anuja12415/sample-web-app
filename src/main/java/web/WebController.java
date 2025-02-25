package web;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.model.UserRequest;

@RestController
@RequestMapping("/myapp")
public class WebController {

    @GetMapping("/health")
    public String health() {
        return "Greetings from Anuja!";
    }

    @GetMapping("/user")
    public User getUser(@RequestParam(name="id", defaultValue = "1", required = true) String userId,
                        @RequestParam(name="username", defaultValue = "Anuja", required = true)String userName){
        return new User(userId, userName);
    }


    @PostMapping("/user")
    public  User createUser(@RequestBody UserRequest userRequest){
        return new User(userRequest.getId(), userRequest.getName());
    }

}
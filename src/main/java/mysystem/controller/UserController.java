package mysystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import mysystem.controller.request.RegisterUserRequest;
import mysystem.domain.User;
import mysystem.repository.UserRepository;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    public void registerUser(RegisterUserRequest request){
        User user = new User();
        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());
        userRepository.save(user);
    }

    @GetMapping("/user")
    public List<User> getUser(){
        return userRepository.findAll();
    }
}
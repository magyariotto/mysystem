package mysystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import mysystem.controller.request.RegisterUserRequest;
import mysystem.domain.MsUser;
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
        MsUser msUser = new MsUser();
        msUser.setUserName(request.getUserName());
        msUser.setPassword(request.getPassword());
        userRepository.save(msUser);
    }

    @GetMapping("/user")
    public List<MsUser> getUser(){
        return userRepository.findAll();
    }
}
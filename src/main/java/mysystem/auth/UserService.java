package mysystem.auth;

import com.github.saphyra.authservice.domain.Credentials;
import com.github.saphyra.authservice.domain.User;
import lombok.RequiredArgsConstructor;
import mysystem.domain.MsUser;
import mysystem.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserService {
    private final  UserRepository userRepository;
    public Optional<User> findByUserId(String userId) {
        Optional<MsUser> msUser = userRepository.findById(Long.valueOf(userId));

        if(msUser.isPresent()){
            MsUser user = msUser.get();
            return convertUser(user);
        }else return Optional.empty();
    }

    private Optional<User> convertUser(MsUser user) {
        return Optional.of(
                User.builder()
                        .userId(String.valueOf(user.getId()))
                        .credentials(
                                Credentials.builder()
                                        .userName(user.getUserName())
                                        .password(user.getPassword())
                                        .build()
                        )
                        .roles(new HashSet<>())
        .build());
    }

    public Optional<User> findByUserName(String userName) {
        Optional<MsUser> msUser = userRepository.findByUserName(userName);

        if(msUser.isPresent()){
            MsUser user = msUser.get();
            return convertUser(user);
        }else return Optional.empty();
    }
}

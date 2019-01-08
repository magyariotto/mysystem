package destinychild.auth;

import com.github.saphyra.authservice.AuthDao;
import com.github.saphyra.authservice.domain.AccessToken;
import com.github.saphyra.authservice.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Transactional
public class AuthDaoImpl implements AuthDao {
    private final UserService userService;
    private final AccessTokenService accessTokenService;

    @Override
    public Optional<User> findUserById(String userId) {
        return userService.findByUserId(userId);
    }

    @Override
    public Optional<User> findUserByUserName(String userName) {
        return userService.findByUserName(userName);
    }

    @Override
    public void deleteAccessToken(AccessToken accessToken) {
        accessTokenService.delete(accessToken);
    }

    @Override
    public void deleteAccessTokenByUserId(String userId) {
        accessTokenService.deleteByUserId(userId);
    }

    @Override
    public void deleteExpiredAccessTokens(OffsetDateTime expiration) {
        accessTokenService.deleteExpired(expiration);
    }

    @Override
    public Optional<AccessToken> findAccessTokenByTokenId(String accessTokenId) {
        return accessTokenService.findByAccessTokenId(accessTokenId);
    }

    @Override
    public void saveAccessToken(AccessToken accessToken) {
        accessTokenService.save(accessToken);
    }
}

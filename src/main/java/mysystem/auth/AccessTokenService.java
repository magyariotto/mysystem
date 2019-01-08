package mysystem.service;

import com.github.saphyra.authservice.domain.AccessToken;
import lombok.RequiredArgsConstructor;
import mysystem.repository.AccessTokenRepository;
import mysystem.auth.MsAccessToken;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccessTokenService {
    private final AccessTokenRepository accessTokenRepository;

    public void save(AccessToken accessToken) {
        accessTokenRepository.save(convertAccessToken(accessToken));
    }

    private MsAccessToken convertAccessToken(AccessToken accessToken) {
        return MsAccessToken.builder()
                .accessTokenId(accessToken.getAccessTokenId())
                .userId(accessToken.getUserId())
                .persistent(accessToken.isPersistent())
                .lastAccess(accessToken.getLastAccess().toEpochSecond())
                .build();
    }

    private AccessToken convertAccessToken(MsAccessToken accessToken) {
        return AccessToken.builder()
                .accessTokenId(accessToken.getAccessTokenId())
                .userId(accessToken.getUserId())
                .isPersistent(accessToken.isPersistent())
                .lastAccess(OffsetDateTime.of(LocalDateTime.ofEpochSecond(accessToken.getLastAccess(), 0, ZoneOffset.UTC), ZoneOffset.UTC))
                .build();
    }

    public void delete(AccessToken accessToken) {
        accessTokenRepository.deleteById(accessToken.getAccessTokenId());
    }

    public void deleteByUserId(String userId) {
        accessTokenRepository.deleteByUserId(userId);
    }

    public void deleteExpired(OffsetDateTime expiration) {
        accessTokenRepository.deleteExpired(expiration.toEpochSecond());
    }

    public Optional<AccessToken> findByAccessTokenId(String accessTokenId) {
        Optional<MsAccessToken> accessToken = accessTokenRepository.findById(accessTokenId);

        if(accessToken.isPresent()){
            MsAccessToken msAccessToken = accessToken.get();
            return Optional.of(convertAccessToken(msAccessToken));
        }else return Optional.empty();
    }
}

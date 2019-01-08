package mysystem.repository;

import mysystem.auth.MsAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface AccessTokenRepository extends JpaRepository<MsAccessToken, String> {
    void deleteByUserId(String userId);

    @Transactional
    @Modifying
    @Query(value = "DELETE MsAccessToken a WHERE a.lastAccess < :expiration AND a.persistent=false")
    void deleteExpired(@Param("expiration") Long expiration);
}

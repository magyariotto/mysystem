package mysystem.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MsAccessToken {

    @Id
    private String accessTokenId;
    private String userId;
    private boolean persistent;
    private Long lastAccess;

}

package mysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mysystem.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
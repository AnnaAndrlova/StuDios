package rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
}

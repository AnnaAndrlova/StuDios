package rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.models.Project;
import rest.models.User;

public interface ProjectRepo extends JpaRepository<Project, Long> {
}

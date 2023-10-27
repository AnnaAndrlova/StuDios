package rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.models.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {
}

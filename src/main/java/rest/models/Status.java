package rest.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(schema = "study_app")
public class Status
{
    @Id
    @GeneratedValue
    private Long id;
    private String status;

    @OneToMany(mappedBy = "statusProject")
    @JsonManagedReference(value="statusProject")
    private Set<Project> projects;

    @OneToMany(mappedBy = "statusTask")
    @JsonManagedReference(value="statusTask")
    private Set<Task> tasks;
}

package rest.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @OneToMany(mappedBy = "status")
    private Set<Project> projects;
}

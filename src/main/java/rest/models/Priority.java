package rest.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


    @Entity
    @Getter
    @Setter
    @Table(schema = "study_app")
    public class Priority
    {
        @Id
        @GeneratedValue
        private Long id;
        private String priority;

        @OneToMany(mappedBy = "priority")
        @JsonManagedReference
        private Set<Task> tasks;
}

package rest.models;

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
        private String status;



        @OneToMany(mappedBy = "priority")
        private Set<Task> tasks;
}

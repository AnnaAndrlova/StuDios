package rest.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(schema = "study_app")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String category;
    @Column
    private String subject;
    @Column
    private String description;
    @Column
    private LocalDateTime deadline;

    @ManyToOne @JsonManagedReference
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne @JsonManagedReference
    @JoinColumn(name = "priority_id")
    private Priority priority;
}

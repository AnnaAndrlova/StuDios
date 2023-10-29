package rest.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference(value="statusTask")
    private Status statusTask;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    @JsonBackReference
    private Priority priority;

    @Column
    private long user_id;
}

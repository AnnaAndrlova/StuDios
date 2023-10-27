package rest.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(schema = "study_app")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String subject;
    @Column
    private LocalDateTime deadline;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @Column
    private String description;



}

package pl.coderslab.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 100)
    private String name;

    @NotBlank
    @Column(length = 160)
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;

    @Column
    private int priority;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updated;

    @ManyToOne
    private Project project;
}



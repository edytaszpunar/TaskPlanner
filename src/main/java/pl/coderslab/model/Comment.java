package pl.coderslab.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String comment;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;

    @ManyToOne
    private User user;

    @ManyToOne(cascade=CascadeType.REMOVE)
    private Task task;
}

package pl.coderslab.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 100)
    private String name;

    @NotBlank
    @Column
    private String description;

    @NotBlank
    @Column
    private String progressComment;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updated;

/*    @ManyToOne
    private User user;*/

}

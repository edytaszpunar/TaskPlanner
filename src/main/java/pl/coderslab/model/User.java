package pl.coderslab.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 100)
    private String firstName;

    @NotBlank
    @Column(length = 100)
    private String lastName;

    @NotBlank
    @Email
    @Column(length = 100)
    private String email;

    @NotBlank
    @Column(length = 100, unique = true)
    private String login;

    @NotBlank
    @Column
    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updated;
}

package pt.thatsbruno.LearningPlatform.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="userTbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;  // Can be 'STUDENT', 'INSTRUCTOR', 'ADMIN'

}

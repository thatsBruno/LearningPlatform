package pt.thatsbruno.LearningPlatform.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.thatsbruno.LearningPlatform.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by username
    Optional<User> findByUsername(String username);

    // Find a user by email
    Optional<User> findByEmail(String email);

    // Find all users with a specific role (e.g. STUDENT, INSTRUCTOR)
    List<User> findByRole(String role);
}
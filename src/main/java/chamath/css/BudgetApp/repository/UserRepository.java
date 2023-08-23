package chamath.css.BudgetApp.repository;

import chamath.css.BudgetApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}

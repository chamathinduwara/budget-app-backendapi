package chamath.css.BudgetApp.repository;

import chamath.css.BudgetApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}

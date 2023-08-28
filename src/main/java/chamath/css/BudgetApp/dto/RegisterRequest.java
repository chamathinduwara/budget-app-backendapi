package chamath.css.BudgetApp.dto;

import chamath.css.BudgetApp.model.Role;
import lombok.Data;

@Data
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}

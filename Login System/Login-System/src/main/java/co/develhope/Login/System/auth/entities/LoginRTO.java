package co.develhope.Login.System.auth.entities;

import co.develhope.Login.System.user.entities.User;
import lombok.Data;

@Data
public class LoginRTO {

    private User user;
    private String jwt;
}

package co.develhope.Login.System.auth.services;

import co.develhope.Login.System.auth.entities.LoginDTO;
import co.develhope.Login.System.auth.entities.LoginRTO;
import co.develhope.Login.System.user.entities.User;
import co.develhope.Login.System.user.repositories.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class LoginService {

    public static final String JWT_SECRET = "d10e0a96-45b5-4cfc-94a0-7c9464697184";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginRTO login(LoginDTO loginDTO) {
        if(loginDTO == null) return null;
        User userDB = userRepository.findByEmail(loginDTO.getEmail());
        if(userDB == null || !userDB.isActive()) return null;

        boolean canLogin = this.canUserLogin(userDB, loginDTO.getPassword());
        if(!canLogin) return null;

        String JWT = generateJWT(userDB);

        userDB.setPassword(null);
        LoginRTO out = new LoginRTO();
        out.setJwt(JWT);
        out.setUser(userDB);

        return out;
    }

    public boolean canUserLogin(User user, String password) {
        return passwordEncoder.matches(password, user.getPassword());
    }

    static Date convertToDateViaInstant(LocalDateTime dateToConcert) {
        return java.util.Date
                .from(dateToConcert.atZone(ZoneId.systemDefault())
                        .toInstant());
    }

    public static String getJWT(User user) {
        Date expiresAt = convertToDateViaInstant(LocalDateTime.now().plusDays(15));
        return JWT.create()
                .withIssuer("demo-login-system")
                .withIssuedAt(new Date())
                .withExpiresAt(expiresAt)
                .withClaim("id", user.getId())
                .sign(Algorithm.HMAC512(JWT_SECRET));
    }

    public String generateJWT(User user) {
        String JWT = getJWT(user);

        user.setJwtCreatedOn(LocalDateTime.now());
        userRepository.save(user);

        return JWT;
    }
}

package co.develhope.Login.System.auth.controllers;

import co.develhope.Login.System.auth.entities.LoginDTO;
import co.develhope.Login.System.auth.entities.LoginRTO;
import co.develhope.Login.System.auth.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public LoginRTO login(@RequestBody LoginDTO loginDTO) throws Exception {
        LoginRTO loginRTO = loginService.login(loginDTO);
        if(loginRTO == null) throw new Exception("Cannot login");
        return loginRTO;
    }
}

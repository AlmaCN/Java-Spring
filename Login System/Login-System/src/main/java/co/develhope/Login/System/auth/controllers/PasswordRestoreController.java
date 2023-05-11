package co.develhope.Login.System.auth.controllers;

import co.develhope.Login.System.auth.entities.RequestPasswordDTO;
import co.develhope.Login.System.auth.entities.RestorePasswordDTO;
import co.develhope.Login.System.auth.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/password")
public class PasswordRestoreController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping("/request")
    public void passwordRequest(@RequestBody RequestPasswordDTO requestPasswordDTO) {
        try {
            passwordService.request(requestPasswordDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/restore")
    public void passwordRestore(@RequestBody RestorePasswordDTO restorePasswordDTO) throws Exception {
        passwordService.restore(restorePasswordDTO);
    }
}

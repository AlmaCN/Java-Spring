package co.develhope.DeployEnvironments.Variables1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Nel application .yml ho creato un environment: dev a cui ho dato due myCustomVarTree: authCode e devName.
 * Ho poi creato HomeController per poter prendere le due customVar e stamparle quando qualcuno accede
 * localhost:4500
 */
@RestController
public class HomeController {

    @Autowired
    private Environment environment;

    @Value("${myCustomVarTree.authCode}")
    String authCode;

    @Value("${myCustomVarTree.devName}")
    String devName;

    @GetMapping
    public String getAuthCodeDevName(){
        return "Auth Code=" + authCode + " Dev Name=" + devName;
    }
}

package com.obligatorioPenca.obligatorioPenca.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
    @Autowired
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public Integer iniciarSesion (@RequestBody LoginDTO loginDTO){
        Integer idUsuario = loginService.iniciarsesion(loginDTO.email, loginDTO.contrasena);
        if(idUsuario==null)
            return null;
        return idUsuario;
    }
}

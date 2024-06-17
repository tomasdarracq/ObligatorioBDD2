package com.obligatorioPenca.obligatorioPenca.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Integer iniciarsesion(String email, String contrasena){
        Integer idUsuario = loginRepository.obtenerIdUsuario(email, contrasena);
        if ( idUsuario != null) {
            return  idUsuario;
        }
        return null;
    }
}

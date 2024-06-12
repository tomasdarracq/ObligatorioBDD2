package com.obligatorioPenca.obligatorioPenca.estudiante;

public class LoginDTO {
    public String email;
    public String contrasena;

    public LoginDTO(String email, String contrasena) {
        this.email = email;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}

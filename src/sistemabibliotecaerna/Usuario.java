package sistemabibliotecaerna;

import java.sql.Date;

public class Usuario {
    public int idNomeUsuario;
    public String nomeUsuario;
    public String sexo;
    public Date dataNascimento;
    public String email;

    public Usuario() {
    }

    public Usuario(int idNomeUsuario, String nomeUsuario, String sexo, Date dataNascimento, String email) {
        this.idNomeUsuario = idNomeUsuario;
        this.nomeUsuario = nomeUsuario;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    

    public int getIdNomeUsuario() {
        return idNomeUsuario;
    }

    public void setIdNomeUsuario(int idNomeUsuario) {
        this.idNomeUsuario = idNomeUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
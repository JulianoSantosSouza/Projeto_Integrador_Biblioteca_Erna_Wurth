package sistemabibliotecaerna;

import java.sql.Date;

public class Atendente extends Usuario{
    public int matriculaProf;

    public Atendente() {
    }

    public Atendente(int matriculaProf) {
        this.matriculaProf = matriculaProf;
    }

    public Atendente(int matriculaProf, int idNomeUsuario, String nomeUsuario, String sexo, Date dataNascimento, String email) {
        super(idNomeUsuario, nomeUsuario, sexo, dataNascimento, email);
        this.matriculaProf = matriculaProf;
    }

    public int getMatriculaProf() {
        return matriculaProf;
    }

    public void setMatriculaProf(int matriculaProf) {
        this.matriculaProf = matriculaProf;
    }

    @Override
    public int getIdNomeUsuario() {
        return idNomeUsuario;
    }

    @Override
    public void setIdNomeUsuario(int idNomeUsuario) {
        this.idNomeUsuario = idNomeUsuario;
    }

    @Override
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    @Override
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    @Override
    public String getSexo() {
        return sexo;
    }

    @Override
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public Date getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    
    

   
    
    
    
}
    

    
package sistemabibliotecaerna;

import java.sql.Date;

public class Aluno extends Usuario{
    public int matriculaEscolar;
    public String serie;
        

    public Aluno() {
        
    }

    public Aluno(int matriculaEscolar, String serie, int idNomeUsuario, String nomeUsuario, String sexo, Date dataNascimento, String email) {
        super(idNomeUsuario, nomeUsuario, sexo, dataNascimento, email);
        this.matriculaEscolar = matriculaEscolar;
        this.serie = serie;
    }

    public int getMatriculaEscolar() {
        return matriculaEscolar;
    }

    public void setMatriculaEscolar(int matriculaEscolar) {
        this.matriculaEscolar = matriculaEscolar;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
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

    Aluno getNomeUsuario(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}

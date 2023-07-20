
package sistemabibliotecaerna;

import java.sql.Date;

public class DevolucaoLivro {
    public int id;
    public Date dataRetorno;
    public EmprestimoLivro emprestimoLivro;
    public Livro livro;
    public Aluno aluno;

    public DevolucaoLivro() {
    }

    public DevolucaoLivro(int id, EmprestimoLivro emprestimoLivro, Livro livro, Aluno aluno) {
        this.id = id;
        this.emprestimoLivro = emprestimoLivro;
        this.livro = livro;
        this.aluno = aluno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public EmprestimoLivro getEmprestimoLivro() {
        return emprestimoLivro;
    }

    public void setEmprestimoLivro(EmprestimoLivro emprestimoLivro) {
        this.emprestimoLivro = emprestimoLivro;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
    
}

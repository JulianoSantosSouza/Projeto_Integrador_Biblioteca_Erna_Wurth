
package sistemabibliotecaerna;

import java.sql.Date;

public class EmprestimoLivro {
    public int idEmprestimo;
    public int livro_id;
    public int aluno_id;
    public Livro livro;
    public Aluno aluno;
    public Date RetornoEmpestimo;
    public String livroDevolvido = "NÃO";

    public EmprestimoLivro() {
    }

    public EmprestimoLivro(int idEmprestimo, int livro_id, Livro livro, Aluno aluno, Date RetornoEmpestimo, String livroDevolvido) {
        this.idEmprestimo = idEmprestimo;
        this.livro_id = livro_id;
        this.livro = livro;
        this.aluno = aluno;
        this.RetornoEmpestimo = RetornoEmpestimo;
        this.livroDevolvido = livroDevolvido;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
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

    public Date getRetornoEmpestimo() {
        return RetornoEmpestimo;
    }

    public void setRetornoEmpestimo(Date RetornoEmpestimo) {
        this.RetornoEmpestimo = RetornoEmpestimo;
    }

    public int getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(int livro_id) {
        this.livro_id = livro_id;
    }

    public int getAluno_id() {
        return aluno_id;
    }

    public void setAluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }

    public String getLivroDevolvido() {
        return livroDevolvido;
    }

    public void setLivroDevolvido(String livroDevolvido) {
        this.livroDevolvido = livroDevolvido;
    }
    
    

    int getRetornoEmpestimo(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    EmprestimoLivro RetornoEmpestimo(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void getIdEmprestimo(Integer valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
    
    
    
}

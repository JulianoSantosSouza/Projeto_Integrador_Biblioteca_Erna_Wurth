package sistemabibliotecaerna;

import java.sql.Date;

public class Livro{
    public int idNomeLivro;
    public String nomeLivro;
    public String categoriaLivro;
    public String statusLivro;
    public int numeroPaginas;
    public Date dataAquisicao;
    public String numeroRegistro;
    public String numeroRegistroVirtual;
    public String autorLivro;
    public String editoraLivro;

    public Livro() {
    }

    public int getIdNomeLivro() {
        return idNomeLivro;
    }

    public void setIdNomeLivro(int idNomeLivro) {
        this.idNomeLivro = idNomeLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getCategoriaLivro() {
        return categoriaLivro;
    }

    public void setCategoriaLivro(String categoriaLivro) {
        this.categoriaLivro = categoriaLivro;
    }

    public String getStatusLivro() {
        return statusLivro;
    }

    public void setStatusLivro(String statusLivro) {
        this.statusLivro = statusLivro;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getNumeroRegistroVirtual() {
        return numeroRegistroVirtual;
    }

    public void setNumeroRegistroVirtual(String numeroRegistroVirtual) {
        this.numeroRegistroVirtual = numeroRegistroVirtual;
    }

    public String getAutorLivro() {
        return autorLivro;
    }

    public void setAutorLivro(String autorLivro) {
        this.autorLivro = autorLivro;
    }

    public String getEditoraLivro() {
        return editoraLivro;
    }

    public void setEditoraLivro(String editoraLivro) {
        this.editoraLivro = editoraLivro;
    }

    Livro getNumeroRegistro(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Livro getNomeLivro(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Livro getStatusLivro(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    
    
}
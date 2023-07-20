package sistemabibliotecaerna;

import Telas.Devolucao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDao {

    Connection conn;
    PreparedStatement st;
    ResultSet rs;

    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotecaernawurth", "root", "sistemas01");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar no Banco de Dados: " + ex.getMessage());
            return false;
        }
    }
    
    public int cadastrar(Livro livro) {
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO livro (nomeLivro, categoriaLivro, statusLivro, numeroPaginas, dataAquisicao, numeroRegistro, numeroVirtual,autorLivro, editoraLivro) VALUES(?,?,?,?,?,?,?,?,?)");
            st.setString(1, livro.getNomeLivro());
            st.setString(2, livro.getCategoriaLivro());
            st.setString(3, livro.getStatusLivro());
            st.setInt(4, livro.getNumeroPaginas());
            st.setDate(5, (Date) livro.getDataAquisicao());
            st.setString(6, livro.getNumeroRegistro());
            st.setString(7, livro.getNumeroRegistroVirtual());
            st.setString(8, livro.getAutorLivro());
            st.setString(9, livro.getEditoraLivro());
            status = st.executeUpdate();
            return status; //retornar 1
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public boolean excluir(int id) {
        try {
            st = conn.prepareStatement("DELETE FROM livro WHERE idLivro = ?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao Excluir o Filme: " + ex.getMessage());
            return false;
        }
    }
    
    public int atualizar(Livro livro){
        int status;
        try {
            st = conn.prepareStatement("UPDATE livro SET nomeLivro = ?, categoriaLivro = ?, statusLivro = ?, numeroPaginas = ?, dataAquisicao = ?, numeroRegistro = ?, numeroVirtual = ?,autorLivro = ?, editoraLivro = ? WHERE idLivro = ?");
            st.setString(1, livro.getNomeLivro());
            st.setString(2, livro.getCategoriaLivro());
            st.setString(3, livro.getStatusLivro());
            st.setInt(4, livro.getNumeroPaginas());
            st.setDate(5, (Date) livro.getDataAquisicao());
            st.setString(6, livro.getNumeroRegistro());
            st.setString(7, livro.getNumeroRegistroVirtual());
            st.setString(8, livro.getAutorLivro());
            st.setString(9, livro.getEditoraLivro());
            st.setInt(10, livro.getIdNomeLivro());
            
            status = st.executeUpdate();
            return status; //retornar 1
        } catch (SQLException ex) {
            System.out.println("Erro ao Atualizar o livro: " + ex.getErrorCode() + " " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
        
    public Livro consultar (int id){
         
        try {
            Livro livro = new Livro();
            st = conn.prepareStatement("SELECT * from livro WHERE idLivro = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            //verificar se a consulta encontrou o livro com a id informada
            if(rs.next()){ // se encontrou o livro, vamos carregar os dados
                livro.setNomeLivro(rs.getString("nomeLivro"));
                livro.setCategoriaLivro(rs.getString("categoriaLivro"));
                livro.setStatusLivro(rs.getString("statusLivro"));
                livro.setNumeroPaginas(rs.getInt("numeroPaginas"));
                livro.setDataAquisicao(rs.getDate("dataAquisicao"));
                livro.setNumeroRegistro(rs.getString("numeroRegistro"));
                livro.setNumeroRegistroVirtual(rs.getString("numeroVirtual"));
                livro.setAutorLivro(rs.getString("autorLivro"));
                livro.setEditoraLivro(rs.getString("editoraLivro"));
                return livro;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Livro> listagem(String filtro) {

        String sql = "select * from livro WHERE livro.statusLivro = 'Na Biblioteca'";

        if (!filtro.isEmpty()) {
            sql = sql + " where nome like ?";
        }

        try {
            //Conexão
            st = conn.prepareStatement(sql);

            if (!filtro.isEmpty()) {
                st.setString(1, "%" + filtro + "%");
            }
            rs = st.executeQuery();

            List<Livro> lista = new ArrayList<>(); //crinado uma lista

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setIdNomeLivro(rs.getInt("idLivro")); //Nome da tabela banco de dados "id"
                livro.setNomeLivro(rs.getString("nomeLivro")); //Nome da tabela banco de dados "nome"
                livro.setCategoriaLivro(rs.getString("categoriaLivro")); //Nome da tabela banco de dados "categoriaLivro"
                livro.setStatusLivro(rs.getString("statusLivro")); //Nome da tabela banco de dados "statusLivro"
                livro.setNumeroPaginas(rs.getInt("numeroPaginas")); //Nome da tabela banco de dados "numeroPaginas"
                livro.setDataAquisicao(rs.getDate("dataAquisicao")); //Nome da tabela banco de dados "datalancamento"
                livro.setNumeroRegistro(rs.getString("numeroRegistro")); //Nome da tabela banco de dados "categoria"
                livro.setNumeroRegistroVirtual(rs.getString("numeroVirtual")); //Nome da tabela banco de dados "numeroVirtual"
                livro.setAutorLivro(rs.getString("autorLivro")); //Nome da tabela banco de dados "autorLivro"
                livro.setEditoraLivro(rs.getString("editoraLivro")); //Nome da tabela banco de dados "editoraLivro"
                lista.add(livro);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }

    }
    
    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {

        }
    }
    
    
    public String reverterData(String data) {
        String dia = data.substring(8);
        String mes = data.substring(5, 7);
        String ano = data.substring(0, 4);
        String dataLivro = dia + "/" + mes + "/" + ano;
        return dataLivro;
    }

}

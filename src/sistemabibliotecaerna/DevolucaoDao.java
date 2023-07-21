
package sistemabibliotecaerna;

import Telas.Devolucao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistemabibliotecaerna.EmprestimoLivro;
import sistemabibliotecaerna.EmprestimoLivroDao;

public class DevolucaoDao {
    
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
    
    public EmprestimoLivro consultar (int id){
         
        try {
            EmprestimoLivro emprestimo = new EmprestimoLivro();
            Livro livro = new Livro();
            
            st = conn.prepareStatement("SELECT Emprestimolivro.id, livro.numeroVirtual, livro.idLivro, livro.nomeLivro, livro.statusLivro\n" +
            "FROM Emprestimolivro\n" +
            "JOIN livro ON Emprestimolivro.livro_id = livro.idLivro\n" +
            "WHERE Emprestimolivro.id = ?");
            
            st.setInt(1, id);
            rs = st.executeQuery();
            //verificar se a consulta encontrou o livro com a id informada
            if(rs.next()){ // se encontrou o livro, vamos carregar os dados
                
                livro.setNumeroRegistroVirtual(rs.getString("numeroVirtual"));
                livro.setIdNomeLivro(rs.getInt("idLivro"));
                livro.setNomeLivro(rs.getString("nomeLivro"));
                livro.setStatusLivro(rs.getString("statusLivro"));
                
                emprestimo.setLivro(livro);
                
                return emprestimo;
                
            }else{
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
    }
    
    public int cadastrar(DevolucaoLivro devolucao) {
        int status;
        
        try {
            st = conn.prepareStatement("INSERT INTO devolucao(dataDevolucao) VALUES(?)");
            st.setDate(1, devolucao.getDataRetorno());
                                    
            status = st.executeUpdate();
                        
            return status; //retornar 1
            
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao Banco de Dados Devolucaolivro: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    /*public List<EmprestimoLivro> listagemDevolucao(String filtro) {

        String sql = "select E.id AS emprestimolivro, numeroRegistro AS livro, L.nomeLivro AS livro, L.statusLivro AS livro, A.nomeAluno AS aluno, E.dataRetornoLivro as emprestimolivro from emprestimolivro AS E INNER JOIN livro As L ON E.livro_id=L.idLivro INNER JOIN aluno AS A ON E.aluno_id=A.id;";

        if (!filtro.isEmpty()) {
            sql = sql + " where E.id like ?";
        }

        try {
            //Conexão
            st = conn.prepareStatement(sql);

            if (!filtro.isEmpty()) {
                st.setString(1, "%" + filtro + "%");
            }
            rs = st.executeQuery();

            List<EmprestimoLivro> lista = new ArrayList<>(); //crinado uma listaset

            while (rs.next()) {
                EmprestimoLivro Devolucao = new EmprestimoLivro();
                
                Devolucao.setIdEmprestimo(rs.getInt("emprestimo")); //Nome da tabela banco de dados "idEmprestmo"
                Devolucao.setLivro(Devolucao.livro.getNumeroRegistro(rs.getString("livro")));
                Devolucao.setLivro(Devolucao.livro.getNomeLivro(rs.getString("livro")));
                Devolucao.setLivro(Devolucao.livro.getStatusLivro(rs.getString("livro")));
                Devolucao.setAluno(Devolucao.aluno.getNomeUsuario(rs.getString("aluno")));
                Devolucao.setRetornoEmpestimo(rs.getDate("emprestimo"));
                
                
                lista.add(Devolucao);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
    }*/
    
    public List<DevolucaoLivro> listarLivrosEmprestados() {
             
        try {
            
            List<DevolucaoLivro> listDevolucao = new ArrayList<>();
                        
            st = conn.prepareStatement("SELECT Emprestimolivro.dataRetornoLivro, Emprestimolivro.id, Emprestimolivro.livroDevolvido, livro.idLivro, livro.numeroVirtual, livro.nomeLivro, livro.statusLivro, Aluno.nomeAluno\n" +
            "FROM Emprestimolivro\n" +
            "JOIN livro ON Emprestimolivro.livro_id = livro.idLivro\n" +
            "JOIN Aluno ON Emprestimolivro.aluno_id = aluno.id\n" +
            "WHERE Emprestimolivro.livroDevolvido = 'NÃO'");
            
            rs = st.executeQuery();
            
            while (rs.next()) {
                Livro livro = new Livro();
                Aluno aluno = new Aluno();
                DevolucaoLivro devolucao = new DevolucaoLivro();
                EmprestimoLivro emprestimo = new EmprestimoLivro();
                
                emprestimo.setIdEmprestimo(rs.getInt("id"));
                livro.setIdNomeLivro(rs.getInt("idLivro"));
                livro.setNumeroRegistroVirtual(rs.getString("NumeroVirtual"));
                livro.setNomeLivro(rs.getString("NomeLivro"));
                livro.setStatusLivro(rs.getString("StatusLivro"));
                aluno.setNomeUsuario(rs.getString("NomeAluno"));
                devolucao.setDataRetorno(rs.getDate("dataRetornoLivro"));
                emprestimo.setLivroDevolvido(rs.getString("livroDevolvido"));
                
                devolucao.setLivro(livro);
                devolucao.setAluno(aluno);
                devolucao.setEmprestimoLivro(emprestimo);
                
                //DevolucaoLivro devolucaoObj = new DevolucaoLivro();
                listDevolucao.add(devolucao);
            }
            return listDevolucao;
            
            
        } catch (Exception e) {
            System.out.println("Erro ao Listar os livros na tabela Emprestados: " + e.getMessage());
            return null;
        }
    }
    
    public int AtualizarStatusLivro(Livro livro){
        int status;
        try {
            st = conn.prepareStatement("UPDATE livro SET statusLivro = ? WHERE idLivro = ?");
            st.setString(1, "Na Biblioteca");
            st.setInt(2, livro.getIdNomeLivro());
                        
            status = st.executeUpdate();
                        
            return status; //retornar 1
            
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao Banco de Dados Livro: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public int AtualizarStatusDevolucao(EmprestimoLivro emprestimo){
        int status;
        try {
            st = conn.prepareStatement("UPDATE emprestimolivro SET livroDevolvido = ? WHERE id = ?");
            st.setString(1, "SIM");
            st.setInt(2, emprestimo.getIdEmprestimo());
                        
            status = st.executeUpdate();
                        
            return status; //retornar 1
            
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao Banco de Dados Livro: " + ex.getMessage());
            return ex.getErrorCode();
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


package sistemabibliotecaerna;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoLivroDao {
    
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
    
    public int cadastrar(EmprestimoLivro emprestimo) {
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO emprestimolivro(aluno_id, livro_id, dataRetornoLivro) VALUES(?,?,?)");
            st.setInt(1, emprestimo.getAluno_id());
            st.setInt(2, emprestimo.getLivro_id());
            st.setDate(3, emprestimo.getRetornoEmpestimo());
                        
            status = st.executeUpdate();
                        
            return status; //retornar 1
            
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao Banco de Dados emprestimolivro: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public int AtualizarStatus(Livro livro){
        int status;
        try {
            st = conn.prepareStatement("UPDATE livro SET statusLivro = ? WHERE idLivro = ?");
            st.setString(1, "Emprestado");
            st.setInt(2, livro.getIdNomeLivro());
                        
            status = st.executeUpdate();
                        
            return status; //retornar 1
            
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao Banco de Dados Livro: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public boolean excluir(int id) {
        try {
            st = conn.prepareStatement("DELETE FROM emprestimoLivro WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao Excluir o Registro de Emprestimo de Livro: " + ex.getMessage());
            return false;
        }
    }
    
     public List<Aluno> listagemAluno(String filtro) {

        String sql = "select * from Aluno";

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

            List<Aluno> lista = new ArrayList<>(); //crinado uma listaset

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setIdNomeUsuario(rs.getInt("id")); //Nome da tabela banco de dados "idNomeUsuario"
                aluno.setNomeUsuario(rs.getString("nomeAluno")); //Nome da tabela banco de dados "nomeUsuario"
                aluno.setMatriculaEscolar(rs.getInt("matriculaEscolar")); //Nome da tabela banco de dados "matriculaEscolar"
                aluno.setSerie(rs.getString("serie")); //Nome da tabela banco de dados "serie"
               
                lista.add(aluno);
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

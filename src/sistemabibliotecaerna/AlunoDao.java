
package sistemabibliotecaerna;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {
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
    
    public int cadastrar(Aluno aluno) {
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO aluno(nomeAluno, sexo, dataNascimento, email, matriculaEscolar, serie) VALUES(?,?,?,?,?,?)");
            st.setString(1, aluno.getNomeUsuario());
            st.setString(2, aluno.getSexo());
            st.setDate(3, aluno.getDataNascimento());
            st.setString(4, aluno.getEmail());
            st.setInt(5, aluno.getMatriculaEscolar());
            st.setString(6, aluno.getSerie());
            
            status = st.executeUpdate();
            
            return status; //retornar 1
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public boolean excluir(int id) {
        try {
            st = conn.prepareStatement("DELETE FROM Aluno WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao Excluir o Filme: " + ex.getMessage());
            return false;
        }
    }
    
    public int atualizar(Aluno aluno){
        int status;
        try {
            st = conn.prepareStatement("UPDATE Aluno SET nomeAluno = ?, sexo = ?, dataNascimento = ?, email = ?, matriculaEscolar = ?, serie = ? WHERE id = ?");
            st.setString(1, aluno.getNomeUsuario());
            st.setString(2, aluno.getSexo());
            st.setDate(3, aluno.getDataNascimento());
            st.setString(4, aluno.getEmail());
            st.setInt(5, aluno.getMatriculaEscolar());
            st.setString(6, aluno.getSerie());
            st.setInt(7, aluno.getIdNomeUsuario());
                        
            status = st.executeUpdate();
            return status; //retornar 1
        } catch (SQLException ex) {
            System.out.println("Erro ao Atualizar o livro: " + ex.getErrorCode() + " " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public Aluno consultar (int id){
         
        try {
            Aluno aluno = new Aluno();
            st = conn.prepareStatement("SELECT * from Aluno WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            //verificar se a consulta encontrou o livro com a id informada
            if(rs.next()){ // se encontrou o livro, vamos carregar os dados
                aluno.setNomeUsuario(rs.getString("nomeAluno"));
                aluno.setSexo(rs.getString("sexo"));
                aluno.setDataNascimento(rs.getDate("dataNascimento"));
                aluno.setEmail(rs.getString("email"));
                aluno.setMatriculaEscolar(rs.getInt("matriculaEscolar"));
                aluno.setSerie(rs.getString("serie"));
                return aluno;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Aluno> listagem(String filtro) {

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
                aluno.setSexo(rs.getString("sexo")); //Nome da tabela banco de dados "sexo"
                aluno.setDataNascimento(rs.getDate("dataNascimento")); //Nome da tabela banco de dados "datNascimento"
                aluno.setEmail(rs.getString("email")); //Nome da tabela banco de dados "email"
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

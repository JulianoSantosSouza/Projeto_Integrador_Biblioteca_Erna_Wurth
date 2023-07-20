
package sistemabibliotecaerna;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtendenteDao {
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
    
    public int cadastrar(Atendente atendente) {
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO atendente(nomeAtendente, sexo, dataNascimento, email, matricula) VALUES(?,?,?,?,?)");
            st.setString(1, atendente.getNomeUsuario());
            st.setString(2, atendente.getSexo());
            st.setDate(3, atendente.getDataNascimento());
            st.setString(4, atendente.getEmail());
            st.setInt(5, atendente.getMatriculaProf());
            
            status = st.executeUpdate();
            
            return status; //retornar 1
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public boolean excluir(int id) {
        try {
            st = conn.prepareStatement("DELETE FROM atendente WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao Excluir o Atendente: " + ex.getMessage());
            return false;
        }
    }
    
    public int atualizar(Atendente atendente){
        int status;
        try {
            st = conn.prepareStatement("UPDATE atendente SET nomeAtendente = ?, sexo = ?, dataNascimento = ?, email = ?, matricula = ? WHERE id = ?");
            st.setString(1, atendente.getNomeUsuario());
            st.setString(2, atendente.getSexo());
            st.setDate(3, atendente.getDataNascimento());
            st.setString(4, atendente.getEmail());
            st.setInt(5, atendente.getMatriculaProf());
            st.setInt(6, atendente.getIdNomeUsuario());
                        
            status = st.executeUpdate();
            return status; //retornar 1
        } catch (SQLException ex) {
            System.out.println("Erro ao Atualizar o Atendente: " + ex.getErrorCode() + " " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public Atendente consultar (int id){
         
        try {
            Atendente atendente = new Atendente();
            st = conn.prepareStatement("SELECT * from atendente WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            //verificar se a consulta encontrou o livro com a id informada
            if(rs.next()){ // se encontrou o livro, vamos carregar os dados
                atendente.setNomeUsuario(rs.getString("nomeAtendente"));
                atendente.setSexo(rs.getString("sexo"));
                atendente.setDataNascimento(rs.getDate("dataNascimento"));
                atendente.setEmail(rs.getString("email"));
                atendente.setMatriculaProf(rs.getInt("matricula"));
                return atendente;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
    }
    
    public List<Atendente> listagem(String filtro) {

        String sql = "select * from atendente";

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

            List<Atendente> lista = new ArrayList<>(); //crinado uma listaset

            while (rs.next()) {
                Atendente atendente = new Atendente();
                atendente.setIdNomeUsuario(rs.getInt("id")); //Nome da tabela banco de dados "id"
                atendente.setNomeUsuario(rs.getString("nomeAtendente")); //Nome da tabela banco de dados "nomeAtendnete"
                atendente.setSexo(rs.getString("sexo")); //Nome da tabela banco de dados "sexo"
                atendente.setDataNascimento(rs.getDate("dataNascimento")); //Nome da tabela banco de dados "datNascimento"
                atendente.setEmail(rs.getString("email")); //Nome da tabela banco de dados "email"
                atendente.setMatriculaProf(rs.getInt("matricula")); //Nome da tabela banco de dados "matriculaEscolar"
               
                lista.add(atendente);
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

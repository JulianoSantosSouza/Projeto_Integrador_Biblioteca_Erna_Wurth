
package Telas;
import static java.lang.Integer.valueOf;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sistemabibliotecaerna.Aluno;
import sistemabibliotecaerna.DevolucaoDao;
import sistemabibliotecaerna.DevolucaoLivro;
import sistemabibliotecaerna.EmprestimoLivro;
import sistemabibliotecaerna.EmprestimoLivroDao;
import sistemabibliotecaerna.Livro;
import sistemabibliotecaerna.LivroDao;
import sistemabibliotecaerna.Usuario;

public class Devolucao extends javax.swing.JFrame {
        
    
    public Devolucao() {
        initComponents();
        this.preencherTabelaDevolucao();
        
    }
    
    private void preencherTabelaDevolucao(){
        
        try {
            DevolucaoDao devolucaoDao = new DevolucaoDao();
            boolean conexao;
            conexao = devolucaoDao.conectar();
            
            if (conexao == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão para preencher Tabela de Devolução");
            } else {
                        
            DefaultTableModel model = (DefaultTableModel) jtTabelaDevolucao.getModel();
            model.setNumRows(0);
            
            List<DevolucaoLivro> listagem = devolucaoDao.listarLivrosEmprestados();
            
            for(int i = 0; i < listagem.size(); i++){
                model.addRow(new Object[]{
                    listagem.get(i).getEmprestimoLivro().getIdEmprestimo(),
                    listagem.get(i).getLivro().getNumeroRegistroVirtual(),
                    listagem.get(i).getLivro().getNomeLivro(),
                    listagem.get(i).getLivro().getStatusLivro(),
                    listagem.get(i).getAluno().getNomeUsuario(),
                    listagem.get(i).getDataRetorno(),
                    listagem.get(i).getEmprestimoLivro().getLivroDevolvido()
                });
              
            devolucaoDao.desconectar();
            }
        }    
        } catch (Exception e) {
                System.out.println("Erro ao Listar de Devolução: " + e.getMessage());
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jbConsultarLivro = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbDevolucao = new javax.swing.JButton();
        jtfStatusLivro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfCodigoLivro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabelaDevolucao = new javax.swing.JTable();
        jtfRetornoLivro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfNomeLivro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtfIdEmprestimo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfIdLivro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Status do Livro: ");

        jbConsultarLivro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbConsultarLivro.setText("CONSULTAR");
        jbConsultarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultarLivroActionPerformed(evt);
            }
        });

        jLabel10.setText("Consulta dos livros Emprestados ");

        jLabel5.setText("Nome do Livro para Empréstimo");

        jbDevolucao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbDevolucao.setText("DEVOLUÇÃO");
        jbDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDevolucaoActionPerformed(evt);
            }
        });

        jtfStatusLivro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Código do Livro:");

        jtfCodigoLivro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Data do Retorno do Empréstimo:");

        jtTabelaDevolucao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Emprestimo", "Codigo Livro", "Nome do Livro", "Status do Livro", "Nome do Aluno", "Retorno", "LivroDevolvido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtTabelaDevolucao);

        jtfRetornoLivro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Nome do Livro:");

        jtfNomeLivro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Devolução de Livros");

        jbVoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbVoltar.setText("VOLTAR");
        jbVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVoltarActionPerformed(evt);
            }
        });

        jLabel2.setText("ID Emprestimo");

        jtfIdEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdEmprestimoActionPerformed(evt);
            }
        });

        jLabel3.setText("ID");

        jtfIdLivro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfStatusLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtfCodigoLivro, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                            .addComponent(jtfIdEmprestimo)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jtfRetornoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jbConsultarLivro)
                                            .addGap(18, 18, 18)
                                            .addComponent(jbDevolucao)
                                            .addGap(18, 18, 18)
                                            .addComponent(jbVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 376, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfIdEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfCodigoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtfIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtfStatusLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtfRetornoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbConsultarLivro)
                    .addComponent(jbDevolucao)
                    .addComponent(jbVoltar))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jbVoltarActionPerformed

    private void jtfIdEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdEmprestimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdEmprestimoActionPerformed

    private void jbDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDevolucaoActionPerformed
        DevolucaoLivro devolucao = new DevolucaoLivro();
        DevolucaoDao dao = new DevolucaoDao();
        Livro livro = new Livro();
        EmprestimoLivro emprestimo = new EmprestimoLivro();
                                       
        boolean status;
        int resposta;
        int statusLivro;
        int statusDevolucao;
        
        //Convertendo a data digitada para o padrão do banco de dados.
        String dataRecebida = jtfRetornoLivro.getText(); //Um String para receber a data digitada em Portugues
        SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy"); //Classe para converter, recebendo o padrão que quero receber
        
        //Pode dar erro na hora da conversão da data - usar Try/catch
        try {
            Date dataConvertida = conversor.parse(dataRecebida); //pega o conversor e guardar na forma data
            java.sql.Date sqlDate = new java.sql.Date(dataConvertida.getTime()); //usando o pacote java, passando a conversão da data
            devolucao.setDataRetorno(sqlDate); //Pegar o sqlDate
        } catch (ParseException ex) { //caso der erro mostrar o erro.
            System.out.println("Erro na conversão de Data: " + ex.getMessage());
        }
        
        livro.setIdNomeLivro(Integer.valueOf(jtfIdLivro.getText()));
        emprestimo.setIdEmprestimo(Integer.valueOf(jtfIdEmprestimo.getText()));
        
        dao = new DevolucaoDao();

        status = dao.conectar();
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão da Devolução");
        } else {
            resposta = dao.cadastrar(devolucao);
            if (resposta == 1) {
                JOptionPane.showMessageDialog(null, "Dados do emprestimo do livro incluidos com sucesso");
            }else{
                JOptionPane.showMessageDialog(null, "Erro nos Dados de devolução do livro");
            }
            statusLivro = dao.AtualizarStatusLivro(livro);
            if(statusLivro == 1){
                JOptionPane.showMessageDialog(null, "Status do emprestimo do livro atualizado com sucesso");
            }else{
                JOptionPane.showMessageDialog(null, "Erro no atulizar o Status do livro"); 
            }
            statusDevolucao = dao.AtualizarStatusDevolucao(emprestimo);
            if(statusDevolucao == 1){
                JOptionPane.showMessageDialog(null, "Status da Devolução do livro atualizado com sucesso");
            }else{
                JOptionPane.showMessageDialog(null, "Erro no atulizar o Status do livro"); 
            }
            limpaCampos();
            preencherTabelaDevolucao();
            dao.desconectar();
    }
        
    }//GEN-LAST:event_jbDevolucaoActionPerformed

    private void jbConsultarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarLivroActionPerformed
        String id;
        id = jtfIdEmprestimo.getText();
        
        String txtIdEmprestimo = jtfIdEmprestimo.getText();
        if(txtIdEmprestimo.isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo ID do Emprestimo do livro deve ser preenchido!!");
            return;
        }
        
        DevolucaoDao dao = new DevolucaoDao();
        boolean status = dao.conectar();
        
        if (status == true) { //Quando não é encontrado no campo ele retorna "Funcionário não localizado".
            EmprestimoLivro livroEncontrado = dao.consultar(Integer.parseInt(jtfIdEmprestimo.getText())); // passar do méodo pesquisar o que está vindo da tela
            
            System.out.println(dao.consultar(Integer.parseInt(jtfIdEmprestimo.getText())));
            if (livroEncontrado == null) {
                JOptionPane.showMessageDialog(null, "Emprestimo do Livro não localizado");
            } else { //Se ele é localizado ele alimenta os camps da tela.
                
                jtfCodigoLivro.setText(livroEncontrado.getLivro().getNumeroRegistroVirtual());
                jtfIdLivro.setText(Integer.toString(livroEncontrado.getLivro().getIdNomeLivro()));
                jtfNomeLivro.setText(livroEncontrado.getLivro().getNomeLivro());
                jtfStatusLivro.setText(livroEncontrado.getLivro().getStatusLivro());
                
                
            }
            String txtRetornoEmprestimo = jtfRetornoLivro.getText();
            if (txtRetornoEmprestimo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Atenção\nO campo Data Retorno do Empréstimo deve ser preenchido para ser devolvido!!");
                return;
            }
            
            
            dao.desconectar();
        } else {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
     
    }//GEN-LAST:event_jbConsultarLivroActionPerformed
    
    public void limpaCampos() {
        jtfIdEmprestimo.setText("");
        jtfCodigoLivro.setText("");
        jtfNomeLivro.setText("");
        jtfStatusLivro.setText("");
        jtfRetornoLivro.setText("");
        
        
    }
    
    
    public String reverterData(String data) {
        String dia = data.substring(8);
        String mes = data.substring(5, 7);
        String ano = data.substring(0, 4);
        String dataFilme = dia + "/" + mes + "/" + ano;
        return dataFilme;
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Devolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Devolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Devolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Devolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Devolucao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbConsultarLivro;
    private javax.swing.JButton jbDevolucao;
    private javax.swing.JButton jbVoltar;
    private javax.swing.JTable jtTabelaDevolucao;
    private javax.swing.JTextField jtfCodigoLivro;
    private javax.swing.JTextField jtfIdEmprestimo;
    private javax.swing.JTextField jtfIdLivro;
    private javax.swing.JTextField jtfNomeLivro;
    private javax.swing.JTextField jtfRetornoLivro;
    private javax.swing.JTextField jtfStatusLivro;
    // End of variables declaration//GEN-END:variables

    
}

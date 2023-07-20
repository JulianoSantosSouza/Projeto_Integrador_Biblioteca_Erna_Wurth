package Telas;

import static java.lang.Integer.valueOf;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sistemabibliotecaerna.Aluno;
import sistemabibliotecaerna.AlunoDao;
import sistemabibliotecaerna.Livro;
import sistemabibliotecaerna.LivroDao;
import sistemabibliotecaerna.EmprestimoLivro;
import sistemabibliotecaerna.EmprestimoLivroDao;
import sistemabibliotecaerna.Usuario;

public class Emprestimo extends javax.swing.JFrame {
    private List<Livro> livroList = new ArrayList<>();

    public Emprestimo() {
        initComponents();
        this.preencherTabelaLivro("");
        this.preencherTabelaAluno("");
        
    }
    
    public int tabelaLivro() {
        jtLivro.getSelectedRow();
        return 0;
    }
    
    public int tabela() {
        jtAluno.getSelectedRow();
        return 0;
    }
    
    private void preencherTabelaLivro(String filtro) {
        Livro livro = new Livro();
        LivroDao dao = new LivroDao();
        boolean status;
        status = dao.conectar();
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            List<Livro> listaLivro = dao.listagem("");

            DefaultTableModel tabelaLivros = (DefaultTableModel) jtLivro.getModel();
            jtLivro.setRowSorter(new TableRowSorter(tabelaLivros));
            tabelaLivros.setNumRows(0);

            //Percorrer a Lista Filmes e inserir na Tabela
            for (Livro liv : listaLivro) {
                Object[] abj = new Object[]{
                    liv.getIdNomeLivro(),
                    liv.getNomeLivro(),
                    liv.getStatusLivro(),
                    liv.getAutorLivro(),
                    liv.getEditoraLivro()};

                tabelaLivros.addRow(abj);
            }

            
        }
    }
    
    private void preencherTabelaAluno(String filtro) {
        Aluno aluno = new Aluno();
        AlunoDao dao = new AlunoDao();
        boolean status;
        status = dao.conectar();
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            List<Aluno> listaAluno = dao.listagem("");

            DefaultTableModel tabelaAluno = (DefaultTableModel) jtAluno.getModel();
            jtAluno.setRowSorter(new TableRowSorter(tabelaAluno));
            tabelaAluno.setNumRows(0);

            //Percorrer a Lista Aluno e inserir na Tabela
            for (Aluno alu : listaAluno) {
                Object[] abj = new Object[]{
                    alu.getIdNomeUsuario(),
                    alu.getNomeUsuario(),
                    alu.getSerie(),
                    alu.getMatriculaEscolar()};

                tabelaAluno.addRow(abj);
            }

            dao.desconectar();
        }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfIdAluno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfNomeAluno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfIdLivro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfNomeLivro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfStatusLivro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfDataEmprestimo = new javax.swing.JTextField();
        jbConsultarAluno = new javax.swing.JButton();
        jbConsultarLivro = new javax.swing.JButton();
        jbEmprestarLivro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLivro = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAluno = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jbVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Emprestimo de Livros");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("ID do Aluno: ");

        jtfIdAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nome do Aluno: ");

        jtfNomeAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setText("Nome do Aluno para Empréstimo");

        jLabel5.setText("Nome do Livro para Empréstimo");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("ID do Livro:");

        jtfIdLivro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Nome do Livro:");

        jtfNomeLivro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Status do Livro: ");

        jtfStatusLivro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Informe o Retorno do Empréstimo:");

        jtfDataEmprestimo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jbConsultarAluno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbConsultarAluno.setText("CONSULTAR");
        jbConsultarAluno.setToolTipText("Informe o ID do Aluno");
        jbConsultarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultarAlunoActionPerformed(evt);
            }
        });

        jbConsultarLivro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbConsultarLivro.setText("CONSULTAR");
        jbConsultarLivro.setToolTipText("Informe o ID do Livro");
        jbConsultarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultarLivroActionPerformed(evt);
            }
        });

        jbEmprestarLivro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbEmprestarLivro.setText("EMPRESTAR");
        jbEmprestarLivro.setToolTipText("Coloque a data de retorno do livro");
        jbEmprestarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEmprestarLivroActionPerformed(evt);
            }
        });

        jtLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Livro", "Nome do Livro", "Status do Livro", "Autor do Livro", "Editora"
            }
        ));
        jScrollPane1.setViewportView(jtLivro);

        jLabel10.setText("Consulta de livro ");

        jtAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Aluno", "Nome Aluno", "Matricula", "Série"
            }
        ));
        jScrollPane2.setViewportView(jtAluno);

        jLabel11.setText("Consulta por aluno");

        jbVoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbVoltar.setText("VOLTAR");
        jbVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbEmprestarLivro)
                                .addGap(18, 18, 18)
                                .addComponent(jbVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jtfIdAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jtfNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jtfIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jtfNomeLivro))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(350, 350, 350)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfStatusLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbConsultarAluno)
                                    .addComponent(jbConsultarLivro))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 546, Short.MAX_VALUE)
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfIdAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbConsultarAluno))
                .addGap(45, 45, 45)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbConsultarLivro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtfStatusLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtfDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbVoltar)
                    .addComponent(jbEmprestarLivro))
                .addGap(32, 32, 32)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jbVoltarActionPerformed

    private void jbConsultarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarAlunoActionPerformed
        String id;
        id = jtfIdAluno.getText();
        String txtIdAluno = jtfIdAluno.getText();
        if(txtIdAluno.isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo ID do Aluno deve ser preenchido!!");
            return;
        }
        AlunoDao dao = new AlunoDao();
        boolean status = dao.conectar();
        if (status == true) { //Quando não é encontrado no campo ele retorna "Funcionário não localizado".
            Aluno AlunoEncontrado = dao.consultar(Integer.parseInt(jtfIdAluno.getText())); // passar do méodo pesquisar o que está vindo da tela
            System.out.println(dao.consultar(Integer.parseInt(jtfIdAluno.getText())));
            if (AlunoEncontrado == null) {
                JOptionPane.showMessageDialog(null, "aluno não localizado");
            } else { //Se ele é localizado ele alimenta os camps da tela.
                
                //jtfIdAluno.setText(String.valueOf(AlunoEncontrado.getIdNomeUsuario()));
                jtfNomeAluno.setText(AlunoEncontrado.getNomeUsuario());
            }
            dao.desconectar();
        } else {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
        
    }//GEN-LAST:event_jbConsultarAlunoActionPerformed

    private void jbConsultarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarLivroActionPerformed
        String id;
        id = jtfIdLivro.getText();
        String txtIdLivro = jtfIdLivro.getText();
        if(txtIdLivro.isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo ID do Livro deve ser preenchido!!");
            return;
        }
        
        LivroDao dao = new LivroDao();
        boolean status = dao.conectar();
        if (status == true) { //Quando não é encontrado no campo ele retorna "Funcionário não localizado".
            Livro livroEncontrado = dao.consultar(Integer.parseInt(jtfIdLivro.getText())); // passar do méodo pesquisar o que está vindo da tela
            System.out.println(dao.consultar(Integer.parseInt(jtfIdLivro.getText())));
            if (livroEncontrado == null) {
                JOptionPane.showMessageDialog(null, "Livro não localizado");
            } else { //Se ele é localizado ele alimenta os camps da tela.
                
                //jtfIdLivro.setText(String.valueOf(livroEncontrado.getIdNomeLivro()));
                jtfNomeLivro.setText(livroEncontrado.getNomeLivro());
                jtfStatusLivro.setText(livroEncontrado.getStatusLivro());
                
            }
            dao.desconectar();
        } else {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
    }//GEN-LAST:event_jbConsultarLivroActionPerformed

    private void jbEmprestarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEmprestarLivroActionPerformed
        EmprestimoLivro emprestimo = new EmprestimoLivro();
        EmprestimoLivroDao dao = new EmprestimoLivroDao();
        Livro livro = new Livro();
                                
        boolean status;
        int resposta;
        int statusLivro;
        
        emprestimo.setAluno_id(Integer.valueOf(jtfIdAluno.getText()));
        emprestimo.setLivro_id(Integer.valueOf(jtfIdLivro.getText()));
        //Convertendo a data digitada para o padrão do banco de dados.
        String dataRecebida = jtfDataEmprestimo.getText(); //Um String para receber a data digitada em Portugues
        SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy"); //Classe para converter, recebendo o padrão que quero receber

        //Pode dar erro na hora da conversão da data - usar Try/catch
        try {
            Date dataConvertida = conversor.parse(dataRecebida); //pega o conversor e guardar na forma data
            java.sql.Date sqlDate = new java.sql.Date(dataConvertida.getTime()); //usando o pacote java, passando a conversão da data
            emprestimo.setRetornoEmpestimo(sqlDate); //Pegar o sqlDate
        } catch (ParseException ex) { //caso der erro mostrar o erro.
            System.out.println("Erro na conversão de Data");
        }
        
        livro.setIdNomeLivro(Integer.valueOf(jtfIdLivro.getText()));
        
        String txtDataEmprestimo = jtfDataEmprestimo.getText();
        if(txtDataEmprestimo.isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo Retorno do Empréstimo deve ser preenchido!!");
            return;
        }
        
        
        dao = new EmprestimoLivroDao();

        status = dao.conectar();
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            resposta = dao.cadastrar(emprestimo);
            if (resposta == 1) {
                JOptionPane.showMessageDialog(null, "Dados do emprestimo do livro incluidos com sucesso");
            }else{
                JOptionPane.showMessageDialog(null, "Erro nos Dados do emprestimo do livro");
            }
            statusLivro = dao.AtualizarStatus(livro);
            if(statusLivro == 1){
                JOptionPane.showMessageDialog(null, "Status do emprestimo do livro atualizado com sucesso");
            }else{
                JOptionPane.showMessageDialog(null, "Erro no atulizar o Status do livro"); 
            }
            
            limpaCampos();
            preencherTabelaLivro("");
            dao.desconectar();
        }
    }//GEN-LAST:event_jbEmprestarLivroActionPerformed
    public void limpaCampos() {
        jtfIdAluno.setText("");
        jtfNomeAluno.setText("");
        jtfIdLivro.setText("");
        jtfNomeLivro.setText("");
        jtfStatusLivro.setText("");
        jtfDataEmprestimo.setText("");
        
        //Após limpar campos ele vai atualizar a tabela
        this.preencherTabelaAluno("");
        this.preencherTabelaLivro("");
    }

    public String reverterData(String data) {
        String dia = data.substring(8);
        String mes = data.substring(5, 7);
        String ano = data.substring(0, 4);
        String dataFilme = dia + "/" + mes + "/" + ano;
        return dataFilme;
    }
    
    public void Emprestar(){
        
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
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Emprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbConsultarAluno;
    private javax.swing.JButton jbConsultarLivro;
    private javax.swing.JButton jbEmprestarLivro;
    private javax.swing.JButton jbVoltar;
    private javax.swing.JTable jtAluno;
    private javax.swing.JTable jtLivro;
    private javax.swing.JTextField jtfDataEmprestimo;
    private javax.swing.JTextField jtfIdAluno;
    private javax.swing.JTextField jtfIdLivro;
    private javax.swing.JTextField jtfNomeAluno;
    private javax.swing.JTextField jtfNomeLivro;
    private javax.swing.JTextField jtfStatusLivro;
    // End of variables declaration//GEN-END:variables

    
}

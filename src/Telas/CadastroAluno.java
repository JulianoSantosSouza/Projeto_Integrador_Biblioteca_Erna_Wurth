package Telas;

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


public class CadastroAluno extends javax.swing.JFrame {

    private List<Aluno> AlunoList = new ArrayList<>();

    public CadastroAluno() {
        initComponents();
        this.preencherTabela("");
    }

    public int tabela() {
        jtTabelaAluno.getSelectedRow();
        return 0;
    }

    private void preencherTabela(String filtro) {
        Aluno aluno = new Aluno();
        AlunoDao dao = new AlunoDao();
        boolean status;
        status = dao.conectar();
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            List<Aluno> listaAluno = dao.listagem("");

            DefaultTableModel tabelaAluno = (DefaultTableModel) jtTabelaAluno.getModel();
            jtTabelaAluno.setRowSorter(new TableRowSorter(tabelaAluno));
            tabelaAluno.setNumRows(0);

            //Percorrer a Lista Filmes e inserir na Tabela
            for (Aluno alu : listaAluno) {
                Object[] abj = new Object[]{
                    alu.getIdNomeUsuario(),
                    alu.getNomeUsuario(),
                    alu.getSexo(),
                    this.reverterData(String.valueOf(alu.getDataNascimento())),
                    alu.getEmail(),
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jrMasculino = new javax.swing.JRadioButton();
        jrFeminino = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtfNomeAluno = new javax.swing.JTextField();
        jtfCodigoAluno = new javax.swing.JTextField();
        jtfDataNascimentoAluno = new javax.swing.JTextField();
        jtfEmailAluno = new javax.swing.JTextField();
        jtfMatriculaAuno = new javax.swing.JTextField();
        jtfSerieAluno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabelaAluno = new javax.swing.JTable();
        jbCadastrar = new javax.swing.JButton();
        jbConsultar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setToolTipText("");
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Cadastro de Alunos");

        jLabel2.setText("Dados Pessoais");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nome:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("informe o Id para consulta");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Sexo:");

        buttonGroup1.add(jrMasculino);
        jrMasculino.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jrMasculino.setText("Masculino");
        jrMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrMasculinoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrFeminino);
        jrFeminino.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jrFeminino.setText("Feminino");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Data de Nascimetno");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("E-mail:");

        jLabel8.setText("Dados Escolares");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Matrícula:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Série:");

        jtfNomeAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jtfCodigoAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jtfDataNascimentoAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jtfEmailAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jtfMatriculaAuno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jtfSerieAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jtTabelaAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Sexo", "Data Nascimento", "E-mail", "Série", "Matricula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtTabelaAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTabelaAlunoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTabelaAluno);

        jbCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbCadastrar.setText("CADASTRAR");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jbConsultar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbConsultar.setText("CONSULTAR");
        jbConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultarActionPerformed(evt);
            }
        });

        jbEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbEditar.setText("EDITAR");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbExcluir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbExcluir.setText("EXCLUIR");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbVoltar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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
                        .addGap(811, 811, 811)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jrMasculino, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jrFeminino, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jtfDataNascimentoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(284, 284, 284)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jtfEmailAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138)
                        .addComponent(jtfCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(618, 618, 618)
                        .addComponent(jbConsultar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jtfMatriculaAuno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jtfSerieAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jbCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5))
                    .addComponent(jrMasculino)
                    .addComponent(jrFeminino))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(jtfDataNascimentoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jtfEmailAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel8))
                    .addComponent(jbConsultar))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfMatriculaAuno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSerieAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar)
                    .addComponent(jbEditar)
                    .addComponent(jbExcluir)
                    .addComponent(jbVoltar))
                .addGap(51, 51, 51))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrMasculinoActionPerformed

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        Aluno aluno = new Aluno();
        AlunoDao dao = new AlunoDao();
        boolean status;
        int resposta;

        aluno.setNomeUsuario(jtfNomeAluno.getText());

        //Colocando o exo do Usuaário
        if (jrMasculino.isSelected()) {
            aluno.setSexo("Masculino");

        } else {
            aluno.setSexo("Feminino");
        }

        aluno.setEmail(jtfEmailAluno.getText());
        aluno.setMatriculaEscolar(Integer.valueOf(jtfMatriculaAuno.getText()));
        aluno.setSerie(jtfSerieAluno.getText());

        //Convertendo a data digitada para o padrão do banco de dados.
        String dataRecebina = jtfDataNascimentoAluno.getText(); //Um String para receber a data digitada em Portugues
        SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy"); //Classe para converter, recebendo o padrão que quero receber

        //Pode dar erro na hora da conversão da data - usar Try/catch
        try {
            Date dataConvertida = conversor.parse(dataRecebina); //pega o conversor e guardar na forma data
            java.sql.Date sqlDate = new java.sql.Date(dataConvertida.getTime()); //usando o pacote java, passando a conversão da data
            aluno.setDataNascimento(sqlDate); //Pegar o sqlDate

        } catch (ParseException ex) { //caso der erro mostrar o erro.
            System.out.println("Erro na conversão de Data");
        }

        dao = new AlunoDao();

        status = dao.conectar();
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            resposta = dao.cadastrar(aluno);
            if (resposta == 1) {
                JOptionPane.showMessageDialog(null, "Dados incluidos com sucesso");
                limpaCampos();

                dao.desconectar();
            }
        }
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jbVoltarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        AlunoDao dao = new AlunoDao();
        boolean status = dao.conectar();
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o Banco de Dados");
        } else {
            status = dao.excluir(Integer.parseInt(jtfCodigoAluno.getText()));
            if (status == true) {
                //int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza?");
                JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");
                this.limpaCampos();

            } else {
                JOptionPane.showMessageDialog(null, "Erro na exclusão do Aluno!");
            }
            dao.desconectar();
        }


    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        Aluno aluno = new Aluno(); //Abrindo a classe Aluno
        AlunoDao dao;               //Abrindo a classe AlunoDao
        boolean status;
        int resposta;

        //Obter da tela as informações
        aluno.setIdNomeUsuario(Integer.parseInt(jtfCodigoAluno.getText()));
        aluno.setNomeUsuario(jtfNomeAluno.getText());

        if (jrMasculino.isSelected()) {
            aluno.setSexo("Masculino");

        } else {
            aluno.setSexo("Feminino");
        }

        //Convertendo a data digitada para o padrão do banco de dados.
        String dataRecebina = jtfDataNascimentoAluno.getText(); //Um String para receber a data digitada em Portugues
        SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy"); //Classe para converter, recebendo o padrão que quero receber

        //Pode dar erro na hora da conversão da data - usar Try/catch
        try {
            Date dataConvertida = conversor.parse(dataRecebina); //pega o conversor e guardar na forma data
            java.sql.Date sqlDate = new java.sql.Date(dataConvertida.getTime()); //usando o pacote java, passando a conversão da data
            aluno.setDataNascimento(sqlDate); //Pegar o sqlDate

        } catch (ParseException ex) { //caso der erro mostrar o erro.
            System.out.println("Erro na conversão de Data");
        }

        aluno.setEmail(jtfEmailAluno.getText());
        aluno.setMatriculaEscolar(Integer.parseInt(jtfMatriculaAuno.getText()));
        aluno.setSerie(jtfSerieAluno.getText());

        dao = new AlunoDao(); //Criando um objeto dao Filme
        status = dao.conectar(); //Abre a conexão
        if (status == false) { //Caso não conectar chama o erro na tela.
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            resposta = dao.atualizar(aluno); //Chamar o metodo atualizar
            System.out.println(aluno.getIdNomeUsuario());
            if (resposta == 1) {
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
                //limpar os campos
                this.limpaCampos();
                //posicionar o cursor para um próximo
                jtfNomeAluno.requestFocus();
            } else if (resposta == 1062) {
                JOptionPane.showMessageDialog(null, "id já foi cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar inserir dados");
            }

            dao.desconectar();
        }

    }//GEN-LAST:event_jbEditarActionPerformed

    private void jtTabelaAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaAlunoMouseClicked
        int local = jtTabelaAluno.getSelectedRow();

        jtfCodigoAluno.setText(jtTabelaAluno.getValueAt(local, 0).toString());
        jtfNomeAluno.setText(jtTabelaAluno.getValueAt(local, 1).toString());
        jtfDataNascimentoAluno.setText(jtTabelaAluno.getValueAt(local, 3).toString());
        jtfEmailAluno.setText(jtTabelaAluno.getValueAt(local, 4).toString());
        jtfSerieAluno.setText(jtTabelaAluno.getValueAt(local, 5).toString());
        jtfMatriculaAuno.setText(jtTabelaAluno.getValueAt(local, 6).toString());

    }//GEN-LAST:event_jtTabelaAlunoMouseClicked

    private void jbConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarActionPerformed
        String id;
        id = jtfCodigoAluno.getText();
        AlunoDao dao = new AlunoDao();
        boolean status = dao.conectar();
        if (status == true) { //Quando não é encontrado no campo ele retorna "Funcionário não localizado".
            Aluno AlunoEncontrado = dao.consultar(Integer.parseInt(jtfCodigoAluno.getText())); // passar do méodo pesquisar o que está vindo da tela
            System.out.println(dao.consultar(Integer.parseInt(jtfCodigoAluno.getText())));
            if (AlunoEncontrado == null) {
                JOptionPane.showMessageDialog(null, "aluno não localizado");
            } else { //Se ele é localizado ele alimenta os camps da tela.
                jtfNomeAluno.setText(AlunoEncontrado.getNomeUsuario());

                if (AlunoEncontrado.getSexo().equals("Musculino")) {
                    jrMasculino.setSelected(true);

                } else {
                    jrMasculino.setSelected(false);
                }

                if (AlunoEncontrado.getSexo().equals("Feminino")) {
                    jrFeminino.setSelected(true);

                } else {
                    jrFeminino.setSelected(false);
                }
                jtfDataNascimentoAluno.setText(this.reverterData(String.valueOf(AlunoEncontrado.getDataNascimento())));
                jtfEmailAluno.setText(AlunoEncontrado.getEmail());
                jtfMatriculaAuno.setText(String.valueOf(AlunoEncontrado.getMatriculaEscolar()));
                jtfSerieAluno.setText(AlunoEncontrado.getSerie());
            }
            dao.desconectar();
        } else {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
    }//GEN-LAST:event_jbConsultarActionPerformed
    public void limpaCampos() {
        jtfNomeAluno.setText("");
        jtfDataNascimentoAluno.setText("");
        jrMasculino.setSelected(false);
        jrFeminino.setSelected(false);
        jtfEmailAluno.setText("");
        jtfMatriculaAuno.setText("");
        jtfSerieAluno.setText("");
        //Após limpar campos ele vai atualizar a tabela
        this.preencherTabela("");
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
            java.util.logging.Logger.getLogger(CadastroAluno.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbConsultar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbVoltar;
    private javax.swing.JRadioButton jrFeminino;
    private javax.swing.JRadioButton jrMasculino;
    private javax.swing.JTable jtTabelaAluno;
    private javax.swing.JTextField jtfCodigoAluno;
    private javax.swing.JTextField jtfDataNascimentoAluno;
    private javax.swing.JTextField jtfEmailAluno;
    private javax.swing.JTextField jtfMatriculaAuno;
    private javax.swing.JTextField jtfNomeAluno;
    private javax.swing.JTextField jtfSerieAluno;
    // End of variables declaration//GEN-END:variables
}

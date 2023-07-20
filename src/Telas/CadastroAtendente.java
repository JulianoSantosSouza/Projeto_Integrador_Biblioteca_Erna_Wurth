
package Telas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sistemabibliotecaerna.Atendente;
import sistemabibliotecaerna.AtendenteDao;



public class CadastroAtendente extends javax.swing.JFrame {
    private List<Atendente> AtendenteList = new ArrayList<>();
    
    public CadastroAtendente() {
        initComponents();
        this.preencherTabela("");
    }
    
    public int tabela(){
        jtTabelaAtendente.getSelectedRow();
        return 0;
    }
    
    private void preencherTabela(String filtro) {
        Atendente atendente = new Atendente();
        AtendenteDao dao = new AtendenteDao();
        boolean status;
        status = dao.conectar();
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            List<Atendente> listaAtendente = dao.listagem("");

            DefaultTableModel tabelaAtendente = (DefaultTableModel) jtTabelaAtendente.getModel();
            jtTabelaAtendente.setRowSorter(new TableRowSorter(tabelaAtendente));
            tabelaAtendente.setNumRows(0);

            //Percorrer a Lista Filmes e inserir na Tabela
            for (Atendente ate : listaAtendente) {
                Object[] abj = new Object[]{
                    ate.getIdNomeUsuario(),
                    ate.getNomeUsuario(),
                    ate.getSexo(),
                    this.reverterData(String.valueOf(ate.getDataNascimento())),
                    ate.getEmail(),
                    ate.getMatriculaProf()};

                tabelaAtendente.addRow(abj);
            }

            dao.desconectar();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabelaAtendente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jtfNomeAtendente = new javax.swing.JTextField();
        jbCadastrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jbConsultar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtfCodigoAtendente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jbEditar = new javax.swing.JButton();
        jtfDataNascimentoAtendente = new javax.swing.JTextField();
        jbExcluir = new javax.swing.JButton();
        jrMasculino = new javax.swing.JRadioButton();
        jtfEmailAtendente = new javax.swing.JTextField();
        jbVoltar = new javax.swing.JButton();
        jrFeminino = new javax.swing.JRadioButton();
        jtfMatriculaAtendente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("E-mail:");

        jLabel8.setText("Dados Escolares");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Matrícula:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Cadastro de Atendente");

        jtTabelaAtendente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Sexo", "Data Nasc.", "E-mail", "Matricula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtTabelaAtendente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTabelaAtendenteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTabelaAtendente);

        jLabel2.setText("Dados Pessoais");

        jtfNomeAtendente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jbCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbCadastrar.setText("CADASTRAR");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nome:");

        jbConsultar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbConsultar.setText("CONSULTAR");
        jbConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("informe o Id para consulta");

        jtfCodigoAtendente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Sexo:");

        jbEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbEditar.setText("EDITAR");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jtfDataNascimentoAtendente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jbExcluir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbExcluir.setText("EXCLUIR");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrMasculino);
        jrMasculino.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jrMasculino.setText("Masculino");
        jrMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrMasculinoActionPerformed(evt);
            }
        });

        jtfEmailAtendente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jbVoltar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbVoltar.setText("VOLTAR");
        jbVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVoltarActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrFeminino);
        jrFeminino.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jrFeminino.setText("Feminino");

        jtfMatriculaAtendente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Data de Nascimetno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(793, 793, 793)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jtfNomeAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jrMasculino, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrFeminino, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jtfDataNascimentoAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jtfEmailAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jtfCodigoAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jbConsultar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jtfMatriculaAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jbCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(jtfNomeAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jrMasculino)
                                .addComponent(jrFeminino)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6))
                            .addComponent(jtfDataNascimentoAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel7))
                            .addComponent(jtfEmailAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)
                        .addComponent(jtfCodigoAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jbConsultar)))
                .addGap(21, 21, 21)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9))
                    .addComponent(jtfMatriculaAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar)
                    .addComponent(jbEditar)
                    .addComponent(jbExcluir)
                    .addComponent(jbVoltar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        Atendente atendente = new Atendente();
        AtendenteDao dao = new AtendenteDao();
        boolean status;
        int resposta;

        atendente.setNomeUsuario(jtfNomeAtendente.getText());

        //Colocando o exo do Usuaário
        if (jrMasculino.isSelected()) {
            atendente.setSexo("Masculino");

        } else {
            atendente.setSexo("Feminino");
        }

        atendente.setEmail(jtfEmailAtendente.getText());
        atendente.setMatriculaProf(Integer.valueOf(jtfMatriculaAtendente.getText()));
        

        //Convertendo a data digitada para o padrão do banco de dados.
        String dataRecebina = jtfDataNascimentoAtendente.getText(); //Um String para receber a data digitada em Portugues
        SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy"); //Classe para converter, recebendo o padrão que quero receber

        //Pode dar erro na hora da conversão da data - usar Try/catch
        try {
            Date dataConvertida = conversor.parse(dataRecebina); //pega o conversor e guardar na forma data
            java.sql.Date sqlDate = new java.sql.Date(dataConvertida.getTime()); //usando o pacote java, passando a conversão da data
            atendente.setDataNascimento(sqlDate); //Pegar o sqlDate

        } catch (ParseException ex) { //caso der erro mostrar o erro.
            System.out.println("Erro na conversão de Data");
        }

        dao = new AtendenteDao();

        status = dao.conectar();
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            resposta = dao.cadastrar(atendente);
            if (resposta == 1) {
                JOptionPane.showMessageDialog(null, "Dados incluidos com sucesso");
                limpaCampos();

                dao.desconectar();
            }
        }
    
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jrMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrMasculinoActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        AtendenteDao dao = new AtendenteDao();
        boolean status = dao.conectar();
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o Banco de Dados");
        } else {
            status = dao.excluir(Integer.parseInt(jtfCodigoAtendente.getText()));
            if (status == true) {
                //int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza?");
                JOptionPane.showMessageDialog(null, "Atendente excluído com sucesso!");
                this.limpaCampos();

            } else {
                JOptionPane.showMessageDialog(null, "Erro na exclusão do Atendente!");
            }
            dao.desconectar();
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jbVoltarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        Atendente atendente = new Atendente(); //Abrindo a classe Aluno
        AtendenteDao dao;               //Abrindo a classe AlunoDao
        boolean status;
        int resposta;

        //Obter da tela as informações
        atendente.setIdNomeUsuario(Integer.parseInt(jtfCodigoAtendente.getText()));
        atendente.setNomeUsuario(jtfNomeAtendente.getText());

        if (jrMasculino.isSelected()) {
            atendente.setSexo("Masculino");

        } else {
            atendente.setSexo("Feminino");
        }

        //Convertendo a data digitada para o padrão do banco de dados.
        String dataRecebina = jtfDataNascimentoAtendente.getText(); //Um String para receber a data digitada em Portugues
        SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy"); //Classe para converter, recebendo o padrão que quero receber

        //Pode dar erro na hora da conversão da data - usar Try/catch
        try {
            Date dataConvertida = conversor.parse(dataRecebina); //pega o conversor e guardar na forma data
            java.sql.Date sqlDate = new java.sql.Date(dataConvertida.getTime()); //usando o pacote java, passando a conversão da data
            atendente.setDataNascimento(sqlDate); //Pegar o sqlDate

        } catch (ParseException ex) { //caso der erro mostrar o erro.
            System.out.println("Erro na conversão de Data");
        }

        atendente.setEmail(jtfEmailAtendente.getText());
        atendente.setMatriculaProf(Integer.parseInt(jtfMatriculaAtendente.getText()));
        
        dao = new AtendenteDao(); //Criando um objeto dao Atendente
        status = dao.conectar(); //Abre a conexão
        if (status == false) { //Caso não conectar chama o erro na tela.
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            resposta = dao.atualizar(atendente); //Chamar o metodo atualizar
            System.out.println(atendente.getIdNomeUsuario());
            if (resposta == 1) {
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
                //limpar os campos
                this.limpaCampos();
                //posicionar o cursor para um próximo
                jtfNomeAtendente.requestFocus();
            } else if (resposta == 1062) {
                JOptionPane.showMessageDialog(null, "id já foi cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar inserir dados");
            }

            dao.desconectar();
        }

    }//GEN-LAST:event_jbEditarActionPerformed

    private void jtTabelaAtendenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaAtendenteMouseClicked
        int local = jtTabelaAtendente.getSelectedRow();

        jtfCodigoAtendente.setText(jtTabelaAtendente.getValueAt(local, 0).toString());
        jtfNomeAtendente.setText(jtTabelaAtendente.getValueAt(local, 1).toString());
        jtfDataNascimentoAtendente.setText(jtTabelaAtendente.getValueAt(local, 3).toString());
        jtfEmailAtendente.setText(jtTabelaAtendente.getValueAt(local, 4).toString());
        jtfMatriculaAtendente.setText(jtTabelaAtendente.getValueAt(local, 5).toString());
        
    }//GEN-LAST:event_jtTabelaAtendenteMouseClicked

    private void jbConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarActionPerformed
        String id;
        id = jtfCodigoAtendente.getText();
        AtendenteDao dao = new AtendenteDao();
        boolean status = dao.conectar();
        if (status == true) { //Quando não é encontrado no campo ele retorna "Funcionário não localizado".
            Atendente AtendenteEncontrado = dao.consultar(Integer.parseInt(jtfCodigoAtendente.getText())); // passar do méodo pesquisar o que está vindo da tela
            System.out.println(dao.consultar(Integer.parseInt(jtfCodigoAtendente.getText())));
            if (AtendenteEncontrado == null) {
                JOptionPane.showMessageDialog(null, "Atendente não localizado");
            } else { //Se ele é localizado ele alimenta os camps da tela.
                jtfNomeAtendente.setText(AtendenteEncontrado.getNomeUsuario());

                if (AtendenteEncontrado.getSexo().equals("Musculino")) {
                    jrMasculino.setSelected(true);

                } else {
                    jrMasculino.setSelected(false);
                }

                if (AtendenteEncontrado.getSexo().equals("Feminino")) {
                    jrFeminino.setSelected(true);

                } else {
                    jrFeminino.setSelected(false);
                }
                jtfDataNascimentoAtendente.setText(this.reverterData(String.valueOf(AtendenteEncontrado.getDataNascimento())));
                jtfEmailAtendente.setText(AtendenteEncontrado.getEmail());
                jtfMatriculaAtendente.setText(String.valueOf(AtendenteEncontrado.getMatriculaProf()));
                
            }
            dao.desconectar();
        } else {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
    }//GEN-LAST:event_jbConsultarActionPerformed
    public void limpaCampos() {
        jtfNomeAtendente.setText("");
        jtfDataNascimentoAtendente.setText("");
        jrMasculino.setSelected(false);
        jrFeminino.setSelected(false);
        jtfEmailAtendente.setText("");
        jtfMatriculaAtendente.setText("");
        
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
            java.util.logging.Logger.getLogger(CadastroAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAtendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroAtendente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTable jtTabelaAtendente;
    private javax.swing.JTextField jtfCodigoAtendente;
    private javax.swing.JTextField jtfDataNascimentoAtendente;
    private javax.swing.JTextField jtfEmailAtendente;
    private javax.swing.JTextField jtfMatriculaAtendente;
    private javax.swing.JTextField jtfNomeAtendente;
    // End of variables declaration//GEN-END:variables
}

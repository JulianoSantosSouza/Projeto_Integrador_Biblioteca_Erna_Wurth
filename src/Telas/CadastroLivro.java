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
import sistemabibliotecaerna.Livro;
import sistemabibliotecaerna.LivroDao;

public class CadastroLivro extends javax.swing.JFrame {

    private List<Livro> livroList = new ArrayList<>();

    public CadastroLivro() {
        initComponents();
        this.preencherTabela("");
    }

    public int tabela() {
        jtTabelaLivro.getSelectedRow();
        return 0;
    }

    private void preencherTabela(String filtro) {
        Livro livro = new Livro();
        LivroDao dao = new LivroDao();
        boolean status;
        status = dao.conectar();
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            List<Livro> listaLivro = dao.listagem("");

            DefaultTableModel tabelaLivros = (DefaultTableModel) jtTabelaLivro.getModel();
            jtTabelaLivro.setRowSorter(new TableRowSorter(tabelaLivros));
            tabelaLivros.setNumRows(0);

            //Percorrer a Lista Filmes e inserir na Tabela
            for (Livro liv : listaLivro) {
                Object[] abj = new Object[]{
                    liv.getIdNomeLivro(),
                    liv.getNumeroRegistro(),
                    liv.getNumeroRegistroVirtual(),
                    liv.getNomeLivro(),
                    liv.getStatusLivro(),
                    liv.getAutorLivro(),
                    liv.getEditoraLivro()};

                tabelaLivros.addRow(abj);
            }

            dao.desconectar();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jrEmprestado = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jbConsultar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfCodigoLivro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabelaLivro = new javax.swing.JTable();
        jtfCategoriaLivro = new javax.swing.JTextField();
        jbExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jrNaBiblioteca = new javax.swing.JRadioButton();
        jtfNomeLivro = new javax.swing.JTextField();
        jtfDataAquisicao = new javax.swing.JTextField();
        jbCadastrar = new javax.swing.JButton();
        jbVoltar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jtfNumeroPaginas = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfNumeroRegistro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfNumeroRegistroVirtual = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtfNomeAutor = new javax.swing.JTextField();
        jtfNomeEditora = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nome do Livro:");

        jrEmprestado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jrEmprestado.setText("Emprestado");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Data de Aquisição:");

        jbConsultar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbConsultar.setText("CONSULTAR");
        jbConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("informe o Id para consulta");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Categoria:");

        jtfCodigoLivro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfCodigoLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoLivroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Cadastro de Livro");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Status do Livro:");

        jbEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbEditar.setText("EDITAR");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jtTabelaLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nº Registro", "Registro Virtual", "Nome do Livro", "Status", "Autor", "Editora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtTabelaLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTabelaLivroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTabelaLivro);

        jtfCategoriaLivro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jbExcluir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbExcluir.setText("EXCLUIR");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jLabel2.setText("Dados do Livro");

        jrNaBiblioteca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jrNaBiblioteca.setSelected(true);
        jrNaBiblioteca.setText("Na Biblioteca");
        jrNaBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrNaBibliotecaActionPerformed(evt);
            }
        });

        jtfNomeLivro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jtfDataAquisicao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jbCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbCadastrar.setText("CADASTRAR");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jbVoltar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbVoltar.setText("VOLTAR");
        jbVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVoltarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Número de Páginas:");

        jtfNumeroPaginas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Nº Registro:");

        jtfNumeroRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Nº Registro Virtual:");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jtfNumeroRegistroVirtual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Nome Autor");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Nome Editora:");

        jtfNomeAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfNomeAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeAutorActionPerformed(evt);
            }
        });

        jtfNomeEditora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jtfNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jtfCategoriaLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jtfNumeroRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jrNaBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jrEmprestado, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(253, 253, 253)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jtfNumeroRegistroVirtual, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jtfDataAquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jtfNumeroPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtfNomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel14)
                        .addGap(12, 12, 12)
                        .addComponent(jtfNomeEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145)
                        .addComponent(jtfCodigoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(780, 780, 780)
                        .addComponent(jbConsultar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 927, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jbCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(jtfNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfCategoriaLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNumeroRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5))
                    .addComponent(jrNaBiblioteca)
                    .addComponent(jrEmprestado)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jtfNumeroRegistroVirtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfDataAquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNumeroPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel13))
                    .addComponent(jtfNomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel14))
                    .addComponent(jtfNomeEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCodigoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jbConsultar)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar)
                    .addComponent(jbEditar)
                    .addComponent(jbExcluir)
                    .addComponent(jbVoltar)))
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNomeAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomeAutorActionPerformed

    private void jbVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jbVoltarActionPerformed

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        Livro livro = new Livro();
        LivroDao dao = new LivroDao();
        boolean status;
        int resposta;

        livro.setNomeLivro(jtfNomeLivro.getText());
        livro.setCategoriaLivro(jtfCategoriaLivro.getText());

        //Colocando o Status do Livro
        if (jrNaBiblioteca.isSelected()) {
            livro.setStatusLivro("Na Biblioteca");

        } else {
            livro.setStatusLivro("Emprestado");
        }

        livro.setNumeroPaginas(Integer.valueOf(jtfNumeroPaginas.getText()));
        livro.setNumeroRegistro(jtfNumeroRegistro.getText());
        livro.setNumeroRegistroVirtual(jtfNumeroRegistroVirtual.getText());
        livro.setAutorLivro(jtfNomeAutor.getText());
        livro.setEditoraLivro(jtfNomeEditora.getText());

        //Convertendo a data digitada para o padrão do banco de dados.
        String dataRecebina = jtfDataAquisicao.getText(); //Um String para receber a data digitada em Portugues
        SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy"); //Classe para converter, recebendo o padrão que quero receber

        //Pode dar erro na hora da conversão da data - usar Try/catch
        try {
            Date dataConvertida = conversor.parse(dataRecebina); //pega o conversor e guardar na forma data
            java.sql.Date sqlDate = new java.sql.Date(dataConvertida.getTime()); //usando o pacote java, passando a conversão da data
            livro.setDataAquisicao(sqlDate); //Pegar o sqlDate

        } catch (ParseException ex) { //caso der erro mostrar o erro.
            System.out.println("Erro na conversão de Data");
        }

        dao = new LivroDao();

        status = dao.conectar();
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            resposta = dao.cadastrar(livro);
            if (resposta == 1) {
                JOptionPane.showMessageDialog(null, "Dados incluidos com sucesso");
                limpaCampos();
                
                dao.desconectar();
            }
        }

    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jrNaBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrNaBibliotecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrNaBibliotecaActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        LivroDao dao = new LivroDao();
        boolean status = dao.conectar();
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o Banco de Dados");
        } else {
            status = dao.excluir(Integer.parseInt(jtfCodigoLivro.getText()));
            if (status == true) {
                //int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza?");
                JOptionPane.showMessageDialog(null, "Livro excluído com sucesso!");
                this.limpaCampos();

            } else {
                JOptionPane.showMessageDialog(null, "Erro na exclusão do Livro!");
            }
            dao.desconectar();
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jtTabelaLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaLivroMouseClicked
        int local = jtTabelaLivro.getSelectedRow();
           
        jtfCodigoLivro.setText(jtTabelaLivro.getValueAt(local, 0).toString());
        jtfNumeroRegistro.setText(jtTabelaLivro.getValueAt(local, 1).toString());
        jtfNumeroRegistroVirtual.setText(jtTabelaLivro.getValueAt(local, 2).toString());
        jtfNomeLivro.setText(jtTabelaLivro.getValueAt(local, 3).toString());
        jtfNomeAutor.setText(jtTabelaLivro.getValueAt(local, 5).toString());
        jtfNomeEditora.setText(jtTabelaLivro.getValueAt(local, 6).toString());

    }//GEN-LAST:event_jtTabelaLivroMouseClicked

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        Livro livro = new Livro(); //Abrindo a classe filme
        LivroDao dao;               //Abrindo a classe FilmeDao
        boolean status;
        int resposta;

        //Obter da tela as informações
        livro.setIdNomeLivro(Integer.parseInt(jtfCodigoLivro.getText()));
        livro.setNomeLivro(jtfNomeLivro.getText());
        livro.setCategoriaLivro(jtfCategoriaLivro.getText());
        //Colocando o Status do Livro
        if (jrNaBiblioteca.isSelected()) {
            livro.setStatusLivro("Na Biblioteca");

        } else {
            livro.setStatusLivro("Emprestado");
        }

        livro.setNumeroPaginas(Integer.parseInt(jtfNumeroPaginas.getText()));
        livro.setNumeroRegistro(jtfNumeroRegistro.getText());
        livro.setNumeroRegistroVirtual(jtfNumeroRegistroVirtual.getText());
        livro.setAutorLivro(jtfNomeAutor.getText());
        livro.setEditoraLivro(jtfNomeEditora.getText());

        //Convertendo a data digitada para o padrão do banco de dados.
        String dataRecebina = jtfDataAquisicao.getText(); //Um String para receber a data digitada em Portugues
        SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy"); //Classe para converter, recebendo o padrão que quero receber

        //Pode dar erro na hora da conversão da data - usar Try/catch
        try {
            Date dataConvertida = conversor.parse(dataRecebina); //pega o conversor e guardar na forma data
            java.sql.Date sqlDate = new java.sql.Date(dataConvertida.getTime()); //usando o pacote java, passando a conversão da data
            livro.setDataAquisicao(sqlDate); //Pegar o sqlDate

        } catch (ParseException ex) { //caso der erro mostrar o erro.
            System.out.println("Erro na conversão de Data");
        }

        dao = new LivroDao(); //Criando um objeto dao Filme
        status = dao.conectar(); //Abre a conexão
        if (status == false) { //Caso não conectar chama o erro na tela.
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            resposta = dao.atualizar(livro); //Chamar o metodo atualizar
            System.out.println(livro.getIdNomeLivro());
            if (resposta == 1) {
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
                //limpar os campos
                this.limpaCampos();
                //posicionar o cursor para um próximo
                jtfNomeLivro.requestFocus();
            } else if (resposta == 1062) {
                JOptionPane.showMessageDialog(null, "id já foi cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar inserir dados");
            }
            
            dao.desconectar();
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarActionPerformed
        String id;
        id = jtfCodigoLivro.getText();
        LivroDao dao = new LivroDao();
        boolean status = dao.conectar();
        if (status == true) { //Quando não é encontrado no campo ele retorna "Funcionário não localizado".
            Livro livroEncontrado = dao.consultar(Integer.parseInt(jtfCodigoLivro.getText())); // passar do méodo pesquisar o que está vindo da tela
            System.out.println(dao.consultar(Integer.parseInt(jtfCodigoLivro.getText())));
            if (livroEncontrado == null) {
                JOptionPane.showMessageDialog(null, "Livro não localizado");
            } else { //Se ele é localizado ele alimenta os camps da tela.
                jtfNomeLivro.setText(livroEncontrado.getNomeLivro());
                jtfCategoriaLivro.setText(livroEncontrado.getCategoriaLivro());

                if (livroEncontrado.getStatusLivro().equals("Na Biblioteca")) {
                    jrNaBiblioteca.setSelected(true);

                } else {
                    jrNaBiblioteca.setSelected(false);
                }

                if (livroEncontrado.getStatusLivro().equals("Emprestado")) {
                    jrEmprestado.setSelected(true);

                } else {
                    jrEmprestado.setSelected(false);
                }

                jtfNumeroPaginas.setText(String.valueOf(livroEncontrado.getNumeroPaginas()));
                jtfDataAquisicao.setText(this.reverterData(String.valueOf(livroEncontrado.getDataAquisicao())));
                jtfNumeroRegistro.setText(livroEncontrado.getNumeroRegistro());
                jtfNumeroRegistroVirtual.setText(livroEncontrado.getNumeroRegistroVirtual());
                jtfNomeAutor.setText(livroEncontrado.getAutorLivro());
                jtfNomeEditora.setText(livroEncontrado.getEditoraLivro());
            }
            dao.desconectar();
        } else {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
    }//GEN-LAST:event_jbConsultarActionPerformed

    private void jtfCodigoLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoLivroActionPerformed
    public void limpaCampos() {
        jtfNomeLivro.setText("");
        jtfCategoriaLivro.setText("");
        jrNaBiblioteca.setSelected(false);
        jrEmprestado.setSelected(false);
        jtfNumeroPaginas.setText("");
        jtfDataAquisicao.setText("");
        jtfNumeroRegistro.setText("");
        jtfNumeroRegistroVirtual.setText("");
        jtfNomeAutor.setText("");
        jtfNomeEditora.setText("");
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
            java.util.logging.Logger.getLogger(CadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JRadioButton jrEmprestado;
    private javax.swing.JRadioButton jrNaBiblioteca;
    private javax.swing.JTable jtTabelaLivro;
    private javax.swing.JTextField jtfCategoriaLivro;
    private javax.swing.JTextField jtfCodigoLivro;
    private javax.swing.JTextField jtfDataAquisicao;
    private javax.swing.JTextField jtfNomeAutor;
    private javax.swing.JTextField jtfNomeEditora;
    private javax.swing.JTextField jtfNomeLivro;
    private javax.swing.JTextField jtfNumeroPaginas;
    private javax.swing.JTextField jtfNumeroRegistro;
    private javax.swing.JTextField jtfNumeroRegistroVirtual;
    // End of variables declaration//GEN-END:variables
}

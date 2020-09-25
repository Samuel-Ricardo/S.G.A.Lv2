/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import JDBC.ConnectionFactory;
import javax.swing.JOptionPane;
import java.sql.*;

public class CadCliente extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public CadCliente() {
        conexao = ConnectionFactory.getConnection();
        initComponents();
    }

    public void cadastrar() {
        String sql = "insert into tbcliente(nomecli, matriculacli, emailcli, fonecli, enderecocli, cidadecli, modulocli, seriecli, cursocli) values(?,?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeCli.getText());
            pst.setString(2, txtMatriculaCli.getText());
            pst.setString(3, txtEmailCli.getText());
            pst.setString(4, txtFoneCli.getText());
            pst.setString(5, txtEnderecoCli.getText());
            pst.setString(6, cbxCidadeCli.getSelectedItem().toString());
            pst.setString(7, cbxModuloCli.getSelectedItem().toString());
            pst.setString(8, cbxSerieCli.getSelectedItem().toString());
            pst.setString(9, cbxCursoCli.getSelectedItem().toString());
            if ((txtNomeCli.getText().isEmpty()) || (txtFoneCli.getText().isEmpty()) || (cbxCidadeCli.getSelectedItem().toString().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Por favor digite os campos obrigatórios!");
                txtNomeCli.setText(null);
                txtMatriculaCli.setText(null);
                txtEmailCli.setText(null);
                txtEnderecoCli.setText(null);
                txtFoneCli.setText(null);
                txtIdCli.setText(null);
                cbxCidadeCli.setSelectedItem(null);
                cbxModuloCli.setSelectedItem(null);
                cbxSerieCli.setSelectedItem(null);
                cbxCursoCli.setSelectedItem(null);

            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com Sucesso!");
                    txtNomeCli.setText(null);
                    txtMatriculaCli.setText(null);
                    txtEmailCli.setText(null);
                    txtEnderecoCli.setText(null);
                    txtFoneCli.setText(null);
                    txtIdCli.setText(null);
                    cbxCidadeCli.setSelectedItem(null);
                    cbxModuloCli.setSelectedItem(null);
                    cbxSerieCli.setSelectedItem(null);
                    cbxCursoCli.setSelectedItem(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void procurar() {
        String sql = "select idcli, nomecli, matriculacli, emailcli, fonecli, enderecocli,cidadecli,modulocli,seriecli,cursocli from tbcliente where nomecli=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeCli.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtIdCli.setText(rs.getString(1));
                txtNomeCli.setText(rs.getString(2));
                txtMatriculaCli.setText(rs.getString(3));
                txtEmailCli.setText(rs.getString(4));
                txtEnderecoCli.setText(rs.getString(5));
                txtFoneCli.setText(rs.getString(6));
                cbxCidadeCli.setSelectedItem(rs.getString(7));
                cbxModuloCli.setSelectedItem(rs.getString(8));
                cbxSerieCli.setSelectedItem(rs.getString(9));
                cbxCursoCli.setSelectedItem(rs.getString(10));
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
                txtNomeCli.setText(null);
                txtMatriculaCli.setText(null);
                txtEmailCli.setText(null);
                txtEnderecoCli.setText(null);
                txtFoneCli.setText(null);
                txtIdCli.setText(null);
                cbxCidadeCli.setSelectedItem(null);
                cbxModuloCli.setSelectedItem(null);
                cbxSerieCli.setSelectedItem(null);
                cbxCursoCli.setSelectedItem(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void deletar() {
        int confirma;
        confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário", "Atenção", (JOptionPane.YES_NO_OPTION));
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tbcliente where idcli=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtIdCli.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
                    txtNomeCli.setText(null);
                    txtMatriculaCli.setText(null);
                    txtEmailCli.setText(null);
                    txtEnderecoCli.setText(null);
                    txtFoneCli.setText(null);
                    txtIdCli.setText(null);
                    cbxCidadeCli.setSelectedItem(null);
                    cbxModuloCli.setSelectedItem(null);
                    cbxSerieCli.setSelectedItem(null);
                    cbxCursoCli.setSelectedItem(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public void alterar() {
        String sql = "update tbcleinte set nomecli=?,nomecli=?,matriculacli=?,emailcli=?,fonecli=?,enderecocli=?,cidadecli=?,modulocli=?,seriecli=?,cursocli=? where idcli=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeCli.getText());
            pst.setString(2, txtMatriculaCli.getText());
            pst.setString(3, txtEmailCli.getText());
            pst.setString(4, txtFoneCli.getText());
            pst.setString(5, txtEnderecoCli.getText());
            pst.setString(6, cbxCidadeCli.getSelectedItem().toString());
            pst.setString(7, cbxModuloCli.getSelectedItem().toString());
            pst.setString(8, cbxSerieCli.getSelectedItem().toString());
            pst.setString(9, cbxCursoCli.getSelectedItem().toString());
            if ((txtNomeCli.getText().isEmpty()) || (txtFoneCli.getText().isEmpty()) || (cbxCidadeCli.getSelectedItem().toString().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Por favor digite os campos obrigatórios!");
                txtNomeCli.setText(null);
                txtMatriculaCli.setText(null);
                txtEmailCli.setText(null);
                txtEnderecoCli.setText(null);
                txtFoneCli.setText(null);
                txtIdCli.setText(null);
                cbxCidadeCli.setSelectedItem(null);
                cbxModuloCli.setSelectedItem(null);
                cbxSerieCli.setSelectedItem(null);
                cbxCursoCli.setSelectedItem(null);
            } else {
                JOptionPane.showMessageDialog(null, "Dados do cliente alterado com sucesso!");
                txtNomeCli.setText(null);
                txtMatriculaCli.setText(null);
                txtEmailCli.setText(null);
                txtEnderecoCli.setText(null);
                txtFoneCli.setText(null);
                txtIdCli.setText(null);
                cbxCidadeCli.setSelectedItem(null);
                cbxModuloCli.setSelectedItem(null);
                cbxSerieCli.setSelectedItem(null);
                cbxCursoCli.setSelectedItem(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCadastrar = new javax.swing.JButton();
        cbxCidadeCli = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtNomeCli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMatriculaCli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmailCli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnProcurar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbxModuloCli = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbxSerieCli = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbxCursoCli = new javax.swing.JComboBox<>();
        txtFoneCli = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        txtEnderecoCli = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Oasis - Cadastros de Clientes");
        setPreferredSize(new java.awt.Dimension(600, 108));

        btnCadastrar.setText("Cadastar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        cbxCidadeCli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abreu e Lima", "Afogados da Ingazeira", "Afranio", "Agrestina", "Agua Preta", "Aguas Belas", "Alagoinha", "Alianca", "Altinho", "Amaraji", "Angelim", "Aracoiaba", "Araripina", "Arcoverde", "Barra de Guabiraba", "Barreiros", "Belem de Maria", "Belem de Sao Francisco", "Belo Jardim", "Betania", "Bezerros", "Bodoco", "Bom Conselho", "Bom Jardim", "Bonito", "Brejao", "Brejinho", "Brejo da Madre de Deus", "Buenos Aires", "Buique", "Cabo de Santo Agostinho", "Cabrobo", "Cachoeirinha", "Caetes", "Calcado", "Calumbi", "Camaragibe", "Camocim de Sao Felix", "Camutanga", "Canhotinho", "Capoeiras", "Carnaiba", "Carnaubeira da Penha", "Carpina", "Caruaru", "Casinhas", "Catende", "Cedro", "Cha Grande", "Cha de Alegria", "Condado", "Correntes", "Cortes", "Cumaru", "Cupira", "Custodia", "Dormentes", "Escada", "Exu", "Feira Nova", "Ferreiros", "Flores", "Floresta", "Frei Miguelinho", "Gameleira", "Garanhuns", "Gloria do Goita", "Goiana", "Granito", "Gravata", "Iati", "Ibimirim", "Ibirajuba", "Igarassu", "Iguaraci", "Inaja", "Ingazeira", "Ipojuca", "Ipubi", "Itacuruba", "Itaiba", "Itamaraca", "Itambe", "Itapetim", "Itapissuma", "Itaquitinga", "Jaboatao dos Guararapes", "Jaqueira", "Jatauba", "Jatoba", "Joao Alfredo", "Joaquim Nabuco", "Jucati", "Jupi", "Jurema", "Lagoa Grande", "Lagoa do Carro", "Lagoa do Itaenga", "Lagoa do Ouro", "Lagoa dos Gatos", "Lajedo", "Limoeiro", "Macaparana", "Machados", "Manari", "Maraial", "Mirandiba", "Moreilandia", "Moreno", "Nazare da Mata", "Olinda", "Orobo", "Oroco", "Ouricuri", "Palmares", "Palmeirina", "Panelas", "Paranatama", "Parnamirim", "Passira", "Paudalho", "Paulista", "Pedra", "Pesqueira", "Petrolandia", "Petrolina", "Pocao", "Pombos", "Primavera", "Quipapa", "Quixaba", "Recife", "Riacho das Almas", "Ribeirao", "Rio Formoso", "Saire", "Salgadinho", "Salgueiro", "Saloa", "Sanharo", "Santa Cruz da Baixa Verde", "Santa Cruz do Capibaribe", "Santa Cruz", "Santa Filomena", "Santa Maria da Boa Vista", "Santa Maria do Cambuca", "Santa Terezinha", "Sao Benedito do Sul", "Sao Bento do Una", "Sao Caitano", "Sao Joao", "Sao Joaquim do Monte", "Sao Jose da Coroa Grande", "Sao Jose do Belmonte", "Sao Jose do Egito", "Sao Lourenco da Mata", "Sao Vicente Ferrer", "Serra Talhada", "Serrita", "Sertania", "Sirinhaem", "Solidao", "Surubim", "Tabira", "Tacaimbo", "Tacaratu", "Tamandare", "Taquaritinga do Norte", "Terezinha", "Terra Nova", "Timbauba", "Toritama", "Tracunhaem", "Trindade", "Triunfo", "Tupanatinga", "Tuparetama", "Venturosa", "Verdejante", "Vertente do Lerio", "Vertentes", "Vicencia", "Vitoria de Santo Antao", "Xexeu" }));

        jLabel2.setText("Nome do Cliente");

        jLabel3.setText("Matrícula do Cliente:");

        jLabel4.setText("E-mail:");

        jLabel5.setText("Telefone:");

        jLabel6.setText("Endereço:");

        jLabel7.setText("Cidade:");

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnProcurar.setText("Procurar");
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        jLabel8.setText("Módulo:");

        cbxModuloCli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INTEGRADO", "SUBSEQUENTE", "EDUCAÇÃO A DISTÂNCIA" }));

        jLabel9.setText("Série:");

        cbxSerieCli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1º ANO", "2º ANO", "3º ANO" }));

        jLabel10.setText("Curso:");

        cbxCursoCli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRAÇÃO", "AGROECOLOGIA", "AGROPECUÁRIA", "COMÉRCIO ", "COMUNICAÇÃO VISUAL ", "DESENVOLVIMENTO DE SISTEMAS", "DESIGN DE INTERIORES", "EVENTOS", "ELETROTÉCNICA", "EDIFICAÇÕES", "GUIA DE TURISMO", "HOSPEDAGEM", "INFORMÁTICA PARA INTERNET", "LOGÍSTICA", "MANUTENÇÃO E SUPORTE EM INFORMÁTICA ", "MARKETING", "MECÂNICA", "MECATRÔNICA", "MEIO AMBIENTE", "MULTIMÍDIA", "NUTRIÇÃO E DIETÉTICA", "PROGRAMAÇÃO DE JOGOS DIGITAIS ", "REDES DE COMPUTADORES" }));

        try {
            txtFoneCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 699, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtEmailCli, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMatriculaCli, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxModuloCli, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxSerieCli, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(txtNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFoneCli, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCursoCli, 0, 342, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxCidadeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnProcurar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeletar)))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtEnderecoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMatriculaCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbxModuloCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmailCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cbxSerieCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(cbxCursoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFoneCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEnderecoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAlterar)
                        .addComponent(btnDeletar)
                        .addComponent(btnProcurar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(cbxCidadeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 715, 355);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        cadastrar();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        procurar();
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        deletar();
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterar();
    }//GEN-LAST:event_btnAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JComboBox<String> cbxCidadeCli;
    private javax.swing.JComboBox<String> cbxCursoCli;
    private javax.swing.JComboBox<String> cbxModuloCli;
    private javax.swing.JComboBox<String> cbxSerieCli;
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
    private javax.swing.JTextField txtEmailCli;
    private javax.swing.JTextField txtEnderecoCli;
    private javax.swing.JFormattedTextField txtFoneCli;
    private javax.swing.JTextField txtMatriculaCli;
    private javax.swing.JTextField txtNomeCli;
    // End of variables declaration//GEN-END:variables
}

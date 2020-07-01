/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.sql.*;
import javax.swing.JOptionPane;
import JDBC.ConnectionFactory;

public class CadUser extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    ;
    
    
    public CadUser() {
        conexao = ConnectionFactory.getConnection();
        initComponents();

    }

    private void consultar() {
        String sql = "select * from tbuser where id=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIdUser.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtIdUser.setText(rs.getString(1));
                txtNomeUser.setText(rs.getString(2));
                txtLogUser.setText(rs.getString(3));
                txtPswUser.setText(rs.getString(4));
                cbxTipoUser.setSelectedItem(rs.getString(5));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
                txtIdUser.setText(null);
                txtNomeUser.setText(null);
                txtLogUser.setText(null);
                txtPswUser.setText(null);
                cbxTipoUser.setSelectedItem(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void cadastrar() {
        String sql = "Insert into tbuser (id,nome,loguin,senha,tipo) values (?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,txtIdUser.getText());
            pst.setString(2, txtNomeUser.getText());
            pst.setString(3, txtLogUser.getText());
            pst.setString(4, txtPswUser.getText());
            pst.setString(5, cbxTipoUser.getSelectedItem().toString());

            if ((txtIdUser.getText().isEmpty())||(txtNomeUser.getText().isEmpty()) || (txtLogUser.getText().isEmpty()) || (txtPswUser.getText().isEmpty()) || (cbxTipoUser.getSelectedItem().toString().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos por favor!");
                txtIdUser.setText(null);
                txtNomeUser.setText(null);
                txtLogUser.setText(null);
                txtPswUser.setText(null);
                cbxTipoUser.setSelectedItem(null);
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário cadatrado com Sucesso!");
                    txtIdUser.setText(null);
                    txtNomeUser.setText(null);
                    txtLogUser.setText(null);
                    txtPswUser.setText(null);
                    cbxTipoUser.setSelectedItem(null);
                }

            }
        } catch (Exception e) {

        }
    }
     private void deletar(){
      int confirma;
      confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário", "Atenção", (JOptionPane.YES_NO_OPTION));
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tbuser where id=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtIdUser.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
                    txtIdUser.setText(null);
                    txtNomeUser.setText(null);
                    txtLogUser.setText(null);
                    txtPswUser.setText(null);
                    cbxTipoUser.setSelectedItem(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
     }
     private void alterar(){
     String sql = "update tbuser set nome=?,loguin=?,senha=?,tipo=? where id=?";
         try {
             pst = conexao.prepareStatement(sql);
            pst.setString(5,txtIdUser.getText());
            pst.setString(1, txtNomeUser.getText());
            pst.setString(2, txtLogUser.getText());
            pst.setString(3, txtPswUser.getText());
            pst.setString(4, cbxTipoUser.getSelectedItem().toString());
            if ((txtIdUser.getText().isEmpty())||(txtNomeUser.getText().isEmpty()) || (txtLogUser.getText().isEmpty()) || (txtPswUser.getText().isEmpty()) || (cbxTipoUser.getSelectedItem().toString().isEmpty())){
            JOptionPane.showMessageDialog(null, "Por favor digite os campos obrigatórios!");
                txtIdUser.setText(null);
                txtNomeUser.setText(null);
                txtLogUser.setText(null);
                txtPswUser.setText(null);
                cbxTipoUser.setSelectedItem(null);
            }else{
                int alterado;
                alterado = pst.executeUpdate();
                if(alterado>0){
                  JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
                    txtIdUser.setText(null);
                    txtNomeUser.setText(null);
                    txtLogUser.setText(null);
                    txtPswUser.setText(null);
                    cbxTipoUser.setSelectedItem(null);
                }
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

        txtIdUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        cbxTipoUser = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtNomeUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLogUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPswUser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        btnProcurar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Oasis - Cadastro de Usuários");

        jLabel1.setText("ID do Usuário:");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        cbxTipoUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));

        jLabel2.setText("Nome do Usuário:");

        jLabel3.setText("Loguin:");

        jLabel4.setText("Senha:");

        jLabel5.setText("Tipo:");

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnProcurar.setText("Procurar");
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtLogUser, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(68, 68, 68)
                                        .addComponent(jLabel4))
                                    .addComponent(cbxTipoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNomeUser, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(txtPswUser)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtPswUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxTipoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        consultar();
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        cadastrar();
    }//GEN-LAST:event_btnCadastrarActionPerformed

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
    private javax.swing.JComboBox<String> cbxTipoUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtIdUser;
    private javax.swing.JTextField txtLogUser;
    private javax.swing.JTextField txtNomeUser;
    private javax.swing.JTextField txtPswUser;
    // End of variables declaration//GEN-END:variables
}

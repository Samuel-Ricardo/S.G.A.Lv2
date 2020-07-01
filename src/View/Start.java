package View;

import javax.swing.JOptionPane;
import View.BookRegistrationView;

public class Start extends javax.swing.JFrame {

    public Start() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu5 = new javax.swing.JMenu();
        Desktop = new javax.swing.JDesktopPane();
        Sair = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        menIntCadLivros = new javax.swing.JMenuItem();
        menIntCadCli = new javax.swing.JMenuItem();
        menIntCadUser = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menAlugLivro = new javax.swing.JMenuItem();
        menIntLivAlugados = new javax.swing.JMenuItem();
        menIntLivDisponíveis = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        menListaClientes = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menIntSAC = new javax.swing.JMenuItem();
        menIntSobre = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menIntSair = new javax.swing.JMenuItem();

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Oasis - Inicio");

        Desktop.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );

        Sair.setToolTipText("");

        jMenu4.setText("Cadastros");

        menIntCadLivros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        menIntCadLivros.setText("Cadastro de Livros");
        menIntCadLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menIntCadLivrosActionPerformed(evt);
            }
        });
        jMenu4.add(menIntCadLivros);

        menIntCadCli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        menIntCadCli.setText("Cadastross de Clientes");
        menIntCadCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menIntCadCliActionPerformed(evt);
            }
        });
        jMenu4.add(menIntCadCli);

        menIntCadUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        menIntCadUser.setForeground(new java.awt.Color(255, 0, 0));
        menIntCadUser.setText("Cadastro de Usuários");
        menIntCadUser.setEnabled(false);
        menIntCadUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menIntCadUserActionPerformed(evt);
            }
        });
        jMenu4.add(menIntCadUser);

        Sair.add(jMenu4);

        jMenu2.setText("Gerenciamento Aluguel");

        menAlugLivro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        menAlugLivro.setText("Alugar Livro");
        menAlugLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAlugLivroActionPerformed(evt);
            }
        });
        jMenu2.add(menAlugLivro);

        menIntLivAlugados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        menIntLivAlugados.setText("Livros Alugados");
        menIntLivAlugados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menIntLivAlugadosActionPerformed(evt);
            }
        });
        jMenu2.add(menIntLivAlugados);

        menIntLivDisponíveis.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        menIntLivDisponíveis.setText("Livros Disponíveis");
        menIntLivDisponíveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menIntLivDisponíveisActionPerformed(evt);
            }
        });
        jMenu2.add(menIntLivDisponíveis);

        Sair.add(jMenu2);

        jMenu6.setText("Clientes");

        menListaClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        menListaClientes.setText("Lista de Clientes");
        menListaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menListaClientesActionPerformed(evt);
            }
        });
        jMenu6.add(menListaClientes);

        Sair.add(jMenu6);

        jMenu3.setText("Sobre");

        menIntSAC.setText("S.A.C");
        jMenu3.add(menIntSAC);

        menIntSobre.setText("Sobre");
        jMenu3.add(menIntSobre);

        Sair.add(jMenu3);

        jMenu1.setText("Sair");

        menIntSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menIntSair.setText("Desligar Sistema");
        menIntSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menIntSairActionPerformed(evt);
            }
        });
        jMenu1.add(menIntSair);

        Sair.add(jMenu1);

        setJMenuBar(Sair);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );

        setSize(new java.awt.Dimension(1096, 689));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menIntSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menIntSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja desligar o sistema ?", "Encerrando o Sistema", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_menIntSairActionPerformed

    private void menIntCadLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menIntCadLivrosActionPerformed
       BookRegistrationView cadlivros = new BookRegistrationView();
       cadlivros.setVisible(true);
       Desktop.add(cadlivros);
    }//GEN-LAST:event_menIntCadLivrosActionPerformed

    private void menIntCadCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menIntCadCliActionPerformed
       CadCliente cadcli = new CadCliente();
       cadcli.setVisible(true);
       Desktop.add(cadcli);
    }//GEN-LAST:event_menIntCadCliActionPerformed

    private void menIntCadUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menIntCadUserActionPerformed
       CadUser caduser = new CadUser();
       caduser.setVisible(true);
       Desktop.add(caduser);
    }//GEN-LAST:event_menIntCadUserActionPerformed

    private void menIntLivAlugadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menIntLivAlugadosActionPerformed
        LivAlu livrosAlugados = new LivAlu();
        livrosAlugados.setVisible(true);
        Desktop.add(livrosAlugados);
    }//GEN-LAST:event_menIntLivAlugadosActionPerformed

    private void menIntLivDisponíveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menIntLivDisponíveisActionPerformed
        LivDisp livrosDisponiveis = new LivDisp();
        livrosDisponiveis.setVisible(true);
        Desktop.add(livrosDisponiveis);
    }//GEN-LAST:event_menIntLivDisponíveisActionPerformed

    private void menAlugLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAlugLivroActionPerformed
        AlugueldeLivros aluguel = new AlugueldeLivros();
        aluguel.setVisible(true);
        Desktop.add(aluguel);
    }//GEN-LAST:event_menAlugLivroActionPerformed

    private void menListaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menListaClientesActionPerformed
        ListaClientes lt = new ListaClientes();
        lt.setVisible(true);
        Desktop.add(lt);
    }//GEN-LAST:event_menListaClientesActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuBar Sair;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem menAlugLivro;
    private javax.swing.JMenuItem menIntCadCli;
    private javax.swing.JMenuItem menIntCadLivros;
    public static javax.swing.JMenuItem menIntCadUser;
    private javax.swing.JMenuItem menIntLivAlugados;
    private javax.swing.JMenuItem menIntLivDisponíveis;
    private javax.swing.JMenuItem menIntSAC;
    private javax.swing.JMenuItem menIntSair;
    private javax.swing.JMenuItem menIntSobre;
    private javax.swing.JMenuItem menListaClientes;
    // End of variables declaration//GEN-END:variables
}

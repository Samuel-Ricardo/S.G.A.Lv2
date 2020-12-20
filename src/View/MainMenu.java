package View;

import View.Researchers.ListOfStudents;
import View.Registers.StudentRegistrationView;
import Controller.MainMenuController;
import Model.Book;
import Model.User;
import javax.swing.JOptionPane;
import View.Registers.BookRegistrationView;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenu extends javax.swing.JFrame {

    private MainMenuController controller;
    
    public MainMenu() {
        initComponents();
        
        controller = new MainMenuController(this);
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
        jMenuItem2 = new javax.swing.JMenuItem();
        menIntCadUser = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menAlugLivro = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menListaClientes = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
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
        menIntCadCli.setText("Cadastros de Alunos");
        menIntCadCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menIntCadCliActionPerformed(evt);
            }
        });
        jMenu4.add(menIntCadCli);

        jMenuItem2.setText("Cadastro de Cliente");
        jMenu4.add(jMenuItem2);

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

        jMenu2.setText("Operaçoes");

        menAlugLivro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        menAlugLivro.setText("Alugar Livro");
        menAlugLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAlugLivroActionPerformed(evt);
            }
        });
        jMenu2.add(menAlugLivro);

        Sair.add(jMenu2);

        jMenu6.setText("Pesquisa");

        jMenuItem1.setText("Livros");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        menListaClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        menListaClientes.setText("Estudantes");
        menListaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menListaClientesActionPerformed(evt);
            }
        });
        jMenu6.add(menListaClientes);

        jMenuItem3.setText("Usuarios");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenuItem4.setText("Aluguéis");
        jMenu6.add(jMenuItem4);

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
       StudentRegistrationView cadcli = new StudentRegistrationView();
       cadcli.setVisible(true);
       Desktop.add(cadcli);
    }//GEN-LAST:event_menIntCadCliActionPerformed

    private void menIntCadUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menIntCadUserActionPerformed
       CadUser caduser = new CadUser();
       caduser.setVisible(true);
       Desktop.add(caduser);
    }//GEN-LAST:event_menIntCadUserActionPerformed

    private void menAlugLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAlugLivroActionPerformed
        MainMenuController.OpenRent(new Book(), new User());
    }//GEN-LAST:event_menAlugLivroActionPerformed

    private void menListaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menListaClientesActionPerformed
        ListOfStudents lt = new ListOfStudents();
        lt.setVisible(true);
        Desktop.add(lt);
    }//GEN-LAST:event_menListaClientesActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        MainMenuController.openBookList();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem menAlugLivro;
    private javax.swing.JMenuItem menIntCadCli;
    private javax.swing.JMenuItem menIntCadLivros;
    public static javax.swing.JMenuItem menIntCadUser;
    private javax.swing.JMenuItem menIntSAC;
    private javax.swing.JMenuItem menIntSair;
    private javax.swing.JMenuItem menIntSobre;
    private javax.swing.JMenuItem menListaClientes;
    // End of variables declaration//GEN-END:variables

    public MainMenuController getController() {
        return controller;
    }

    public void setController(MainMenuController controller) {
        this.controller = controller;
    }

    public JDesktopPane getDesktop() {
        return Desktop;
    }

    public void setDesktop(JDesktopPane Desktop) {
        this.Desktop = Desktop;
    }

    public JMenuBar getSair() {
        return Sair;
    }

    public void setSair(JMenuBar Sair) {
        this.Sair = Sair;
    }

    public JMenu getjMenu1() {
        return jMenu1;
    }

    public void setjMenu1(JMenu jMenu1) {
        this.jMenu1 = jMenu1;
    }

    public JMenu getjMenu2() {
        return jMenu2;
    }

    public void setjMenu2(JMenu jMenu2) {
        this.jMenu2 = jMenu2;
    }

    public JMenu getjMenu3() {
        return jMenu3;
    }

    public void setjMenu3(JMenu jMenu3) {
        this.jMenu3 = jMenu3;
    }

    public JMenu getjMenu4() {
        return jMenu4;
    }

    public void setjMenu4(JMenu jMenu4) {
        this.jMenu4 = jMenu4;
    }

    public JMenu getjMenu5() {
        return jMenu5;
    }

    public void setjMenu5(JMenu jMenu5) {
        this.jMenu5 = jMenu5;
    }

    public JMenu getjMenu6() {
        return jMenu6;
    }

    public void setjMenu6(JMenu jMenu6) {
        this.jMenu6 = jMenu6;
    }

    public JMenuItem getjMenuItem1() {
        return jMenuItem1;
    }

    public void setjMenuItem1(JMenuItem jMenuItem1) {
        this.jMenuItem1 = jMenuItem1;
    }

    public JMenuItem getMenAlugLivro() {
        return menAlugLivro;
    }

    public void setMenAlugLivro(JMenuItem menAlugLivro) {
        this.menAlugLivro = menAlugLivro;
    }

    public JMenuItem getMenIntCadCli() {
        return menIntCadCli;
    }

    public void setMenIntCadCli(JMenuItem menIntCadCli) {
        this.menIntCadCli = menIntCadCli;
    }

    public JMenuItem getMenIntCadLivros() {
        return menIntCadLivros;
    }

    public void setMenIntCadLivros(JMenuItem menIntCadLivros) {
        this.menIntCadLivros = menIntCadLivros;
    }

    public static JMenuItem getMenIntCadUser() {
        return menIntCadUser;
    }

    public static void setMenIntCadUser(JMenuItem menIntCadUser) {
        MainMenu.menIntCadUser = menIntCadUser;
    }

    public JMenuItem getMenIntSAC() {
        return menIntSAC;
    }

    public void setMenIntSAC(JMenuItem menIntSAC) {
        this.menIntSAC = menIntSAC;
    }

    public JMenuItem getMenIntSair() {
        return menIntSair;
    }

    public void setMenIntSair(JMenuItem menIntSair) {
        this.menIntSair = menIntSair;
    }

    public JMenuItem getMenIntSobre() {
        return menIntSobre;
    }

    public void setMenIntSobre(JMenuItem menIntSobre) {
        this.menIntSobre = menIntSobre;
    }

    public JMenuItem getMenListaClientes() {
        return menListaClientes;
    }

    public void setMenListaClientes(JMenuItem menListaClientes) {
        this.menListaClientes = menListaClientes;
    }

    public JMenuItem getjMenuItem2() {
        return jMenuItem2;
    }

    public void setjMenuItem2(JMenuItem jMenuItem2) {
        this.jMenuItem2 = jMenuItem2;
    }

    public JMenuItem getjMenuItem3() {
        return jMenuItem3;
    }

    public void setjMenuItem3(JMenuItem jMenuItem3) {
        this.jMenuItem3 = jMenuItem3;
    }

    public JMenuItem getjMenuItem4() {
        return jMenuItem4;
    }

    public void setjMenuItem4(JMenuItem jMenuItem4) {
        this.jMenuItem4 = jMenuItem4;
    }

    
}

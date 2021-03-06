/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author Ervin
 */
public class MyBooks extends javax.swing.JFrame {
   
    CallableStatement cs = null;
    Connection conn = null;
    OraclePreparedStatement pst = null;
    OracleResultSet rs = null;

    /**
     * Creates new form MyBooks
     */
    public MyBooks() {
        initComponents();
        show_my_table();
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table_own_books = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table_own_books.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table_own_books.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_own_booksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_own_books);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cartile imprumutate de tine ");

        back_button.setText("Back");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 386, Short.MAX_VALUE)
                        .addComponent(back_button)
                        .addGap(218, 218, 218))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(back_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        this.dispose();
        UserChoice c = new UserChoice();
        c.setVisible(true);
    }//GEN-LAST:event_back_buttonActionPerformed

    private void Table_own_booksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_own_booksMouseClicked
        int row= Table_own_books.rowAtPoint(evt.getPoint());
        int col= 0;
        String cod_imprumut = Table_own_books.getValueAt(row,col).toString();   
    
        try{
            conn = Connect.ConnectDb();
            cs = conn.prepareCall("begin returneaza_carte(?); end;");
            cs.setString(1, cod_imprumut);
          
            cs.executeQuery();
            
             Object[] options = {"Da",
                    "Nu"};
            int n = JOptionPane.showOptionDialog(null,
                "Cartea ta a fost returnata! Doresti sa mai returnezi o carte?",
                "Succes!",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
            
            if(n==0)
            {}
            if(n==1)
            {
                UserChoice c = new UserChoice();
                this.dispose();
                c.setVisible(true);
            
            }
            show_my_table();
            
        }catch(SQLException ex){}
    
    }//GEN-LAST:event_Table_own_booksMouseClicked
     String local_cod_personal = Login.cod_personal;
     private void show_my_table(){
    
        try{
            conn = Connect.ConnectDb();
            String sql = "select ic.cod_imprumut as \"Cod Imprumut\",c.nume as \"Nume Opera\",a.nume as \"Nume Autor\",to_char(ic.data_imprumut,'dd-mm-yyyy') as \"Data Imprumut\"\n" +
                         "from imprumutCarte ic,carti c,autori a\n" +
                         "where ic.id_carte = c.id_carte and a.cod_autor = c.cod_autor and id_persoana = ?";
            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
            pst.setString( 1,local_cod_personal);
            rs = (OracleResultSet) pst.executeQuery();
            Table_own_books.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    
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
            java.util.logging.Logger.getLogger(MyBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_own_books;
    private javax.swing.JButton back_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca;

import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author Ervin
 */
public class ImprumutaCarte extends javax.swing.JFrame {
    CallableStatement cs = null;
    Connection conn = null;
    OraclePreparedStatement pst = null;
    OracleResultSet rs = null;

    public ImprumutaCarte() {
        initComponents();
        setResizable(false);
        
        show_table();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_books = new javax.swing.JTable();
        back_button = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Alege carte din lista");

        Table_books.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_books.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_booksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_books);

        back_button.setText("Back");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        jLabel2.setText("Search :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back_button)
                        .addGap(228, 228, 228))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(back_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Table_booksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_booksMouseClicked
        int row= Table_books.rowAtPoint(evt.getPoint());
        int col= 0;
        String cod_carte = Table_books.getValueAt(row,col).toString();
        String local_cod_personal = Login.cod_personal;
    
        try{
            conn = Connect.ConnectDb();
            cs = conn.prepareCall("begin rezerva_carte(?,?); end;");
            cs.setString(1, cod_carte);
            cs.setString(2,local_cod_personal);
          
            cs.executeQuery();
            
             Object[] options = {"Da",
                    "Nu"};
            int n = JOptionPane.showOptionDialog(null,
                "Cartea ta a fost rezervata! Doresti sa mai imprumuti o carte?",
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
            
        }catch(SQLException ex){      
            int cod_err = ex.getErrorCode();
            System.out.println(cod_err);
            String text = ex.getMessage();

            String user_code = text.substring(11, 16);
            System.out.println(user_code);
            
            if(cod_err == 20900) //nu exista
            {
            JOptionPane.showMessageDialog(null,
            "Cartea nu exista!",
            "Avertisment",
            JOptionPane.WARNING_MESSAGE);
                
            }
           if(cod_err == 20500) //deja imprumutata
            {
                JOptionPane.showMessageDialog(null,
                "Ati mai imprumutat o data aceasta carte!",
                "Eroare!",
                JOptionPane.ERROR_MESSAGE);
            
            }
           
           
           if(cod_err == 20100 && local_cod_personal.equals(user_code))//cineva are 3 carti
           {
                    Object[] options = {"Returneaza!" };
                     int n = JOptionPane.showOptionDialog(null,
                     "Cartea ta nu poate fi rezervata! Returneaza o carte mai intai, te rugam!",
                     "Ne pare rau!",
                     
                     JOptionPane.YES_NO_CANCEL_OPTION,
                     JOptionPane.QUESTION_MESSAGE,
                     null,
                     options,
                     options[0]) ;


                 if(n==0)
                 {
                     MyBooks c = new MyBooks();
                     this.dispose();
                     c.setVisible(true);

                 }
           }
           
          
        }
    
    }//GEN-LAST:event_Table_booksMouseClicked

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        this.dispose();
        UserChoice c = new UserChoice();
        c.setVisible(true);
    }//GEN-LAST:event_back_buttonActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        String string_search = searchField.getText();
        
        for (int row = 0 ;row <= Table_books.getRowCount() -1; row++)
          { 
              for(int col = 0; col <= Table_books.getColumnCount() - 1; col++){
                  String string_mic = string_search.toLowerCase();
                  String element = Table_books.getValueAt(row,col).toString();
                  String element_mic = element.toLowerCase();
                  if(string_mic.equals(element_mic) )
                  {
                      Table_books.scrollRectToVisible(Table_books.getCellRect(row,0,true));
                      Table_books.setRowSelectionInterval(row, row);
                      
                      for(int i = 0; i<= Table_books.getColumnCount() - 1; i++){
                          
                          Table_books.getColumnModel().getColumn(i).setCellRenderer(new HighlightRenderer());
                      }
                  }
              }
          }
    }//GEN-LAST:event_searchFieldKeyReleased

    /**
     * @param args the command line arguments
     */
    private void show_table(){
    
        try{
            conn = Connect.ConnectDb();
            String sql = "select c.id_carte as \"Id Carte\", c.nume as \"Nume Opera\",a.nume as \"Nume Autor\", c.gen as \"Gen\",c.editura as \"Editura\",c.limba as \"Limba\" from carti c,autori a where c.cod_autor = a.cod_autor";
            pst = (OraclePreparedStatement) conn.prepareStatement(sql);
            rs = (OracleResultSet) pst.executeQuery();
            Table_books.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
    
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
            java.util.logging.Logger.getLogger(ImprumutaCarte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImprumutaCarte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImprumutaCarte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImprumutaCarte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImprumutaCarte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_books;
    private javax.swing.JButton back_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}

class HighlightRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        // everything as usual
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // added behavior
        if(row == table.getSelectedRow()) {

            // this will customize that kind of border that will be use to highlight a row
            setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.BLACK));
        }

        return this;
    }
}
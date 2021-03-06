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


import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Ervin
 */
public class AddMovie extends javax.swing.JFrame {

    CallableStatement cs = null;
    Connection conn = null;
    OraclePreparedStatement pst = null;
    OracleResultSet rs = null;
    
    public AddMovie() {
        initComponents();
        setResizable(false);
        set_code();
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        field_id_film = new javax.swing.JTextField();
        field_nume = new javax.swing.JTextField();
        field_regizor = new javax.swing.JTextField();
        field_an_aparitie = new javax.swing.JTextField();
        field_nota = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        combo_gen = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Adauga un film la Biblioteca");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Id Film :");

        jLabel3.setText("Nume :");

        jLabel4.setText("Regizor :");

        jLabel5.setText("Gen :");

        jLabel6.setText("An Aparitie : ");

        jLabel7.setText("Nota IMDB (cifra.zec):");

        field_id_film.setEditable(false);

        jButton2.setText("Adauga");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        combo_gen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alege Optiune", "Drama", "Biografie", "Istoric", "Crima", "Comedie", "Muzical", "Romantic", "Razboi", "Sci-Fi", "Fantastic" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(47, 47, 47)
                                .addComponent(jButton1))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(field_id_film)
                                    .addComponent(field_nume)
                                    .addComponent(field_regizor)
                                    .addComponent(field_an_aparitie)
                                    .addComponent(field_nota)
                                    .addComponent(combo_gen, 0, 162, Short.MAX_VALUE))))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(field_id_film, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(field_nume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(field_regizor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(combo_gen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(field_an_aparitie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(field_nota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String string_id_film = field_id_film.getText();
       String string_nume = field_nume.getText();
       String string_regizor = field_regizor.getText();
       String string_gen = (String) combo_gen.getSelectedItem();
       String string_an_aparitie = field_an_aparitie.getText();
       int lungime = string_an_aparitie.length();
       String string_nota = field_nota.getText();
       
       String regex = "^[0-9](\\.[0-9]{1})$";
       
       if(string_id_film.isEmpty() || string_nume.isEmpty() || string_regizor.isEmpty() || string_gen.equals("Alege Optiune") || string_an_aparitie.isEmpty() || string_nota.isEmpty() )
       {
             JOptionPane.showMessageDialog(null,
             "Va rugam sa completati toate campurile!");
       }
        else if(lungime!=4)
        {
            JOptionPane.showMessageDialog(null,
             "Introduceti un an pentru autor din format din 4 cifre!");
        }
        else if(!string_nota.matches(regex))
        {
            JOptionPane.showMessageDialog(null,
             "Introduceti o nota in formatul cifra.zecimala( Ex 6.2 )");
        }
       
       else{
            try{
               conn = Connect.ConnectDb();
               cs = conn.prepareCall("declare v_return varchar2(50);begin v_return := adauga_film(?,?,?,?,?,?); end;");
               cs.setString(1,string_id_film);
               cs.setString(2,string_nume);
               cs.setString(3,string_regizor);
               cs.setString(4,string_gen);
               cs.setString(5,string_an_aparitie);
               cs.setString(6,string_nota);
               
                  cs.executeQuery();
               
               
                 Object[] options = {"Da",
                                "Nu"};
            int n = JOptionPane.showOptionDialog(null,
                "Doresti sa mai adaugi un film?",
                "Succes!",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
            
            if(n==0)
            {
                AddMovie c = new AddMovie();
                c.setVisible(true);
                this.dispose();
                
            }
            
            if(n==1)
            {
                AdminChoice c = new AdminChoice();
                c.setVisible(true);
                this.dispose();
            }
            }
            catch(SQLException ex)
            {ex.printStackTrace();}
                
               
            
        }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AdminChoice c = new AdminChoice();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
     public int get_code()
   {
       int numar = 0;
       try{
           conn = Connect.ConnectDb();
           String sql = "select max(id_film)+1 as \"CURRENT_MAX_ID\" from filme";
           pst = (OraclePreparedStatement) conn.prepareStatement(sql);
           rs = (OracleResultSet) pst.executeQuery();
           while(rs.next())
           {  
                numar =  rs.getInt("CURRENT_MAX_ID");
           }
       }catch(SQLException ex)
       {
           ex.printStackTrace();
           
       }
       return numar;
   }
   
   
   public void set_code(){
   int valoare = get_code();
   
       if(valoare!=0)
       {    String number = Integer.toString(valoare);
            field_id_film.setText(number);
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
            java.util.logging.Logger.getLogger(AddMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddMovie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combo_gen;
    private javax.swing.JTextField field_an_aparitie;
    private javax.swing.JTextField field_id_film;
    private javax.swing.JTextField field_nota;
    private javax.swing.JTextField field_nume;
    private javax.swing.JTextField field_regizor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}

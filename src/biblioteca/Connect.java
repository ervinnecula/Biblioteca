/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Ervin
 */
public class Connect {
    public static Connection ConnectDb(){
    try{
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ora","system","yourpassword");
            return con;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return null;
    }
}



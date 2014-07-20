/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package CryptoHelper_Project;

import java.sql.*;
/**
 *
 * @author Marco
 */
public class DB_Conn {

    
    public static Connection DB_Crypto_Connection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection mysql_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_crypto?username=root&password=rootjdbc:mysql://localhost:3306/db_crypto?zeroDateTimeBehavior=convertToNull","root","root");
        return mysql_con;
        
    }
    
    
    
    public static boolean verifica_Utente(Connection conn,String username,String password) throws SQLException{
        
    
        Statement st = conn.createStatement();
        
        ResultSet result = st.executeQuery("SELECT Username,Password FROM UTENTI WHERE Username='" + username +"' AND Password='" + password + "'");
        
        result.absolute(0);
        
        while(result.next()){
             
            return result.getString("username").equals(username) ? (result.getString("password").equals(password)) : false;
            
        }
        
        return false;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvven.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author quico
 */
public class Test {
    
    @org.junit.Test
    public void test() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
        
        String sql = 
                  "SELECT   tl.nom, tl.nb_logements "
                + "FROM     typelogement tl";
        
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/cvven?zeroDateTimeBehavior=convertToNull", "root", "");        
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery( sql );
        
        List<Object[]> dispos = new ArrayList<>();
        while(rs.next()){
            String nom =rs.getString("nom");
            Long nbLogements = rs.getLong("nb_logements");
            
            System.out.println(nom + " " + nbLogements);
        }
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvven.webservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author quico
 */
@WebService(serviceName = "DispoWebService")
public class DispoWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "dispoParDate")
    public List<LigneDonnee> dispoParDate(@WebParam(name = "date") String dateYYYYMMJJ) throws Exception {

        // Accès base de données        
        String sql
                = "SELECT   tl.nom, tl.nb_logements "
                + "FROM     typelogement tl";

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/cvven?zeroDateTimeBehavior=convertToNull", "root", "");
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        List<LigneDonnee> dispos = new ArrayList<>();
        while (rs.next()) {

            LigneDonnee ligne = new LigneDonnee();

            ligne.setLogement(rs.getString("nom"));
            ligne.setDispo(rs.getLong("nb_logements"));

            dispos.add( ligne );
        }

        return dispos;
    }

}

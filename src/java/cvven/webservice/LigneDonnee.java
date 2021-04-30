/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvven.webservice;

/**
 *
 * @author quico
 */
public class LigneDonnee {
    
    private String logement;
    private Long dispo;

    public String getLogement() {
        return logement;
    }

    public void setLogement(String logement) {
        this.logement = logement;
    }

    public Long getDispo() {
        return dispo;
    }

    public void setDispo(Long dispo) {
        this.dispo = dispo;
    }
}

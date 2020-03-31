/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesParascolaire;

import java.sql.Date;

/**
 *
 * @author hediane
 */
public class parascolaire {
    private int id_parascolaire;
    private String type_parascolaire;
    private String lieu_Parascolaire;
    private Date dateDebut_parascolaire ;
    private Date dateFin_parascolaire ;
    private int id_enfant;

    public parascolaire(int id_parascolaire, String type_parascolaire, String lieu_Parascolaire, Date dateDebut_parascolaire, Date dateFin_parascolaire) {
        this.id_parascolaire = id_parascolaire;
        this.type_parascolaire = type_parascolaire;
        this.lieu_Parascolaire = lieu_Parascolaire;
        this.dateDebut_parascolaire = dateDebut_parascolaire;
        this.dateFin_parascolaire = dateFin_parascolaire;
    }

    public parascolaire(int id_parascolaire, String type_parascolaire, String lieu_Parascolaire, Date dateDebut_parascolaire) {
        this.id_parascolaire = id_parascolaire;
        this.type_parascolaire = type_parascolaire;
        this.lieu_Parascolaire = lieu_Parascolaire;
        this.dateDebut_parascolaire = dateDebut_parascolaire;
    }

    public parascolaire(int id_parascolaire, String type_parascolaire, String lieu_Parascolaire) {
        this.id_parascolaire = id_parascolaire;
        this.type_parascolaire = type_parascolaire;
        this.lieu_Parascolaire = lieu_Parascolaire;
    }

    

  

    public int getId_parascolaire() {
        return id_parascolaire;
    }

    public void setId_parascolaire(int id_parascolaire) {
        this.id_parascolaire = id_parascolaire;
    }

    public String getType_parascolaire() {
        return type_parascolaire;
    }

    public void setType_parascolaire(String type_parascolaire) {
        this.type_parascolaire = type_parascolaire;
    }

    public String getLieu_Parascolaire() {
        return lieu_Parascolaire;
    }

    public void setLieu_Parascolaire(String lieu_Parascolaire) {
        this.lieu_Parascolaire = lieu_Parascolaire;
    }

    public Date getDateDebut_parascolaire() {
        return dateDebut_parascolaire;
    }

    public void setDateDebut_parascolaire(Date dateDebut_parascolaire) {
        this.dateDebut_parascolaire = dateDebut_parascolaire;
    }

    public Date getDateFin_parascolaire() {
        return dateFin_parascolaire;
    }

    public void setDateFin_parascolaire(Date dateFin_parascolaire) {
        this.dateFin_parascolaire = dateFin_parascolaire;
    }

    public parascolaire(String type_parascolaire, String lieu_Parascolaire, Date dateDebut_parascolaire, Date dateFin_parascolaire, int id_enfant) {
        this.type_parascolaire = type_parascolaire;
        this.lieu_Parascolaire = lieu_Parascolaire;
        this.dateDebut_parascolaire = dateDebut_parascolaire;
        this.dateFin_parascolaire = dateFin_parascolaire;
        this.id_enfant = id_enfant;
    }

    public parascolaire(int id_parascolaire, String type_parascolaire, String lieu_Parascolaire, Date dateDebut_parascolaire, Date dateFin_parascolaire, int id_enfant) {
        this.id_parascolaire = id_parascolaire;
        this.type_parascolaire = type_parascolaire;
        this.lieu_Parascolaire = lieu_Parascolaire;
        this.dateDebut_parascolaire = dateDebut_parascolaire;
        this.dateFin_parascolaire = dateFin_parascolaire;
        this.id_enfant = id_enfant;
    }

  
    public int getId_enfant() {
        return id_enfant;
    }

    public void setId_enfant(int id_enfant) {
        this.id_enfant = id_enfant;
    }

    @Override
    public String toString() {
        return "parascolaire{" + "id_parascolaire=" + id_parascolaire + ", type_parascolaire=" + type_parascolaire + ", lieu_Parascolaire=" + lieu_Parascolaire + ", dateDebut_parascolaire=" + dateDebut_parascolaire + ", dateFin_parascolaire=" + dateFin_parascolaire + ", id_enfant=" + id_enfant + '}';
    }


  
    
    
    
    
    
    
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesParascolaire;

import java.util.Date;

/**
 *
 * @author hediane
 */
public class enfant {
    private int id_enfant;
    private String nom_enfant;
    private String prenom_enfant;
    private int age ;
    private Date datenaiss ;
    private String sexe; 

    public int getId_enfant() {
        return id_enfant;
    }

    public void setId_enfant(int id_enfant) {
        this.id_enfant = id_enfant;
    }

    public String getNom_enfant() {
        return nom_enfant;
    }

    public void setNom_enfant(String nom_enfant) {
        this.nom_enfant = nom_enfant;
    }

    public String getPrenom_enfant() {
        return prenom_enfant;
    }

    public void setPrenom_enfant(String prenom_enfant) {
        this.prenom_enfant = prenom_enfant;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public enfant(int id_enfant, String nom_enfant, String prenom_enfant, int age, Date datenaiss, String sexe) {
        this.id_enfant = id_enfant;
        this.nom_enfant = nom_enfant;
        this.prenom_enfant = prenom_enfant;
        this.age = age;
        this.datenaiss = datenaiss;
        this.sexe = sexe;
    }

    public enfant(String nom_enfant, String prenom_enfant, int age, Date datenaiss, String sexe) {
        this.nom_enfant = nom_enfant;
        this.prenom_enfant = prenom_enfant;
        this.age = age;
        this.datenaiss = datenaiss;
        this.sexe = sexe;
    }

    @Override
    public String toString() {
        return "" + "identifiant=" + id_enfant + ", Nom=" + nom_enfant + ", Prenom=" + prenom_enfant + ", age=" + age + ", date naissance=" + datenaiss + ", sexe=" + sexe + "";
    }
    
}

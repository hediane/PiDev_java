/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesParascolaire;

/**
 *
 * @author hediane
 */
public class matieres {
    private int idMatiere;
    private String nomMatiere;
    private String sections;

    public matieres(String nomMatiere, String sections) {
        this.nomMatiere = nomMatiere;
        this.sections = sections;
    }

    public matieres(int idMatiere, String nomMatiere, String sections) {
        this.idMatiere = idMatiere;
        this.nomMatiere = nomMatiere;
        this.sections = sections;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public String getSections() {
        return sections;
    }

    public void setSections(String sections) {
        this.sections = sections;
    }

    public matieres() {
    }
    
    
}

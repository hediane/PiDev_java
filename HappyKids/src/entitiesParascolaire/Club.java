/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;

/**
 *
 * @author macbook
 */
public class Club {
    private int id; 
    private String nomC; 
    private String type;
    private TextAttribute descrip;
    private BufferedImage image;

    public Club() {
    }

    public Club(int id, String nomC, String type, TextAttribute descrip, BufferedImage image) {
        this.id = id;
        this.nomC = nomC;
        this.type = type;
        this.descrip = descrip;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomC() {
        return nomC;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TextAttribute getDescrip() {
        return descrip;
    }

    public void setDescrip(TextAttribute descrip) {
        this.descrip = descrip;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Club{" + "id=" + id + ", nomC=" + nomC + ", type=" + type + ", descrip=" + descrip + ", image=" + image + '}';
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceParascolaire;

import Connection.DataSource;
import entitiesParascolaire.matieres;
import entitiesParascolaire.parascolaire;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hediane
 */
public class matieresService {
      private Connection cnx;
    private Statement st;
    private PreparedStatement pre;
   
    public matieresService(){
    cnx = DataSource.getInstance().getCnx();
    }
  public void ajouterMatiere(matieres e) {
         try {
             PreparedStatement pre=cnx.prepareStatement("INSERT INTO `happkids1`.`matieres` ( `nomMatiere`, `sections`) VALUES ( ?, ?);");
             pre.setString(1, e.getNomMatiere());
             pre.setString(2, e.getSections());
            
             pre.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(matieresService.class.getName()).log(Level.SEVERE, null, ex);
         }
           
    }
  
   public List<matieres> afficherMatiere() {
String req ="select * from matieres";
        List<matieres> list =new ArrayList<>();
         try {
             st=cnx.createStatement();
             ResultSet rs =st.executeQuery(req);
               while(rs.next())
               {  
       
       list.add(new matieres(rs.getInt(1),rs.getString(2),rs.getString(3)));
               
               }
         } catch (SQLException ex) {
             Logger.getLogger(matieresService.class.getName()).log(Level.SEVERE, null, ex);
         }
        return list;    }
   
   
   
   
   public void supprimerMatiere(int id) {
         try {
             PreparedStatement pt = cnx.prepareStatement("delete from matieres where idMatieres =?");
             pt.setInt(1,id);
             pt.execute();
         } catch (SQLException ex) {
             Logger.getLogger(matieresService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
   
   
             public void modifierMatiere(int id_mat, String nom, String section) {
 try {
             PreparedStatement pt = cnx.prepareStatement("update  matieres set nomMatiere = ?,sections = ? where idMatieres = ?");
             pt.setString(1,nom);
             pt.setString(2,section);
             pt.setInt(3, id_mat);
             pt.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(matieresService.class.getName()).log(Level.SEVERE, null, ex);
         }

    }

   
}

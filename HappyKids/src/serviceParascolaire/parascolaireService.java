/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceParascolaire;

import Connection.DataSource;
import entitiesParascolaire.enfant;
import entitiesParascolaire.parascolaire;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hediane
 */
public class parascolaireService implements Iservice <parascolaire>{

     private Connection cnx;
    private Statement st;
    private PreparedStatement pre;
   
    public parascolaireService(){
    cnx = DataSource.getInstance().getCnx();
    }
    
    
    @Override
    public void insert(parascolaire e) {
         try {
             Date dd=new java.sql.Date(e.getDateDebut_parascolaire().getTime());
             Date df=new java.sql.Date(e.getDateFin_parascolaire().getTime());
             PreparedStatement pre=cnx.prepareStatement("INSERT INTO `happkids1`.`parascolaire` ( `id_enfant`,`type_parascolaire`, `lieu_parascolaire`, `dateDebut_parascolaire`,`dateFin_parascolaire`) VALUES ('"+e.getId_enfant()+"','"+e.getType_parascolaire()+"','"+e.getLieu_Parascolaire()+"','"+dd+"','"+df+"');");
             pre.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(parascolaireService.class.getName()).log(Level.SEVERE, null, ex);
         }
           
    }

    

   

    @Override
    public List<parascolaire> displayAll() {
String req ="select * from parascolaire";
        List<parascolaire> list =new ArrayList<>();
         try {
             st=cnx.createStatement();
             ResultSet rs =st.executeQuery(req);
               while(rs.next())
               {  
                
                //java.util.Date df= new java.util.Date(rs.getDate(5).getTime()); 
      list.add(new parascolaire(rs.getInt(1), rs.getString(3), rs.getString(2),rs.getDate(5),rs.getDate(6),rs.getInt(2)));
               
               }
         } catch (SQLException ex) {
             Logger.getLogger(parascolaireService.class.getName()).log(Level.SEVERE, null, ex);
         }
        return list;    }

    @Override
    public void delete(int id) {
         try {
             PreparedStatement pt = cnx.prepareStatement("delete from parascolaire where id_parascolaire =?");
             pt.setInt(1,id);
             pt.execute();
         } catch (SQLException ex) {
             Logger.getLogger(parascolaireService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

  /*  @Override
    public void update(String type, String lieu, String date_debut, String date_fin) {
         try {
             PreparedStatement pt = cnx.prepareStatement("update  parascolaire set type_parascolaire = ?,lieu_parascolaire = ?,date_debutP=?,date_finP=? where id_parascolaire = ?");
             pt.setString(1,type);
             pt.setString(2,lieu);
             pt.setString(3,date_debut);
             pt.setString(4,date_fin);
             pt.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(parascolaireService.class.getName()).log(Level.SEVERE, null, ex);
         }

    }*/

public List<parascolaire> recherche_event(int id) {
            List<parascolaire> arr=new ArrayList<>();
            PreparedStatement pre;
         try {
             pre = cnx.prepareStatement("SELECT * FROM parascolaire WHERE  id_parascolaire LIKE ? ;");
              pre.setInt(1,id);
        ResultSet rs=pre.executeQuery();
        while (rs.next()) {                
                
      
         
        arr.add(new parascolaire(rs.getInt(1), rs.getString(3),rs.getString(4), rs.getDate(5), rs.getDate(6),rs.getInt(2)));
    
     }
         } catch (SQLException ex) {
             Logger.getLogger(parascolaireService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
       
    return arr;
              
    } 
     public List<entitiesParascolaire.enfant> displayAll2() {
       
    List<entitiesParascolaire.enfant> list =new ArrayList<>();
         try {
             PreparedStatement pt =cnx.prepareStatement("select * from enfant ");
               ResultSet res= pt.executeQuery();
             while(res.next())       
             {   
                 entitiesParascolaire.enfant p = new enfant(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4), res.getDate(5),res.getString(6));
                 list.add(p);
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(parascolaireService.class.getName()).log(Level.SEVERE, null, ex);
         }    
       return list;
    }

    @Override
    public void update(int id_para, String type, String lieu, Date date_debut, Date date_fin, int id_enfant) {
try {
             PreparedStatement pt = cnx.prepareStatement("update  parascolaire set id_enfant=? ,type_parascolaire = ?,lieu_parascolaire = ?,dateDebut_parascolaire=?,dateFin_parascolaire=?where id_parascolaire = ?");
            pt.setInt(1, id_enfant);
             pt.setString(2,type);
             pt.setString(3,lieu);
             pt.setDate(4,date_debut);
             pt.setDate(5,date_fin);
             pt.setInt(6, id_para);
             pt.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(parascolaireService.class.getName()).log(Level.SEVERE, null, ex);
         }    }
    

   
public List<parascolaire> trieParDatedebut() {
        String req ="select * from parascolaire ORDER BY dateDebut_parascolaire";
        List<parascolaire> list =new ArrayList<>();
         try {
             st=cnx.createStatement();
             ResultSet rs =st.executeQuery(req);
               while(rs.next())
               {        //java.util.Date dd=new java.util.Date(rs.getDate(4).getTime());
        //java.util.Date  df=new java.util.Date(rs.getDate(5).getTime()); 
        list.add(new parascolaire(rs.getInt(1), rs.getString(3),rs.getString(4), rs.getDate(5), rs.getDate(6),rs.getInt(2)));
               
               }
         } catch (SQLException ex) {
             Logger.getLogger(parascolaireService.class.getName()).log(Level.SEVERE, null, ex);
         }
        return list;
}   }
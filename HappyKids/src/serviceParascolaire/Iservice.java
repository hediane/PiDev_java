/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceParascolaire;


import java.sql.Date;
import java.util.List;

/**
 *
 * @author hediane
 */
public interface Iservice <T>{
    void insert(T e);
    void update(int id_para,String type,String lieu,Date date_debut,Date date_fin,int id_enfant);
    void delete(int id);
    List<T> displayAll();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIA;

import entitiesParascolaire.matieres;
import entitiesParascolaire.parascolaire;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javax.swing.JOptionPane;
import serviceParascolaire.matieresService;
import serviceParascolaire.parascolaireService;

/**
 * FXML Controller class
 *
 * @author hediane
 */
public class CrudMatieresController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private ChoiceBox<String> section;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private TableView<matieres> table_matiere;
    private TableColumn<matieres, String> id_matiere;
    @FXML
    private TableColumn<matieres, String> nomMatiere;
    @FXML
    private TableColumn<matieres, String> sectionMatiere;
    @FXML
    private Label error_name;
    @FXML
    private Label error_section;
    private ComboBox<String> comboRecherche;
    ObservableList<String> listeTypeRecherche = FXCollections.observableArrayList("Tout", "Nom", "section");

  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         comboRecherche.setItems(listeTypeRecherche);
        comboRecherche.setValue("Tout");
 
            
        
        choiceBox();
        afficher();
         nom.textProperty().addListener((observable, oldValue, newValue) ->
    {
        if (!newValue.matches("\\sa-zA-Z*")) {
            nom.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
         nom.textProperty().addListener(new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   if(newValue.isEmpty())
                       error_name.setText("remplir champ type");
                   else if(newValue.length()>25)
                       error_name.setText("Max champ titre 25");
                   else
                error_name.setText("");
                }});
    });  
       nom.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) 
                    {
                    if(nom.getText().length()==0)
                     error_name.setText("remplir champ type");    
                    }
            });
       nom.textProperty().addListener((observable, oldValue, newValue) ->
        {
        if (!newValue.matches("\\sa-zA-Z*")) {
            nom.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
        }
        });    
        
        

    }
    @FXML
    private void ajouterMatiere(ActionEvent event) {
          String ptype = nom.getText();
          String plieu = section.getValue();
       
        matieresService sp = new matieresService();
       matieres  pe =new matieres(ptype, plieu);
        sp.ajouterMatiere(pe);
        afficher();
         nom.clear();
       section.setValue(null);
    }
 private void afficher()
   {
       matieresService sp = new matieresService();
       List parascolaire=sp.afficherMatiere();
       ObservableList et=FXCollections.observableArrayList(parascolaire);
       table_matiere.setItems(et);
     
       nomMatiere.setCellValueFactory(new PropertyValueFactory<>("nomMatiere"));
       sectionMatiere.setCellValueFactory(new PropertyValueFactory<>("sections"));
     
   }
    @FXML
    private void modifierMatiere(ActionEvent event) {
        matieresService cs = new matieresService();
        matieres cc = (matieres)table_matiere.getSelectionModel().getSelectedItem();
        System.out.println(cc);

        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir matiere");
                   }
      
        else{
         
  cs.modifierMatiere(cc.getIdMatiere(), nom.getText(), section.getValue());
       afficher();
        JOptionPane.showMessageDialog(null, "matiere modifier");
        nom.clear();
       section.setValue(null);
        }
    }

    @FXML
    private void supprimerMatiere(ActionEvent event) {
         matieresService cs = new matieresService();
         matieres cc = (matieres)table_matiere.getSelectionModel().getSelectedItem();
        System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir matière");      
        }else{
            cs.supprimerMatiere(cc.getIdMatiere());
           afficher();
           JOptionPane.showMessageDialog(null, "matiere supprimer");
       nom.clear();
       section.setValue(null);
        
    }
    }

    @FXML
    private void choiceBox() {
        
        section.getItems().add("Petite section");
        section.getItems().add("moyenne section");
        section.getItems().add("parascolaire"); }

 





}

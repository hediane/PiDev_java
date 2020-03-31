/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIA;

import entitiesParascolaire.parascolaire;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import serviceParascolaire.parascolaireService;


/**
 * FXML Controller class
 *
 * @author hediane
 */
public class CrudParascolaireController implements Initializable {
    parascolaireService srv = new parascolaireService();

    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private DatePicker datedebutP;
    @FXML
    private Label typePLabel;
    @FXML
    private Label lieuPLabel;
    @FXML
    private Label debutPLabel;
    @FXML
    private Label finPLabel;
    @FXML
    private TableColumn<parascolaire, String> identifiantP;
    @FXML
    private TableColumn<parascolaire, String> typePara;
   
    @FXML
    private TableView<parascolaire> tableParascolaire;
    private TextField typePI;
    @FXML
    private TextField lieuPI;
    @FXML
    private DatePicker datefinP;
    @FXML
    private Label error_type;
    @FXML
    private Label error_lieu;
    @FXML
    private Label error_dateD;
    @FXML
    private Label error_dateF;
    @FXML
    private TextField rechercher;
    @FXML
    private Label enfant;
    @FXML
    private ComboBox<entitiesParascolaire.enfant> combo;
 
    private TableColumn<parascolaire,String> lieu2;
    @FXML
    private TableColumn<parascolaire, String> dateb;
    @FXML
    private TableColumn<?, ?> datef;
    @FXML
    private TableColumn<?, ?> enfant_para;
    @FXML
    private ChoiceBox<String> typee;
    @FXML
    private Button trierParDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher();
        choiceBox();
        parascolaireService cs=new parascolaireService();
     ObservableList<entitiesParascolaire.enfant> enfants = FXCollections.observableArrayList(cs.displayAll2());
     combo.setItems(enfants);
 /**************************************controle de saisie type***************************************************/
/*          typePI.textProperty().addListener((observable, oldValue, newValue) ->
    {
        if (!newValue.matches("\\sa-zA-Z*")) {
            typePI.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
         typePI.textProperty().addListener(new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   if(newValue.isEmpty())
                       error_type.setText("remplir champ type");
                   else if(newValue.length()>25)
                       error_type.setText("Max champ titre 25");
                   else
                error_type.setText("");
                }});
    });  
       typePI.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) 
                    {
                    if(typePI.getText().length()==0)
                     error_type.setText("remplir champ type");    
                    }
            });
       typePI.textProperty().addListener((observable, oldValue, newValue) ->
        {
        if (!newValue.matches("\\sa-zA-Z*")) {
            typePI.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
        }
        });    */
/**************************************controle de saisie lieu***************************************************/
        
  lieuPI.textProperty().addListener(new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   if(newValue.isEmpty())
                       error_lieu.setText("remplir champ type");
                   else if(newValue.length()>25)
                       error_lieu.setText("Max champ titre 25");
                   else
                error_lieu.setText("");
                }});


     lieuPI.setOnMouseClicked(new EventHandler<MouseEvent>()
             
            {
                @Override
                public void handle(MouseEvent event) 
                    {
                    if(lieuPI.getText().length()==0)
                     error_lieu.setText("Remplir champ lieu");  
                    }
                
            });
/****************************************controle de saisie pour date*************************************************/
           datedebutP.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event)
                    {
                    if(datedebutP.getValue()==null)
                     error_dateD.setText("Remplir champ date debut");    
            
                    }
            });
            datedebutP.valueProperty().addListener((ov, oldValue, newValue) -> {
                 if(newValue==null)
                       error_dateD.setText("remplir champ date debut");
                 
                   else
                error_dateD.setText("");
                
            
        });
            datefinP.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event) {
                   
                   
                    if(datefinP.getValue()==null)
                    {error_dateF.setText("remplir champ date fin");    
                    }
                    if(datedebutP.getValue()==null)
                      error_dateD.setText("remplir champ date debut");
                 }    
            });
            datefinP.valueProperty().addListener((ov, oldValue, newValue) -> {
                 if(newValue==null)
                 {
                     error_dateF.setText("remplir champ date fin");
                }
                 else
                 error_dateF.setText("");    
        });
          
          
          
          
    }    

    @FXML
    private void ajouterParascolaire(ActionEvent event) {
        String ptype = typee.getValue();
          String plieu = lieuPI.getText();
       //String dateDebut = datedebutP.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      //String dateFin = datefinP.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate dd=datedebutP.getValue();
        Date datd = java.sql.Date.valueOf(dd);
         LocalDate df=datefinP.getValue();
        Date datf = java.sql.Date.valueOf(df);
        entitiesParascolaire.enfant x =combo.getSelectionModel().getSelectedItem();

      parascolaireService sp = new parascolaireService();
        parascolaire pe =new parascolaire(ptype, plieu,(java.sql.Date) datd,(java.sql.Date) datf, x.getId_enfant());
        if(ptype.isEmpty() || plieu.isEmpty() || datd==null || datf ==null || ptype.isEmpty() && plieu.isEmpty())
        {   
         JOptionPane.showMessageDialog(null, "verifer les champs");   
        }
         else if(datedebutP.getValue().equals(datefinP.getValue()) ||datedebutP.getValue().isAfter(datefinP.getValue()))
        {
         JOptionPane.showMessageDialog(null, "Date debut doit etre < date fin");
        }
         else{
        sp.insert(pe);
         JOptionPane.showMessageDialog(null, "ajout avec succes");
         afficher();
          typee.setValue(null);
         lieuPI.clear();  
         datedebutP.setValue(null);
        datefinP.setValue(null);
      

         }
    }

    @FXML
    private void modifierParascolaire(ActionEvent event) {
        parascolaireService cs = new parascolaireService();
        parascolaire cc = (parascolaire)tableParascolaire.getSelectionModel().getSelectedItem();
        System.out.println(cc);

        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir parascolaire");
                   }
        
        else if(datedebutP.getValue().equals(datefinP.getValue()) ||datedebutP.getValue().isAfter(datefinP.getValue()))
        {
         JOptionPane.showMessageDialog(null, "Date debut doit etre < date fin");
        }
      
        else{
         //String dateDebut = datedebutP.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
           //  String dateFin = datefinP.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
         LocalDate dd=datedebutP.getValue();
        Date datd = java.sql.Date.valueOf(dd);
         LocalDate df=datefinP.getValue();
        Date datf = java.sql.Date.valueOf(df);
          cs.update(cc.getId_parascolaire(), typee.getValue(), lieuPI.getText(),(java.sql.Date)datd,(java.sql.Date)datf,cc.getId_enfant());
       afficher();
        JOptionPane.showMessageDialog(null, "parascolaire modifier");
        typee.setValue(null);
         lieuPI.clear();  
         datedebutP.setValue(null);
        datefinP.setValue(null);
        cc=null;
        }
        
    }
    
/**********************************************supprimer**********************************************************/
    @FXML
    private void supprimerParascolaire(ActionEvent event) {
        
       parascolaireService cs = new parascolaireService();
         parascolaire cc = (parascolaire)tableParascolaire.getSelectionModel().getSelectedItem();
        System.out.println(cc);
        if(cc== null){
            JOptionPane.showMessageDialog(null, "choisir parascolaire");      
        }else{
            cs.delete(cc.getId_parascolaire());
           afficher();
           JOptionPane.showMessageDialog(null, "parascolaire supprimer");
            typePI.clear();
            lieuPI.clear();   
            
        datefinP.setValue(null);
        datedebutP.setValue(null);
        cc=null;
    }
    
    
    }
    
    
    
   
    
   /*****************************afficherr************************************************************************/
  private void afficher()
   {
       parascolaireService sp = new parascolaireService();
       List parascolaire=sp.displayAll();
       ObservableList et=FXCollections.observableArrayList(parascolaire);
       tableParascolaire.setItems(et);
       identifiantP.setCellValueFactory(new PropertyValueFactory<>("type_parascolaire"));
       typePara.setCellValueFactory(new PropertyValueFactory<>("lieu_parascolaire"));
       //lieu2.setCellValueFactory(new PropertyValueFactory<>("lieu_parascolaire"));
       dateb.setCellValueFactory(new PropertyValueFactory<>("dateDebut_parascolaire"));
       datef.setCellValueFactory(new PropertyValueFactory<>("dateFin_parascolaire"));
       enfant_para.setCellValueFactory(new PropertyValueFactory<>("id_enfant"));

       
   }

    @FXML
    private void rechercher(ActionEvent event) {
         parascolaireService cs = new parascolaireService();
        ArrayList AL = (ArrayList) cs.displayAll();
        ObservableList OReservation = FXCollections.observableArrayList(AL);
        FilteredList<parascolaire> filteredData = new FilteredList<>(OReservation, p -> true);
        rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(myObject -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(myObject.getType_parascolaire()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;

                }
                return false;
            });
        });
        SortedList<parascolaire> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableParascolaire.comparatorProperty());
        tableParascolaire.setItems(sortedData);
    }

    @FXML
    private void choiceBox() {
         typee.getItems().add("sortie");
        typee.getItems().add("excursion");
        typee.getItems().add("visite"); }

    @FXML
    private void trierParDate(ActionEvent event) {
        
         parascolaireService sp = new parascolaireService();
       List parascolaire=sp.trieParDatedebut();
       ObservableList et=FXCollections.observableArrayList(parascolaire);
       tableParascolaire.setItems(et);
   identifiantP.setCellValueFactory(new PropertyValueFactory<>("type_parascolaire"));
       typePara.setCellValueFactory(new PropertyValueFactory<>("lieu_parascolaire"));
       //lieu2.setCellValueFactory(new PropertyValueFactory<>("lieu_parascolaire"));
       dateb.setCellValueFactory(new PropertyValueFactory<>("dateDebut_parascolaire"));
       datef.setCellValueFactory(new PropertyValueFactory<>("dateFin_parascolaire"));
       enfant_para.setCellValueFactory(new PropertyValueFactory<>("id_enfant"));
           
           
    }
    

   
    
    
    }
    
   

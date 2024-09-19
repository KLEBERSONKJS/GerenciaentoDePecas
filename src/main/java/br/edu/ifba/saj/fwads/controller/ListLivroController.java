package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.Biblioteca;
import br.edu.ifba.saj.fwads.model.Livro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ListLivroController {
    @FXML
    private TableView<Livro> tblLivro;
    
    @FXML
    private TableColumn<Livro, String> columnTitulo;
    @FXML
    private TableColumn<Livro, String> columnSubTitulo;
    @FXML
    private TableColumn<Livro, Integer> columnISBN;
    @FXML
    private TableColumn<Livro, Integer> columnAutor;


    @FXML
    public void initialize() {
        columnTitulo.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
        columnSubTitulo.setCellValueFactory(new PropertyValueFactory<>("SubTitulo"));
        columnISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        columnAutor.setCellValueFactory(new PropertyValueFactory<>("Autor"));
        tblLivro.setItems(Biblioteca.listaLivros);
    }

    @FXML
    public void showNovoLivro() {
        
        Stage stage = new Stage();            
        Scene scene = new Scene(App.loadFXML("controller/CadLivro.fxml"), 800, 600);            
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL); 
        stage.showAndWait();            
    }

}

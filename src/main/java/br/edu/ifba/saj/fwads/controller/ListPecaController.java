package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.Estoque;
import br.edu.ifba.saj.fwads.model.Peca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ListPecaController {
    @FXML
    private TableView<Peca> tblPeca;
    
    @FXML
    private TableColumn<?, ?> columnCusto;

    @FXML
    private TableColumn<?, ?> columnModelo;

    @FXML
    private TableColumn<?, ?> columnQuantidade;

    @FXML
    private TableColumn<?, ?> columnTipo;

    @FXML
    private TableColumn<?, ?> columnValorVenda;

    @FXML
    private TableView<?> tblLivro;


    @FXML
    public void initialize() {
        columnTitulo.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
        columnSubTitulo.setCellValueFactory(new PropertyValueFactory<>("SubTitulo"));
        columnISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        columnAutor.setCellValueFactory(new PropertyValueFactory<>("Autor"));
        tblPeca.setItems(Estoque.pecas);
    }

    @FXML
    public void showNovoPeca() {
        
        Stage stage = new Stage();            
        Scene scene = new Scene(App.loadFXML("controller/CadPeca.fxml"), 800, 600);            
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL); 
        stage.showAndWait();            
    }

}

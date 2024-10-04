package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.model.Produto;
import br.edu.ifba.saj.fwads.negocio.ControleProdutos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ListProdutoController {
    @FXML
    private TableView<Produto> tblProduto;

    @FXML
    private TableColumn<Produto, String> columnNome;
    @FXML
    private TableColumn<Produto, String> columnEstado;
    @FXML
    private TableColumn<Produto, String> columnQuantidade;
    @FXML
    private TableColumn<Produto, String> columnPreco;


    @FXML
    public void initialize() {
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        columnPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        ControleProdutos controleProdutos = new ControleProdutos();
        tblProduto.setItems(controleProdutos.listaProdutos());
    }


    @FXML
    public void showNovoProduto() {
        
        Stage stage = new Stage();            
        Scene scene = new Scene(App.loadFXML("controller/CadProduto.fxml"), 178, 225);            
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL); 
        stage.showAndWait();            
    }

    @FXML
    void showAtualizarProduto(ActionEvent event) {
        Stage stage = new Stage();            
        Scene scene = new Scene(App.loadFXML("controller/AttProduto.fxml"), 178, 225);            
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL); 
        stage.showAndWait(); 
    }


    @FXML
    void showVenderProduto(ActionEvent event) {
        Stage stage = new Stage();            
        Scene scene = new Scene(App.loadFXML("controller/VendProduto.fxml"), 178, 225);            
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL); 
        stage.showAndWait(); 
    }
    
    @FXML
    void showRemoverProduto(ActionEvent event) {
        Stage stage = new Stage();            
        Scene scene = new Scene(App.loadFXML("controller/RemProduto.fxml"), 178, 225);            
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL); 
        stage.showAndWait(); 
    }
}

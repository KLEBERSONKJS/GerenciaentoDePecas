package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Estoque;
import br.edu.ifba.saj.fwads.model.Marca;
import br.edu.ifba.saj.fwads.model.Tipo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.util.StringConverter;

public class CadPeca {

    @FXML
    private Button addPeca;

    @FXML
    private Label lbAutor;

    @FXML
    private Label lbISBN;

    @FXML
    private Label lbISBN1;

    @FXML
    private Label lbSubTitulo;

    @FXML
    private Label lbSubTitulo1;

    @FXML
    private Label lbTitulo;

    @FXML
    private ChoiceBox<Marca> slMarca;

    @FXML
    private ChoiceBox<Tipo> slTipo;

    @FXML
    private TextField txCusto;

    @FXML
    private TextField txModelo;

    @FXML
    private TextField txQuantidade;

    @FXML
    private TextField txValorVenda;

    @FXML
    void limparTela(ActionEvent event) {

    }

    @FXML
    void addPeca(ActionEvent event) {
        try {
            String scusto = txCusto.getText();
            double custo = Double.parseDouble(scusto);
            String squantidade = txQuantidade.getText();
            int quantidade = Integer.parseInt(squantidade);
            String svenda = txValorVenda.getText();
            double valorVenda = Double.parseDouble(scusto);
            
            Estoque.novaPeca(txModelo.getText(),slTipo.getSelectionModel().getSelectedItem(),slMarca.getSelectionModel().getSelectedItem(),custo, 
            valorVenda, quantidade);

            
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, insira um número válido.");
        }
        //limparTela();

    }

    @FXML
    private void handleConvertButtonAction() {
        
    }

    @FXML
    private void initialize() {
        slMarca.setConverter(new StringConverter<Marca>() {

            @Override
            public Marca fromString(String stringMarca) {
                return Estoque.marcas
                        .stream()
                        .filter(marca -> stringMarca.equals(marca.getNome())) // Supondo que Marca tenha um método
                                                                              // getNome()
                        .findAny()
                        .orElse(null);
            }

            @Override
            public String toString(Marca marca) {
                return marca != null ? marca.getNome() : ""; // Supondo que Marca tenha um método getNome()
            }
        });



        slTipo.setConverter(new StringConverter<Tipo>() {

            @Override
            public Tipo fromString(String stringtipo) {
                return Estoque.tipos
                        .stream()
                        .filter(tipo -> stringtipo.equals(tipo.getNome())) 
                        .findAny()
                        .orElse(null);
            }

            @Override
            public String toString(Tipo tipo) {
                return tipo != null ? tipo.getNome() : ""; 
            }
        });
    }

    

    // @FXML
    // private void limparTela() {
    //     txTitulo.setText("");
    //     txSubTitulo.setText("");
    //     txISBN.setText("");
    //     // Todo REVER
    //     slAutor.setSelectionModel(null);
    // }

    // private void carregarListaAutores() {
    //     slAutor.setItems(Biblioteca.listaAutores);
    // }

}

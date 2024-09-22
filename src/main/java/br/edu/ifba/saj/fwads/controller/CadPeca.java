package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Estoque;
import br.edu.ifba.saj.fwads.model.Marca;
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
        Estoque.novaPeca(slMarca.getSelectionModel().getSelectedItem(), slTipo.getSelectionModel().getSelectedItem(),
                txModelo.getText(), txCusto.getText(), txValorVenda.getText(), txQuantidade.getText());
        Estoque.novaPeca(null, null, null, 0, 0, 0);
        limparTela();

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
    }

    @FXML
    private void initialize() {
        slTipo.setConverter(new StringConverter<Tipo>() {

            @Override
            public Tipo fromString(String tipo) {
                return Estoque.marcas
                        .stream()
                        .filter(marca -> stringMarca.equals(marca.getNome())) 
                        .findAny()
                        .orElse(null);
            }

            @Override
            public String toString(Tipo tipo) {
                return tipo != null ? tipo.getNome() : ""; 
            }
        });
    }

    @FXML
    private void limparTela() {
        txTitulo.setText("");
        txSubTitulo.setText("");
        txISBN.setText("");
        // Todo REVER
        slAutor.setSelectionModel(null);
    }

    private void carregarListaAutores() {
        slAutor.setItems(Biblioteca.listaAutores);
    }

}

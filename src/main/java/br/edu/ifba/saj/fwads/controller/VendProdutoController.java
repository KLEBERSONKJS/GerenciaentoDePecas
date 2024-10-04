package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.exception.EstoqueInsuficienteException;
import br.edu.ifba.saj.fwads.model.Produto;
import br.edu.ifba.saj.fwads.negocio.ControleProdutos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class VendProdutoController {

    @FXML
    private ChoiceBox<Produto> slProduto;

    @FXML
    private TextField txQuantidade;

    @FXML
    private Label txValor;


    @FXML
    void venderProduto(ActionEvent event) {
        try {
            String sQuantidade = txQuantidade.getText();
            int quantidade = Integer.parseInt(sQuantidade); 
           try {
            ControleProdutos controleProdutos = new ControleProdutos();
            txValor.setText(" R$: " + controleProdutos.venderProduto(slProduto.getSelectionModel().getSelectedItem(), quantidade));
            new Alert(AlertType.CONFIRMATION, "Venda Concluída").showAndWait();
            limparTela();
           } catch (EstoqueInsuficienteException e) {
                new Alert(AlertType.ERROR, e.getMessage()).showAndWait();
           } 
        } catch (Exception e) {
            new Alert(AlertType.ERROR, e.getMessage()).showAndWait();
        }
    }

    @FXML
    private void initialize() {
        slProduto.setConverter(new StringConverter<Produto>() {
            @Override
            public String toString(Produto obj) {
                if (obj != null) {
                    return obj.getNome() + " Qnt: " + obj.getQuantidade() + " R$: " + obj.getPreco();
                }
                return "";
            }

            @Override
            public Produto fromString(String stringProduto) {
                ControleProdutos controleProdutos = new ControleProdutos();
                return controleProdutos.listaProdutos()
                        .stream()
                        .filter(produto -> stringProduto
                                .equals(produto.getNome() + ":" + produto.getPreco() + ":" + produto.getPreco()))
                        .findAny()
                        .orElse(null);
            }
        });

        carregarListaProdutos();
    }

    @FXML
    private void limparTela() {
        txQuantidade.setText("");
        txValor.setText("");
        slProduto.getSelectionModel().clearSelection();
    }

    @FXML
    void limparCampos(ActionEvent event) {
        txQuantidade.setText("");
        txValor.setText("");
        slProduto.getSelectionModel().clearSelection();
    }

    private void carregarListaProdutos() {
        ControleProdutos controleProdutos = new ControleProdutos();
        slProduto.setItems(controleProdutos.listaProdutos());
    }

}

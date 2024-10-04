package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.Produto;
import br.edu.ifba.saj.fwads.negocio.ControleProdutos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Alert.AlertType;
import javafx.util.StringConverter;

public class RemProdutoController {

    @FXML
    private ChoiceBox<Produto> slProduto;

    @FXML
    void removerProduto(ActionEvent event) {
        ControleProdutos controleProdutos = new ControleProdutos();
        Produto removido = controleProdutos.removerProduto(slProduto.getSelectionModel().getSelectedItem());
        new Alert(AlertType.CONFIRMATION,
                "Produto " +  removido.getNome()
                        + " Removido do Estoque")
                .showAndWait();
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

    private void carregarListaProdutos() {
        ControleProdutos controleProdutos = new ControleProdutos();
        slProduto.setItems(controleProdutos.listaProdutos());
    }

    @FXML
    void limparCampos(ActionEvent event) {
        slProduto.getSelectionModel().clearSelection();
    }

}

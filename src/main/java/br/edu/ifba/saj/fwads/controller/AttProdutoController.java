package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Estoque;
import br.edu.ifba.saj.fwads.model.Produto;
import br.edu.ifba.saj.fwads.negocio.ControleProdutos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class AttProdutoController {

    @FXML
    private ChoiceBox<Produto> slProduto;

    @FXML
    private TextField txPreco;

    @FXML
    private TextField txQuantidade;

    @FXML
    void atualizarProduto(ActionEvent event) {
        try {
            String sPreco = txPreco.getText();
            Double preco = Double.parseDouble(sPreco);
            String sQuantidade = txQuantidade.getText();
            int quantidade = Integer.parseInt(sQuantidade);

            try {
                ControleProdutos controleProdutos = new ControleProdutos();
                controleProdutos.atualizarProduto(slProduto.getSelectionModel().getSelectedItem(), quantidade, preco);
                new Alert(AlertType.CONFIRMATION,
                        "Produto " + slProduto.getSelectionModel().getSelectedItem().getNome() + " Atualizado")
                        .showAndWait();
                limparTela();
            } catch (Exception e) {
                new Alert(AlertType.ERROR, e.getMessage()).showAndWait();
            }

        } catch (Exception e) {
            new Alert(AlertType.ERROR, "Apenas Números nos Campos Quantidade e Preço").showAndWait();
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
                return Estoque.produtos
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
    void limparCampos(ActionEvent event) {

    }

    @FXML
    private void limparTela() {
        txPreco.setText("");
        txQuantidade.setText("");
        slProduto.getSelectionModel().clearSelection();
    }

    private void carregarListaProdutos() {
        ControleProdutos controleProdutos = new ControleProdutos();
        slProduto.setItems(controleProdutos.listaProdutos());
    }
}
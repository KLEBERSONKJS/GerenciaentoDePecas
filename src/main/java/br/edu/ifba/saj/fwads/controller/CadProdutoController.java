package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.exception.ProdutoInvalidoException;
import br.edu.ifba.saj.fwads.model.Produto;
import br.edu.ifba.saj.fwads.negocio.ControleProdutos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadProdutoController {
    @FXML
    private TextField txNome;
    @FXML
    private TextField txQuantidade;
    @FXML
    private TextField txPreco;

    @FXML
    private void addProduto() {
        try {

            //CONVERSAO STRING PARA INT/DOUBLE
            String squantidade = txQuantidade.getText();
            int quantidade = Integer.parseInt(squantidade);
            String sPreco = txPreco.getText();
            double preco = Double.parseDouble(sPreco);
            
            try {
            ControleProdutos controleProdutos = new ControleProdutos();
            Produto novoProduto = controleProdutos.addProduto(txNome.getText(), quantidade, preco);
            new Alert(AlertType.INFORMATION, 
            "Adicionando Produto: "+ novoProduto.getNome()).showAndWait();
            limparTela();
            } catch (ProdutoInvalidoException e) {
                new Alert(AlertType.ERROR, e.getMessage()).showAndWait();
                limparTela();
            }
            

        } catch (NumberFormatException e) {
            new Alert(AlertType.INFORMATION, "Apenas Números nos Campos Quantidade e Preço").showAndWait();
            limpar();
        }
       
    }

    
    @FXML
    void limparCampos(ActionEvent event) {
        txNome.setText("");
        txQuantidade.setText("");
        txPreco.setText("");
    }
    
    @FXML
    private void limparTela() {
        txNome.setText("");
        txQuantidade.setText("");
        txPreco.setText("");
    }

    @FXML
    private void limpar() {
        txQuantidade.setText("");
        txPreco.setText("");
    }

}

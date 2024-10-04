package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.Venda;
import br.edu.ifba.saj.fwads.negocio.Relatorio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RelatorioController {

    @FXML
    private TableView<Venda> tblVenda;

    @FXML
    private TableColumn<Venda, Integer> columnId;

    @FXML
    private TableColumn<Venda, String> columnProduto;

    @FXML
    private TableColumn<Venda, String> columnQuantidade;

    @FXML
    private TableColumn<Venda, String> columnPreco;
    
    @FXML
    private Label txQuantidadeItens;

    @FXML
    private Label txQntProdutos;

    @FXML
    private Label txValorBruto;

    @FXML
    private Label txQuantidadeVendas;

    @FXML
    private Label txTotalVendas;



    @FXML
    public void initialize() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnProduto.setCellValueFactory(new PropertyValueFactory<>("nproduto"));
        columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        columnPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tblVenda.setItems(Relatorio.vendas);
    }

    @FXML
    void gerarRelatorio(ActionEvent event) {
        Relatorio relatorio = new Relatorio();
        txQuantidadeVendas.setText("" + relatorio.qntVendas());
        txTotalVendas.setText(""+ relatorio.valorDeVendas());
        txQntProdutos.setText("" + relatorio.totalItens());
        txQuantidadeItens.setText("" + relatorio.getQuantidadeItens());
        txValorBruto.setText("" + relatorio.getValorBruto());
    }

    @FXML
    void limparCampos(ActionEvent event) {
        txQuantidadeItens.setText("");
        txValorBruto.setText("");
    }

}

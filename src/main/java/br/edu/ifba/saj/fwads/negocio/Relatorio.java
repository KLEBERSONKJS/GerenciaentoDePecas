package br.edu.ifba.saj.fwads.negocio;

import br.edu.ifba.saj.fwads.Estoque;
import br.edu.ifba.saj.fwads.model.Produto;
import br.edu.ifba.saj.fwads.model.Venda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Relatorio {

    public static ObservableList<Venda> vendas = FXCollections.observableArrayList();

    public int getQuantidadeItens() {
        int totalItens = 0;
        for (Produto p : Estoque.produtos) {
           totalItens =  p.getQuantidade();
        }
        return totalItens;
    }

    public int totalItens(){
        return Estoque.produtos.size();
    }

    public double getValorBruto() {
        double valorBruto = 0;
        for (Produto p : Estoque.produtos) {
            valorBruto = valorBruto + p.getQuantidade() * p.getPreco();
        }
        return valorBruto;
    }
    
    public Venda vender(Produto produto,int quantidade ){
        Venda novaVenda = new Venda(produto, quantidade);
        vendas.add(novaVenda);
        return novaVenda;
    }

    public int qntVendas(){
        return vendas.size();
    }

    public double valorDeVendas(){
        double valorTotal = 0;
        for (Venda venda : vendas) {
           valorTotal = valorTotal + venda.getPreco(); 
        }
        return valorTotal;
    }
}

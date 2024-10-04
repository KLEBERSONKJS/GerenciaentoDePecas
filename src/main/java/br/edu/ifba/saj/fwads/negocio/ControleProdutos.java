package br.edu.ifba.saj.fwads.negocio;

import java.util.Collections;

import br.edu.ifba.saj.fwads.Estoque;
import br.edu.ifba.saj.fwads.exception.EstoqueInsuficienteException;
import br.edu.ifba.saj.fwads.exception.ProdutoInvalidoException;
import br.edu.ifba.saj.fwads.model.Produto;
import javafx.collections.ObservableList;

public class ControleProdutos {

    
    public Produto addProduto(String nome, int quantidade, double preco) throws ProdutoInvalidoException {

        if (preco > 0 && quantidade > 0) {

            // Verificao para produtos repitidos
            for (Produto produto : Estoque.produtos) {
                if (produto.getNome().equals(nome)) {
                    throw new ProdutoInvalidoException("Este produto já existe.");
                }
            }

            Produto novoProduto = new Produto(nome, quantidade, preco);
            Estoque.produtos.add(novoProduto);
            return novoProduto;
        } else {
            throw new ProdutoInvalidoException("Quantidade ou Preço invalido.");
        }

    }

    public void atualizarProduto(Produto produto, int quantidade, double preco) throws ProdutoInvalidoException {
        if (quantidade > 0 && preco > 0) {
            produto.setPreco(preco);
            produto.setQuantidade(quantidade);
        } else {
            throw new ProdutoInvalidoException("Quantidade ou Preço invalido. Apenas valores maiores que Zero.");
        }
    }

    public double venderProduto(Produto produto, int quantidade) throws EstoqueInsuficienteException, ProdutoInvalidoException {

        if (produto.getQuantidade() >= quantidade && produto.getQuantidade() > 0) {
            if (quantidade > 0) {
                produto.setQuantidade(produto.getQuantidade() - quantidade);
                Relatorio relatorio = new Relatorio();
                relatorio.vender(produto, quantidade);
                return quantidade * produto.getPreco();
            } else {
                throw new ProdutoInvalidoException("Quantidade ou Preço invalido. Apenas valores maiores que Zero.");
            }

        } else {
            throw new EstoqueInsuficienteException("Quantidade índisponivel ou não há estoque para o produto.");
        }

    }


    public ObservableList<Produto> listaProdutos() {
        ObservableList<Produto> ordenados = Estoque.produtos;
        Collections.sort(ordenados);
        return ordenados;
    }

    public Produto removerProduto(Produto produto) {
        Produto removido = produto;
        Estoque.produtos.remove(produto);
        return removido;
    }

}

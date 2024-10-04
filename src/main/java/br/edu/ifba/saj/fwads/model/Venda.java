package br.edu.ifba.saj.fwads.model;

public class Venda {
    private Produto produto;
    private int quantidade;
    private double preco;
    private int id;
    private static int contador = 1;

    
    public Venda(Produto produto,int quantidade) {
        id = contador++;
        this.quantidade = quantidade;
        this.produto = produto;
        this.preco = produto.getPreco() * quantidade;
    }

    public int getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public String getNproduto(){
        return produto.getNome();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((produto == null) ? 0 : produto.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Venda other = (Venda) obj;
        if (produto == null) {
            if (other.produto != null)
                return false;
        } else if (!produto.equals(other.produto))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Venda [produto=" + produto + "]";
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }
    

    
    
}

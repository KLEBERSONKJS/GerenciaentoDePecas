package br.edu.ifba.saj.fwads.model;

public class Produto implements Comparable<Produto> {

    private String nome;
    private int quantidade;
    private double preco;
    private String estado;

    @Override
    public int compareTo(Produto p) {
        return nome.compareTo(p.getNome());
    }

    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + quantidade;
        long temp;
        temp = Double.doubleToLongBits(preco);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
        Produto other = (Produto) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (quantidade != other.quantidade)
            return false;
        if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
            return false;
        if (estado == null) {
            if (other.estado != null)
                return false;
        } else if (!estado.equals(other.estado))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", Quantidade=" + quantidade + ", preco=" + preco + ", estado=" + estado + "]";
    }

    public void setQuantidade(int Quantidade) {
        this.quantidade = Quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        estado = (this.getQuantidade() < 1) ? "SEM ESTOQUE" : (this.getQuantidade() > 3 ? "OTIMO ESTOQUE" : "ESTOQUE BAIXO");
        return estado;
    }

    
}

package br.edu.ifba.saj.fwads.model;

import java.util.Comparator;

public class  Peca implements Comparable<Peca>{
    
    private String modelo;
    private Tipo tipo;
    private Marca marca;
    private double custo;
    private double valorVenda;
    private int qnt;

    
    
  
    
    public Peca(String modelo, Tipo tipo, Marca marca, double custo, double valorVenda, int qnt) {
        this.modelo = modelo;
        this.tipo = tipo;
        this.marca = marca;
        this.custo = custo;
        this.valorVenda = valorVenda;
        this.qnt = qnt;
    }


    public Peca(){
        this.marca = null;
        this.tipo = null;
        this.modelo = null;
        this.custo = 0;
        this.valorVenda = 0;
        this.qnt = 0; 
    }
    

    //COMPARA STRINGS
    @Override
    public int compareTo(Peca p) {
        return  modelo.compareTo(p.getModelo());
    }
   
    
    
    
    public Marca getMarca() {
        return marca;
    }







    public void setMarca(Marca marca) {
        this.marca = marca;
    }



    public Tipo getTipo() {
        return tipo;
    }



    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }



    public String getModelo() {
        return modelo;
    }



    public void setModelo(String modelo) {
        this.modelo = modelo;
    }



    public double getCusto() {
        return custo;
    }



    public void setCusto(double custo) {
        this.custo = custo;
    }



    public double getValorVenda() {
        return valorVenda;
    }



    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }



    public int getQnt() {
        return qnt;
    }



    public void setQnt(int qnt) {
        this.qnt = qnt;
    }





    @Override
    public String toString() {
        return "Peca [marca=" + marca + ", tipo=" + tipo + ", modelo=" + modelo + ", custo=" + custo + ", valorVenda="
                + valorVenda + ", qnt=" + qnt + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((marca == null) ? 0 : marca.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        long temp;
        temp = Double.doubleToLongBits(custo);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(valorVenda);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + qnt;
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
        Peca other = (Peca) obj;
        if (marca == null) {
            if (other.marca != null)
                return false;
        } else if (!marca.equals(other.marca))
            return false;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (Double.doubleToLongBits(custo) != Double.doubleToLongBits(other.custo))
            return false;
        if (Double.doubleToLongBits(valorVenda) != Double.doubleToLongBits(other.valorVenda))
            return false;
        if (qnt != other.qnt)
            return false;
        return true;
    }

   



    
    
    
}

package br.edu.ifba.saj.fwads.model;

import java.util.ArrayList;

public class Logista {

    private String nome;
    private double CreditorDevedor;
    public ArrayList<Peca> pecasCompradas;
    
    
    
    public Logista(String nome) {
        this.nome = nome;
        CreditorDevedor = 0;
        this.pecasCompradas = new ArrayList<>();

    }



    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public double getCreditorDevedor() {
        return CreditorDevedor;
    }



    public void setCreditorDevedor(double creditorDevedor) {
        CreditorDevedor = creditorDevedor;
    }



    public ArrayList<Peca> getPecasCompradas() {
        return pecasCompradas;
    }



    public void setPecasCompradas(ArrayList<Peca> pecasCompradas) {
        this.pecasCompradas = pecasCompradas;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        long temp;
        temp = Double.doubleToLongBits(CreditorDevedor);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((pecasCompradas == null) ? 0 : pecasCompradas.hashCode());
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
        Logista other = (Logista) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (Double.doubleToLongBits(CreditorDevedor) != Double.doubleToLongBits(other.CreditorDevedor))
            return false;
        if (pecasCompradas == null) {
            if (other.pecasCompradas != null)
                return false;
        } else if (!pecasCompradas.equals(other.pecasCompradas))
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "Logista [nome=" + nome + ", CreditorDevedor=" + CreditorDevedor + "]";
    }

    
    

}

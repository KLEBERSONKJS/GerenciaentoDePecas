package br.edu.ifba.saj.fwads.model;

public class Marca {

    private String nome;

    public Marca(String nome) {
        this.nome = nome;
    }
    
    //Marca samsung = new Marca("Samsung");
    //Marca lg = new Marca("LG");
    //Marca motorola = new Marca("Motorola");
    //Marca xiaomi = new Marca("Xiaomi");

    public Marca cadastrarMarca(String nome){
        Marca novaMarca = new Marca(nome);
        return novaMarca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
        Marca other = (Marca) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Marca [nome=" + nome + "]";
    }
    
    
}

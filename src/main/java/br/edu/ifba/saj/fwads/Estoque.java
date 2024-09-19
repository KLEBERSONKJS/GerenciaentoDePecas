package br.edu.ifba.saj.fwads;

import br.edu.ifba.saj.fwads.model.Logista;
import br.edu.ifba.saj.fwads.model.Marca;
import br.edu.ifba.saj.fwads.model.Peca;
import br.edu.ifba.saj.fwads.model.Tipo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Estoque {
    
    public static ObservableList<Peca> pecas = FXCollections.observableArrayList(); 
    public static ObservableList<Logista> logitas = FXCollections.observableArrayList(); 
    public static ObservableList<Marca> marcas = FXCollections.observableArrayList(); 
    


    public void vender(Peca peca, Logista logista , int valor, int qnt){
        peca.setQnt(peca.getQnt() - 1);

    }


    public static void novaPeca(Marca marca, Tipo tipo, String modelo, double custo, double valorVenda, int qnt){
        Peca novaPeca = new Peca( marca, tipo, modelo, custo, valorVenda, qnt);
        pecas.add(novaPeca);
        
    }

    public void setQuantidadepcs(Peca peca, int adicional){
        peca.setQnt(peca.getQnt() + adicional);
    }

    public static void novoLogista(String nome){
        Logista novoLogista = new Logista(nome);
        logitas.add(novoLogista);
    }


    public static ObservableList<Peca> getPecas() {
        return pecas;
    }


    public static ObservableList<Logista> getLogitas() {
        return logitas;
    }

    public static void novaMarca(String nome){
        Marca novMarca = new Marca(nome);
        marcas.add(novMarca);
    }
}

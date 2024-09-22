package br.edu.ifba.saj.fwads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import br.edu.ifba.saj.fwads.model.Logista;
import br.edu.ifba.saj.fwads.model.Marca;
import br.edu.ifba.saj.fwads.model.Peca;
import br.edu.ifba.saj.fwads.model.Tipo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

public class Estoque {
    
    public static ObservableList<Peca> pecas = FXCollections.observableArrayList(); 
    public static ObservableList<Logista> logitas = FXCollections.observableArrayList(); 
    public static ObservableList<Marca> marcas = FXCollections.observableArrayList(); 
    public static ObservableList<Tipo> tipos = FXCollections.observableArrayList();

    
    
    //REGISTRAR MARCA DE PECA
    public static void novaMarca(String nome){
        marcas.add(new Marca(nome));
    }
    
    //CADASTRAR UMA PECA
    public static void novaPeca(Marca marca, Tipo tipo, String modelo, double custo, double valorVenda, int qnt){
        pecas.add(new Peca( marca, tipo, modelo, custo, valorVenda, qnt));
        
    }

    //CADASTRAR UM LOGISTA
    public static void novoLogista(String nome){
        logitas.add(new Logista(nome));
    }

    //CADASTRAR UM NOVO TIPO DE PECA
    public static void novoTipo(String nome){
        tipos.add(new Tipo(nome));
    } 

    //QUANTIDADE DE MERCADORIA
    public static int qntPecas(){
        int qntPecas = 0;
        for (Peca p : pecas) {
            qntPecas =+ p.getQnt();
        }
        return qntPecas;
    }

    //QUANTIDADE DE PECAS
    public static int qntModelos(){
        return pecas.size(); 
    }

    //VENDER PECA DESCONTA DO ESTOQUE E ADD AO LOGISTA COMPRADOR
    public void vender(Peca peca, Logista logista , int valor, int qnt){
        peca.setQnt(peca.getQnt() - 1);

    }


    //ACRESENTAR PECAS A UM ITEM JA EXISTENTE
    public void setQuantidadepcs(Peca peca, int adicional){
        peca.setQnt(peca.getQnt() + adicional);
    }


    //TODAS AS PECAS DA LISTA
    public static ObservableList<Peca> getPecas() {
        return pecas;
    }

    //TODOS OS LOGISTAS
    public static ObservableList<Logista> getLogitas() {
        return logitas;
    }

    //RETORNA A PECA PESQUISADA
    public static Peca pesquisar(String nome){
        Peca pesquisada = null;
        if(pecas.isEmpty()){
            for (Peca p : pecas) {
                if(p.getModelo().equalsIgnoreCase(nome)){
                break;
                }
            }
        }    
        return pesquisada;
    }

    //LISTA DE PECAS ORDENADAS POR NOME
    public static void pecasOrdenadas(){
        ArrayList<Peca> ordenadas = new ArrayList<>(pecas);
        Collections.sort(ordenadas);
        System.out.println(ordenadas);
    }

    public static void main(String[] args) {
        Marca n1 = new Marca("Lg");
        Marca n2 = new Marca("Samsung");
        Tipo t1 = new Tipo("tela");
        Estoque.marcas.add(n1);
        Estoque.marcas.add(n2);
        Estoque.novaPeca(n1, t1, "A",45,65,10);
        Estoque.novaPeca(n1, t1, "C",45,65,10);
        Estoque.novaPeca(n2, t1, "B",45,65,10);
        //System.out.println(Estoque.getPecas());
        Estoque.pecasOrdenadas();
    }

}

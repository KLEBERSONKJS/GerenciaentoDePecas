package br.edu.ifba.saj.fwads;

import br.edu.ifba.saj.fwads.model.Autor;
import br.edu.ifba.saj.fwads.model.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Biblioteca {
    public static ObservableList<Autor> listaAutores = FXCollections.observableArrayList();
    public static ObservableList<Livro> listaLivros = FXCollections.observableArrayList();
   
}

package br.edu.ifba.saj.fwads;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BancoDeUsuarios {

    public static ArrayList<Usuario> listaUsuarios;
    
    static{
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("admin", "admin"));
        listaUsuarios.add(new Usuario("Kleberson", "12345"));
    }
    

    public static Usuario autenticar(String login, String senha) throws AutenticacaoInvalidaException{

        for (Usuario usuario : listaUsuarios) {        
            if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)){
                return usuario;
            }      
        }
        throw new AutenticacaoInvalidaException(login);
    }



    

    

        
        
    

}
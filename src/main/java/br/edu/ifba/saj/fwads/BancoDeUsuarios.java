package br.edu.ifba.saj.fwads;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BancoDeUsuarios {

    public static ArrayList<Usuario> listaUsuarios;
    
    static{
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("admin", "admin", "seila1@algumacoisa.com"));
        listaUsuarios.add(new Usuario("Kleberson", "12345", "seila2@algumacoisa.com"));
        listaUsuarios.add(new Usuario("Suellen", "54321", "seila3@algumacoisa.com"));
        listaUsuarios.add(new Usuario("Carlos", "431343", "seila4@algumacoisa.com"));
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
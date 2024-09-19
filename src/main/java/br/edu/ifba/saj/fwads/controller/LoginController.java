/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */

package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.AutenticacaoInvalidaException;
import br.edu.ifba.saj.fwads.BancoDeUsuarios;
import br.edu.ifba.saj.fwads.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LoginController {

    @FXML // fx:id="txSenha"
    private PasswordField txSenha; // Value injected by FXMLLoader

    @FXML // fx:id="txUsuario"
    private TextField txUsuario; // Value injected by FXMLLoader

    @FXML
    void entrar(ActionEvent event) throws AutenticacaoInvalidaException {

        try{
            Usuario usuario = BancoDeUsuarios.autenticar(txUsuario.getText(), txSenha.getText());
            new Alert(AlertType.INFORMATION, "Seja Bem Vindo " + usuario.getLogin()).show();
            App.setRoot("controller/Master.fxml");
            MasterController masterController = (MasterController)App.getController();
            masterController.setEmailUsuarioLogado(usuario.getEmail());
        }
        catch(AutenticacaoInvalidaException e){
            new Alert(AlertType.ERROR, "Usuário ou senha inválidos").show();
        }
        

            
        }
    
    

    @FXML
    void limparCampos(ActionEvent event) {
        txUsuario.setText("");
        txSenha.setText("");
    }

}

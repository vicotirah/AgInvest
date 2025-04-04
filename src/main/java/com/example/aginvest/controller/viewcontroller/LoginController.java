package com.example.aginvest.controller.viewcontroller;


import com.example.aginvest.controller.user.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;


public class LoginController {
    @FXML
    private Button fazerLogin;


    @FXML
    private TextField emailFieldLogin;


    @FXML
    private TextField senhaFielLogin;


    public void realizarLogin(){
        try {
            String email = emailFieldLogin.getText().trim();
            String senha = senhaFielLogin.getText().trim();


            if (email.isEmpty() || senha.isEmpty()) {
                // Mostrar alerta para o usuário
                System.err.println("Email e senha são obrigatórios!");
                return;
            }


            UserController userLogin = new UserController();
            String loginRealizado = userLogin.login(email, senha);


            if (loginRealizado != null) {

                carregarTelaPrincipal();
            } else {
                // Mostrar mensagem de erro de login
                System.err.println("Login falhou! Verifique suas credenciais.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro durante o login: " + e.getMessage());
        }
    }


    private void carregarTelaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/aginvest/Home.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) fazerLogin.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar tela principal: " + e.getMessage());
        }
    }
}

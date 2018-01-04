/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador.de.senhas;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Diego Seid
 */
public class GeradorController implements Initializable {

    @FXML
    private AnchorPane PaneBase;
    @FXML
    private TextField txtDominio;
    @FXML
    private TextField txtSipTrunk;
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtTerminal;
    @FXML
    private TextField txtPassTerminal;
    @FXML
    private TextField txtPassUsuario;
    @FXML
    private TextField txtPassSipTrunk;
    @FXML
    private TextField txtPassAdministrator;
    @FXML
    private JFXButton butGera;
    @FXML
    private JFXButton butLimpa;
    @FXML
    private JFXButton butCopiaAdm;
    @FXML
    private JFXButton butCopiaSip;
    @FXML
    private JFXButton butCopiaUsu;
    @FXML
    private JFXButton butCopiaTer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        butGera.setOnMouseClicked((event) -> {
            if(!"".equals(txtDominio.getText()))
                Gerar(txtDominio, "Dom");
            if(!"".equals(txtSipTrunk.getText()))
                Gerar(txtSipTrunk, "Sip");
            if(!"".equals(txtUsuario.getText()))
                Gerar(txtUsuario, "Usu");
            if(!"".equals(txtTerminal.getText()))
                Gerar(txtTerminal, "Term");
        });
        
        butLimpa.setOnMouseClicked((event) -> {
            txtDominio.clear();
            txtPassAdministrator.clear();
            txtSipTrunk.clear();
            txtPassSipTrunk.clear();
            txtUsuario.clear();
            txtPassUsuario.clear();
            txtTerminal.clear();
            txtPassTerminal.clear();
        });
        
        butCopiaAdm.setOnMouseClicked((event) -> {
           Clipboard clipboard = Clipboard.getSystemClipboard();
           ClipboardContent content = new ClipboardContent();
           content.putString(txtPassAdministrator.getText());
           clipboard.setContent(content);
        });
        
        butCopiaSip.setOnMouseClicked((event) -> {
           Clipboard clipboard = Clipboard.getSystemClipboard();
           ClipboardContent content = new ClipboardContent();
           content.putString(txtPassSipTrunk.getText());
           clipboard.setContent(content);
        });
        
        butCopiaUsu.setOnMouseClicked((event) -> {
           Clipboard clipboard = Clipboard.getSystemClipboard();
           ClipboardContent content = new ClipboardContent();
           content.putString(txtPassUsuario.getText());
           clipboard.setContent(content);
        });
        
        butCopiaTer.setOnMouseClicked((event) -> {
           Clipboard clipboard = Clipboard.getSystemClipboard();
           ClipboardContent content = new ClipboardContent();
           content.putString(txtPassTerminal.getText());
           clipboard.setContent(content);
        });
        
    }    
    
    public void Gerar(TextField Campo, String Camp){
        
        String Temp, TempD, Senha, tSenha;
        char[] Valor = Campo.getText().toCharArray(), v1;
        char var, var2, var3,var4, var5, var6;
        Integer Tam;
           
        switch(Camp){
            case "Dom":
                   Temp = Campo.getText();
                Tam = Temp.length();
                v1 = Temp.toCharArray();
                var = Character.toUpperCase(v1[0]); var2 = v1[1]; var3 = v1[2]; var4 = v1[3]; var5 = v1[4]; var6 = v1[5];     
                    Senha = (var + Tam.toString() + var2 + var3 + var4 + var5 + var6 + aleatorio());
                txtPassAdministrator.setText(Senha);
              break;
            case "Usu":
                TempD = txtDominio.getText();
                   Temp = Campo.getText();
                Tam = TempD.length();
                v1 = TempD.toCharArray();
                var = Character.toUpperCase(v1[0]); var2 = v1[1]; var3 = v1[2];       
                    Senha = (var + Tam.toString() + var2 + var3 + Temp + aleatorio());
                txtPassUsuario.setText(Senha);
             break;
             
             case "Term":
                TempD = txtDominio.getText();
                   Temp = Campo.getText();
                Tam = TempD.length();
                v1 = TempD.toCharArray();
                var = Character.toUpperCase(v1[0]); var2 = v1[1]; var3 = v1[2];       
                    Senha = (var + Tam.toString() + var2 + var3 + Temp + aleatorio());
                txtPassTerminal.setText(Senha);
             break;
             
             case "Sip":
                  TempD = txtDominio.getText();
                   Temp = Campo.getText();
                Tam = TempD.length();
                v1 = TempD.toCharArray();
                var = Character.toUpperCase(v1[0]); var2 = v1[1]; var3 = v1[2];       
                    Senha = (var + Tam.toString() + var2 + var3 + Temp + aleatorio());
                txtPassSipTrunk.setText(Senha);
             break;
        }
    }
    
    public char aleatorio(){
        int minimo = 0, maximo = 3, res;
            String valores = "@!#*";
        char[] rand = valores.toCharArray();
            Random random = new Random();
        res = random.nextInt((maximo - minimo) + 1) + minimo;
        return rand[res];
    }
}

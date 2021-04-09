package com.estacio.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

//    EditText editTextLogin;
    private TextInputLayout textInputLayoutLogin;
//    EditText editTextSenha;
    private TextInputLayout textInputLayoutSenha;
    private Button buttonLogar;
    private String loginPadrao = "dion";
    private String senhaPadrao = "123";
    private TextView textViewCadastreSe;
    private Intent intentIrTelaCadastro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLayoutLogin = findViewById(R.id.textFieldLogin);
        textInputLayoutSenha = findViewById(R.id.TextInputLayoutSenha);
        textViewCadastreSe = findViewById(R.id.textViewCadastreSe);

        buttonLogar = findViewById(R.id.buttonLogar);

        //Intent(telaAtual.this, telaAlvo.class)
        intentIrTelaCadastro = new Intent(MainActivity.this, CadastroActivity.class);

        textViewCadastreSe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentIrTelaCadastro);
            }
        });


        buttonLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = textInputLayoutLogin.getEditText().getText().toString();
                String senha = textInputLayoutSenha.getEditText().getText().toString();
                if(login.equals(loginPadrao) && senha.equals(senhaPadrao)){
                    String mensagem = "LOGADO";
                    Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_SHORT).show();
                    textInputLayoutSenha.setError("");
                }else{
                    String mensagem = "Não logado";
                    Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_SHORT).show();
                    textInputLayoutSenha.setError("Login ou senha inválido");
                }
            }
        });

    }
}
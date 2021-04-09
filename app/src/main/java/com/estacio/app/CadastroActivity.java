package com.estacio.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.estacio.app.utilities.ValidaCampos;
import com.google.android.material.textfield.TextInputLayout;


public class CadastroActivity extends AppCompatActivity {

    TextInputLayout textInputLayoutNome;
    TextInputLayout textInputLayoutDataNasc;
    TextInputLayout textInputLayoutCelular;
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutSenha;
    TextInputLayout textInputLayoutConfirmacaoSenha;
    Button buttonCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inicializaComponentes();
        cadastrarUsuario();


    }


    public void inicializaComponentes(){
        textInputLayoutNome = findViewById(R.id.textFieldNome);
        textInputLayoutDataNasc = findViewById(R.id.textFieldDataNasc);
        textInputLayoutCelular = findViewById(R.id.textFieldCelular);
        textInputLayoutEmail = findViewById(R.id.textFieldEmail);
        textInputLayoutSenha = findViewById(R.id.TextInputLayoutSenhaCadastro);
        textInputLayoutConfirmacaoSenha = findViewById(R.id.TextInputLayoutConfirmacaoSenhaCadastro);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);

    }

    public void cadastrarUsuario(){


      buttonCadastrar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              boolean nomeValido = ValidaCampos.NOME_COMPLETO(textInputLayoutNome.getEditText().getText().toString());
              if (nomeValido) {
                  textInputLayoutNome.setError("");
              }else{
                  textInputLayoutNome.setError("Nome necessário");
              }
          }
      });

    }

}
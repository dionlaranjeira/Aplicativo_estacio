package com.estacio.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.estacio.app.model.Usuario;
import com.estacio.app.utilities.TextMask;
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
        validaCamposEMascaras();
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

    public void validaCamposEMascaras(){
        textInputLayoutDataNasc.getEditText().addTextChangedListener(TextMask.mask(textInputLayoutDataNasc.getEditText(),
                TextMask.FORMAT_DATE));

        textInputLayoutCelular.getEditText().addTextChangedListener(TextMask.mask(textInputLayoutCelular.getEditText(),
                TextMask.FORMAT_FONE));
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

              Usuario novoUsuario = new Usuario();
              novoUsuario.setNome(textInputLayoutNome.getEditText().getText().toString());
              novoUsuario.setDataNasc(textInputLayoutDataNasc.getEditText().getText().toString());
              novoUsuario.setCelular(textInputLayoutCelular.getEditText().getText().toString());
              novoUsuario.setEmail(textInputLayoutEmail.getEditText().getText().toString());
              novoUsuario.setSenha(textInputLayoutSenha.getEditText().getText().toString());


          }
      });

    }

}
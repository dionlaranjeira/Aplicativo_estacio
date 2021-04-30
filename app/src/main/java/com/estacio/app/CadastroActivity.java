package com.estacio.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.estacio.app.model.Usuario;
import com.estacio.app.utilities.TextMask;
import com.estacio.app.utilities.ValidaCampos;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class CadastroActivity extends AppCompatActivity {

    private FirebaseAuth autenticacao;
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

        //Pegar a instancia do FireBaseAuth

        autenticacao = FirebaseAuth.getInstance();

        //Cria o usuario
        autenticacao
                .createUserWithEmailAndPassword("marcelo@gmail.com","123456").
                addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(CadastroActivity.this, "Login criado com sucesso", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(CadastroActivity.this, "Falha ao criar login", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        // deslogar usuario.
        autenticacao.signOut();

        // Logar usuario ja cadastrado

        autenticacao.signInWithEmailAndPassword("dionribeiro.rr@gmail.com","123456").
                addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(CadastroActivity.this, "Usuario logado com sucesso", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(CadastroActivity.this, "Login ou senha invalido", Toast.LENGTH_LONG).show();
                        }
                    }
                });



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
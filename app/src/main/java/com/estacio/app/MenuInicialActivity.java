package com.estacio.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.estacio.app.model.Pergunta;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MenuInicialActivity extends AppCompatActivity {

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference perguntas = database.getReference("perguntas/1");

    TextView textViewPergunta;
    RadioButton radioButtonA;
    RadioButton radioButtonB;
    RadioButton radioButtonC;
    RadioButton radioButtonD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);

        textViewPergunta = findViewById(R.id.textViewPergunta);
        radioButtonA = findViewById(R.id.radioButtonA);
        radioButtonB = findViewById(R.id.radioButtonB);
        radioButtonC = findViewById(R.id.radioButtonC);
        radioButtonD = findViewById(R.id.radioButtonD);

        perguntas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Toast.makeText(MenuInicialActivity.this, "Teste", Toast.LENGTH_SHORT).show();
//                System.out.println("Estou dentro do onDataChange-->"+ snapshot.toString());
                Pergunta pergunta1 = snapshot.getValue(Pergunta.class);
                textViewPergunta.setText(pergunta1.getDescricao());
                radioButtonA.setText(pergunta1.getAlternativaA());
                radioButtonB.setText(pergunta1.getAlternativaB());
                radioButtonC.setText(pergunta1.getAlternativaC());
                radioButtonD.setText(pergunta1.getAlternativaD());

//                System.out.println("Descrição: "+ pergunta1.getDescricao());
//                System.out.println("Alternativa A: "+ pergunta1.getAlternativaA());
//                System.out.println("Alternativa B: "+ pergunta1.getAlternativaB());
//                System.out.println("Alternativa C: "+ pergunta1.getAlternativaC());
//                System.out.println("Alternativa D: "+ pergunta1.getAlternativaD());
//                System.out.println("Correta: "+ pergunta1.getCorreta());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}
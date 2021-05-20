package com.estacio.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.estacio.app.model.Pergunta;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MenuInicialActivity extends AppCompatActivity {

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference perguntas = database.getReference("perguntas/1");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);

        perguntas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//              System.out.println("Estou dentro do onDataChange-->"+ snapshot.toString());
                Pergunta pergunta = snapshot.getValue(Pergunta.class);
                System.out.println("Descrição: "+ pergunta.getDescricao());
                System.out.println("Alternativa A: "+ pergunta.getAlternativaA());
                System.out.println("Alternativa B: "+ pergunta.getAlternativaB());
                System.out.println("Alternativa C: "+ pergunta.getAlternativaC());
                System.out.println("Alternativa D: "+ pergunta.getAlternativaD());
                System.out.println("Correta: "+ pergunta.getCorreta());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}
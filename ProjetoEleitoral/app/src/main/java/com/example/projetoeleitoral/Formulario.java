package com.example.projetoeleitoral;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Formulario extends AppCompatActivity {
    Button btn;
    EditText edNome, edEstCivil, edIdade, edSexo, edTelefone;
    PessoaForms pe = new PessoaForms();

    ArrayList<PessoaForms> peL = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario);
        btn = (Button) findViewById(R.id.button);
        edNome = (EditText) findViewById(R.id.edNome);
        edEstCivil = (EditText) findViewById(R.id.edEC);
        edTelefone = (EditText) findViewById(R.id.editTextText4);
        edSexo = (EditText) findViewById(R.id.editTextText3);
        edIdade = (EditText) findViewById(R.id.editTextNumber);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pe.setNome(edNome.getText().toString());
                pe.setEstCivil(edEstCivil.getText().toString());
                pe.setSexo(edSexo.getText().toString());
                pe.setTelefone(edTelefone.getText().toString());
                pe.setIdade(Integer.parseInt(edIdade.getText().toString()));


                Intent inte = new Intent(Formulario.this, Login.class);
                startActivity(inte);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
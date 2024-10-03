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

public class Tela1 extends AppCompatActivity {
    Button btnConfirmar, btnResul;
    EditText edResp;
    PessoaLogin pl = PessoaLogin.getInstance();
    Voto vt = Voto.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela1);

        btnResul = (Button) findViewById(R.id.btnResuslt);
        btnConfirmar = (Button) findViewById(R.id.btnVtE);
        edResp = (EditText) findViewById(R.id.edNomeCand);

        if(pl.getPessoa().trim().equals("entrevistador")){
            btnResul.setVisibility(View.INVISIBLE);
        }

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vt.vte.add(new VotoE(edResp.getText().toString()));
                Intent inte = new Intent(Tela1.this, Tela2.class);
                startActivity(inte);
            }
        });

        btnResul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela1.this,Resposta.class);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
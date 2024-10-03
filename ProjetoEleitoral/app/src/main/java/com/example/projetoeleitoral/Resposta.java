package com.example.projetoeleitoral;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Resposta extends AppCompatActivity {
    TextView txtc1,txtc2,txtc3,txtc4,txttds;
    Button btnSa;
    Voto vt = Voto.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resposta);
        btnSa = (Button) findViewById(R.id.btnSair);
        txtc1 = (TextView) findViewById(R.id.txtCand1);
        txtc2 = (TextView) findViewById(R.id.txtCand2);
        txtc3 = (TextView) findViewById(R.id.txtCand3);
        txtc4 = (TextView) findViewById(R.id.txtCand4);
        txttds = (TextView) findViewById(R.id.tdsCandidatos);


        txtc1.setText("O candidato Gustavo obteve: "+vt.getCand1()+" votos");
        txtc2.setText("O candidato Pedro obteve: "+vt.getCand2()+" votos");
        txtc3.setText("O candidato Victor obteve: "+vt.getCand3()+" votos");
        txtc4.setText("O candidato José obteve: "+vt.getCand4()+" votos");

        String respsCands = vt.resultados();

        txttds.setText(respsCands);

        btnSa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Resposta.this, Login.class);
                startActivity(i);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
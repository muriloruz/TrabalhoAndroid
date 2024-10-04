package com.example.projetoeleitoral;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela2 extends AppCompatActivity {
    Button btnVotar;
    RadioButton can1, can2, can3, can4, cand5, nulo,branco,inde;
    Voto vt = Voto.getInstance();
    boolean c1,c2,c3,c4,c5,cn,cb,ci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela2);

        btnVotar = (Button) findViewById(R.id.btnVotar);
        can1 = (RadioButton) findViewById(R.id.cand1);
        can2 = (RadioButton) findViewById(R.id.cand2);
        can3 = (RadioButton) findViewById(R.id.cand3);
        can4 = (RadioButton) findViewById(R.id.cand4);
        cand5 = (RadioButton) findViewById(R.id.cand5);
        nulo = (RadioButton) findViewById(R.id.nulos);
        branco = (RadioButton) findViewById(R.id.radbranco);
        inde = (RadioButton) findViewById(R.id.Indeciso);



        btnVotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1 = can1.isChecked();
                c2 = can2.isChecked();
                c3 = can3.isChecked();
                c4 = can4.isChecked();
                c5 = cand5.isChecked();
                cn = nulo.isChecked();
                cb = branco.isChecked();
                ci = inde.isChecked();


                if(c1) vt.setCand1();
                else if(c2) vt.setCand2();
                else if(c3) vt.setCand3();
                else if(c4) vt.setCand4();
                else if(c5) vt.setCand5();
                else if(cn) vt.setNulo();
                else if(cb) vt.setBranco();
                else if(ci) vt.setInde();

                Intent intent = new Intent(Tela2.this, Formulario.class);
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
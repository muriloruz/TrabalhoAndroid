package com.example.projetoeleitoral;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela2 extends AppCompatActivity {
    Button btnVotar;
    CheckBox can1, can2, can3, can4;
    Voto vt = Voto.getInstance();
    boolean c1,c2,c3,c4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela2);

        btnVotar = (Button) findViewById(R.id.btnVotar);
        can1 = (CheckBox) findViewById(R.id.cand1);
        can2 = (CheckBox) findViewById(R.id.cand2);
        can3 = (CheckBox) findViewById(R.id.cand3);
        can4 = (CheckBox) findViewById(R.id.cand4);



        btnVotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1 = can1.isChecked();
                c2 = can2.isChecked();
                c3 = can3.isChecked();
                c4 = can4.isChecked();


                if(c1) vt.setCand1();
                else if(c2) vt.setCand2();
                else if(c3) vt.setCand3();
                else if(c4) vt.setCand4();


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
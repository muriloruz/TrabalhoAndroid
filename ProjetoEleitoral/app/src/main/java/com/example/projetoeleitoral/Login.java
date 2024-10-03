package com.example.projetoeleitoral;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {
    Button btnLog;
    EditText edUser, edSenha;
    String[] usuario, senha;
    PessoaLogin pl = PessoaLogin.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        btnLog = (Button) findViewById(R.id.btnLogar);
        edUser = (EditText) findViewById(R.id.EdUser);
        edSenha = (EditText) findViewById(R.id.edSenha);

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int contador = 0;
                usuario = pl.getNome().split(",");
                senha = pl.getSenha().split(",");
                for (String i : usuario) {
                    if (i.equals(edUser.getText().toString().trim())) {
                        contador++;
                        if(i.trim().equals("admin")) {
                            if (edSenha.getText().toString().trim().equals("admin")) {
                                contador++;
                                if (contador == 2) {
                                    pl.setPessoa(edUser.getText().toString());
                                    Intent intent = new Intent(Login.this, Tela1.class);
                                    startActivity(intent);
                                }
                            }
                        }else if(i.trim().equals("entrevistador")){
                            if (edSenha.getText().toString().trim().equals("entrevistador")) {
                                contador++;
                                if (contador == 2) {
                                    pl.setPessoa(edUser.getText().toString());
                                    Intent intent = new Intent(Login.this, Tela1.class);
                                    startActivity(intent);
                                }
                            }
                        }
                    }
                }
                if(contador!=2){
                    Toast.makeText(Login.this, "Usuário não existe", Toast.LENGTH_SHORT).show();
                }


            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
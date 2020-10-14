package com.example.provad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnIniciar;
    private EditText edtNome;
    private RadioButton rbtnMasculino, rbtnFeminino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setendo o campo de enserir nome
        edtNome = findViewById(R.id.edtNome);

        //Setando os botões de radio
        rbtnMasculino = findViewById(R.id.rbtnMasculino);
        rbtnFeminino = findViewById(R.id.rbtnFeminino);

        //Setendo o botão de iniciar
        btnIniciar = findViewById(R.id.btnIniciar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MassaCorporalActivity.class);

                if (!edtNome.getText().toString().equalsIgnoreCase("")  && (rbtnFeminino.isChecked() == true ||rbtnMasculino.isChecked() == true)){

                    String nome = edtNome.getText().toString();
                    boolean sexoFeminimo = rbtnFeminino.isChecked();
                    boolean sexoMasculino = rbtnMasculino.isChecked();
                    intent.putExtra("nome", nome);
                    intent.putExtra("sexoFeminimo",sexoFeminimo);
                    intent.putExtra("sexoMasculino",sexoMasculino);
                    startActivityForResult(intent, 1000);
                }
                else if(edtNome.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this,"Informe o nome",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Informe o sexo",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
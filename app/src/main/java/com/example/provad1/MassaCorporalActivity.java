package com.example.provad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MassaCorporalActivity extends AppCompatActivity {

    private TextView txtOla, txtResultImc, txtImc;
    private EditText edtAltura, edtPeso;
    private Button btnCalcular;
    private ImageView imgResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massa_corporal);

        //setando o label
        txtOla = findViewById(R.id.txtOla);
        txtResultImc = findViewById(R.id.txtResultImc);
        txtImc = findViewById(R.id.txtImc);

        //setando edit tex de altura e peso
        edtAltura = findViewById(R.id.edtAltura);
        edtPeso = findViewById(R.id.edtPeso);

        //setando o botão de calculo
        btnCalcular = findViewById(R.id.btnCalcular);

        //Setando imagem
        imgResult = findViewById(R.id.imgResult);

        Intent intent = getIntent();

        txtOla.setText("Olá " + intent.getStringExtra("nome") + "!!");

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtPeso.getText().toString().equals("")){
                    Toast.makeText(MassaCorporalActivity.this,"Informe o peso",Toast.LENGTH_LONG).show();
                }
                else if (edtAltura.getText().toString().equals("")){
                    Toast.makeText(MassaCorporalActivity.this,"Informe o altura",Toast.LENGTH_LONG).show();
                }
                else{
                    double peso = Double.parseDouble(edtPeso.getText().toString().replace(",", "."));
                    double altura = Double.parseDouble(edtAltura.getText().toString().replace(",", "."));
                    //double a =  Math.pow(altura,2);
                    double imc = peso / Math.pow(altura, 2);
                    txtImc.setText("Imc: " + Double.parseDouble(String.format("%.2f", imc)));

                    Intent intent = getIntent();

                    //estrutura condicional que informa se esta acima ou abaixo do peso adequado para MULHERES
                    if(intent.getBooleanExtra("sexoFeminimo", true)){
                        if (imc < 19.1){
                            txtResultImc.setText("Você está abaixo do peso!!");

                            //estrutura para setar as imagens diacordo com o IMC FEMININO
                            Drawable myDrawable = getResources().getDrawable(R.drawable.mulher_abaixo_peso);
                            imgResult.setImageDrawable(myDrawable);
                        }
                        else if (imc < 25.8){
                            txtResultImc.setText("Você está no peso normal!!");

                            Drawable myDrawable = getResources().getDrawable(R.drawable.mulher_peso_normal);
                            imgResult.setImageDrawable(myDrawable);
                        }
                        else if (imc < 32.3){
                            txtResultImc.setText("Você está acima do peso!!");

                            Drawable myDrawable = getResources().getDrawable(R.drawable.mulher_acima_peso);
                            imgResult.setImageDrawable(myDrawable);
                        }
                        else {
                            txtResultImc.setText("Você está obesa!!");

                            Drawable myDrawable = getResources().getDrawable(R.drawable.mulher_obesa);
                            imgResult.setImageDrawable(myDrawable);
                        }

                    }

                    //estrutura condicional que informa se esta acima ou abaixo do peso adequado para HOMENS
                    if(intent.getBooleanExtra("sexoMasculino", true)){
                        if (imc < 20.7){
                            txtResultImc.setText("Você está abaixo do peso!!");

                            //estrutura para setar as imagens diacordo com o IMC MASCULINO
                            Drawable myDrawable = getResources().getDrawable(R.drawable.homem_abaixo_peso);
                            imgResult.setImageDrawable(myDrawable);
                        }
                        else if (imc < 26.4){
                            txtResultImc.setText("Você está no peso normal!!");

                            Drawable myDrawable = getResources().getDrawable(R.drawable.homem_peso_normal);
                            imgResult.setImageDrawable(myDrawable);
                        }
                        else if (imc < 31.1){
                            txtResultImc.setText("Você está acima do peso!!");

                            Drawable myDrawable = getResources().getDrawable(R.drawable.homem_acima_peso);
                            imgResult.setImageDrawable(myDrawable);
                        }
                        else {
                            txtResultImc.setText("Você está obeso!!");

                            Drawable myDrawable = getResources().getDrawable(R.drawable.homem_obeso);
                            imgResult.setImageDrawable(myDrawable);
                        }
                    }
                }
            }
        });







    }
}
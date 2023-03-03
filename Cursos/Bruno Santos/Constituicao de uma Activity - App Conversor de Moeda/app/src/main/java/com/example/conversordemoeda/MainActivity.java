package com.example.conversordemoeda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //Declarar os elementos
    EditText et_valorEuros;
    Button bt_converter;
    TextView tv_valorDolares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pegando os elementos por id e os identificando
        et_valorEuros = findViewById(R.id.et_ValorEmEuros);
        bt_converter = findViewById(R.id.bt_Converter);
        tv_valorDolares = findViewById(R.id.tv_ValorEmDolares);

        //Criando um evento de click no botão CONVERTER
        bt_converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Codigo que será executado quando precionado o botão
                double valorEuros = Double.parseDouble(et_valorEuros.getText().toString()); //Pega o valor digitado em Euros

                DecimalFormat arredondar = new DecimalFormat("#.##"); //Arredondar para duas casas decimais
                double valorDolares = Double.parseDouble(arredondar.format(valorEuros * 0.80)); //Logica da conversão

                tv_valorDolares.setText(String.valueOf(valorDolares)+"$"); //Converte em string e mostra na TextView
            }
        });
    }
}
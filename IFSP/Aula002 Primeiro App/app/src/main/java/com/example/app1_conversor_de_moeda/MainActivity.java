package com.example.app1_conversor_de_moeda;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private final double DOLLAR_VALUE = 5.8;
    private EditText valueEditText;
    private Button converterButton;
    private TextView convertedValueTextView;

    private Button convertedButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valueEditText = findViewById(R.id.edittext_value);
        convertedValueTextView = findViewById(R.id.textview_value_converted);
        converterButton = findViewById(R.id.button_converter);
        convertedButton2 = findViewById(R.id.button_converter2);

        converterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valorReais=Double.parseDouble(valueEditText.getText().toString());
                double valorDolares = valorReais * 5.8;
                convertedValueTextView.setText(String.valueOf(valorDolares));
            }
        });

        convertedButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat arredondar = new DecimalFormat("#.##"); //Arredondar para duas casas decimais
                double valorDolares=Double.parseDouble(valueEditText.getText().toString());
                double valorReais = Double.parseDouble(arredondar.format( valorDolares / 5.8));
                convertedValueTextView.setText(String.valueOf(valorReais));
            }
        });

    }

        private void getConvertion(){
            double value;
            String valueString;
            valueString = valueEditText.getText().toString();
            try {
                value = Double.valueOf(valueString);
            }catch (NumberFormatException e){
                Toast.makeText(this, "Valor digitado é invalido.", Toast.LENGTH_SHORT).show();
                value = 0;
            }
            value = value / DOLLAR_VALUE;
            convertedValueTextView.setText(String.valueOf(value));
        }
}
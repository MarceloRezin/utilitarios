package com.util.utilitarios;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ImcActivity extends AppCompatActivity {

    private Button calcular;
    private EditText editTextPeso;
    private EditText editTextAltura;

    private EditText editTextPesoIdeal;
    private EditText editTextImc;
    private EditText editTextInterpretacao;

    private Button limpar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        editTextPeso = findViewById(R.id.edit_peso);
        editTextAltura = findViewById(R.id.edit_altura);
        editTextPesoIdeal = findViewById(R.id.edit_peso_ideal);
        editTextImc = findViewById(R.id.edit_imc);
        editTextInterpretacao = findViewById(R.id.edit_interpretacao);

        calcular = findViewById(R.id.btn_calcular);
        calcular.setOnClickListener(o -> {

            BigDecimal altura = new BigDecimal(editTextAltura.getText().toString());
            BigDecimal alturaCm = altura.multiply(new BigDecimal("100"));
            BigDecimal peso = new BigDecimal(editTextPeso.getText().toString());

            BigDecimal pesoIdeal = alturaCm.subtract(new BigDecimal("100")).subtract(alturaCm.subtract(peso).divide(new BigDecimal("4")).multiply(new BigDecimal("0.05")));
            pesoIdeal = pesoIdeal.setScale(2, RoundingMode.HALF_DOWN);
            editTextPesoIdeal.setText(pesoIdeal.toString() + " Kg");

            BigDecimal imc = peso.divide(altura.pow(2), 2, RoundingMode.HALF_DOWN);
            editTextImc.setText(imc.toString());

            if(imc.compareTo(new BigDecimal("20")) < 0){
                editTextInterpretacao.setText("Baixo Peso");
            }else if(imc.compareTo(new BigDecimal("25")) < 0){
                editTextInterpretacao.setText("Normal");
            }else if(imc.compareTo(new BigDecimal("30")) <= 0){
                editTextInterpretacao.setText("Acima do Peso");
            }else{
                editTextInterpretacao.setText("Obeso");
            }
        });

        limpar = findViewById(R.id.btn_limpar);
        limpar.setOnClickListener(o -> {
            editTextPeso.getText().clear();
            editTextAltura.getText().clear();
            editTextPesoIdeal.getText().clear();
            editTextImc.getText().clear();
            editTextInterpretacao.getText().clear();

            editTextPeso.requestFocus();
        });
    }
}

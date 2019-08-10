package com.util.utilitarios;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

            try {

                String pesoString = editTextPeso.getText().toString();
                if(pesoString.isEmpty()){
                    throw new Exception("Informe o peso!");
                }

                String alturaString = editTextAltura.getText().toString();
                if(alturaString.isEmpty()){
                    throw new Exception("Informe a altura!");
                }

                BigDecimal altura = new BigDecimal(alturaString);
                if(altura.compareTo(new BigDecimal("1.1")) < 0 || altura.compareTo(new BigDecimal("2.5")) > 0){
                    throw new Exception("A altura informada é inválida!");
                }
                BigDecimal alturaCm = altura.multiply(new BigDecimal("100"));

                BigDecimal peso = new BigDecimal(pesoString);
                if(peso.compareTo(new BigDecimal("10")) < 0 || peso.compareTo(new BigDecimal("200")) > 0){
                    throw new Exception("O peso informado é inválido!");
                }

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

            }catch (Exception e){
                Toast.makeText(ImcActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
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

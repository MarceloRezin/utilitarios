package com.util.utilitarios;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

public class ConversaoPendriveDisqueteActivity extends AppCompatActivity  {
    private EditText editPenDriveValor;
    private Button btnCalcular;
    private TextView resultado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversao_pendrive_disquete);

        editPenDriveValor = findViewById(R.id.edit_penDrive);
        resultado= findViewById(R.id.txt_ResultadoPendrive);

        btnCalcular= findViewById(R.id.btn_penDrive);
        btnCalcular.setOnClickListener(o->{
            try {
                String pendriveValorString= editPenDriveValor.getText().toString();
                if(pendriveValorString.isEmpty()){
                    throw new Exception("Informe Tamanho do Pen-Drive!");
                }
                BigDecimal pendriveValor = new BigDecimal(pendriveValorString);
                /*if(pendriveValor.compareTO(new BigDecimal(0.0))==0){
                    throw new Exception("A Tamanho do pendrive esta errado!");
                }   Ver Marcelo porque não executou a instrução    */

                BigDecimal pendriveMega= pendriveValor.multiply(new BigDecimal("1024"));
                BigDecimal resultadoDisk=pendriveMega.divide(new BigDecimal("1.44"));
                resultado.setText("Um Pen-drive de: " + pendriveValorString+" é o equivalente a: " + resultadoDisk + " Disquetes");

            }catch (Exception e){
                Toast.makeText(ConversaoPendriveDisqueteActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
package com.util.utilitarios;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConversaoPendriveDisqueteActivity extends AppCompatActivity  {
    private static final BigDecimal UM_GB_EM_MB = new BigDecimal("1024");
    private static final BigDecimal TAMANHO_DISQUETE_EM_MB = new BigDecimal("1.44");

    private EditText editPenDriveValor;
    private Button btnCalcular;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversao_pendrive_disquete);

        editPenDriveValor = findViewById(R.id.edit_penDrive);

        btnCalcular= findViewById(R.id.btn_penDrive);
        btnCalcular.setOnClickListener(o->{
            try {
                String pendriveValorString = editPenDriveValor.getText().toString();
                if(pendriveValorString.isEmpty()){
                    throw new Exception("Informe o tamanho do pendrive!");
                }

                BigDecimal pendriveValor = new BigDecimal(pendriveValorString);
                if(pendriveValor.compareTo(new BigDecimal("0")) == 0){
                    throw new Exception("Tamanho do pendrive deve ser maior que 0!");
                }

                BigDecimal pendriveMega = pendriveValor.multiply(UM_GB_EM_MB);
                BigDecimal resultadoDisk = pendriveMega.divide(TAMANHO_DISQUETE_EM_MB, 2, RoundingMode.HALF_DOWN);

                Toast.makeText(ConversaoPendriveDisqueteActivity.this, "Um pendrive de " + pendriveValorString +"GB equivale a " + resultadoDisk + " disquete(s)", Toast.LENGTH_LONG).show();
            }catch (Exception e){
                Toast.makeText(ConversaoPendriveDisqueteActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
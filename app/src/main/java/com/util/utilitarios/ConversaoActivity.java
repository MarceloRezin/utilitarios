package com.util.utilitarios;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConversaoActivity extends AppCompatActivity {

    private static final String DESC_DOLAR = " Dólar americano igual a";
    private static final String DESC_REAL = " Real Brasileiro";

    private TextView textViewDescDolar;
    private TextView textViewResultReal;

    private EditText editTextDolar;
    private EditText editTextReal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversao);

        textViewDescDolar = findViewById(R.id.text_desc_dolar);
        textViewDescDolar.setText("1" + DESC_DOLAR);

        textViewResultReal = findViewById(R.id.text_result_real);
        textViewResultReal.setText("3.96" + DESC_REAL);

        editTextDolar = findViewById(R.id.edit_dolar);
        editTextDolar.setText("1");
        editTextReal = findViewById(R.id.edit_real);
        editTextReal.setText("3.96");

        editTextDolar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() > 0){
                    textViewDescDolar.setText(charSequence + DESC_DOLAR);

                    BigDecimal dolar = new BigDecimal(charSequence.toString());

                    String txtReal = editTextReal.getText().toString();
                    if(txtReal.length() > 0){
                        BigDecimal real = new BigDecimal(txtReal);

                        textViewResultReal.setText(real.multiply(dolar).setScale(2, RoundingMode.HALF_DOWN).toString() + DESC_REAL);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        editTextReal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() > 0){
                    String txtDolar = editTextDolar.getText().toString();

                    if(txtDolar.length() > 0){
                        BigDecimal dolar = new BigDecimal(txtDolar);
                        BigDecimal real = new BigDecimal(charSequence.toString());
                        textViewResultReal.setText(real.multiply(dolar).setScale(2, RoundingMode.HALF_DOWN).toString() + DESC_REAL);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }
}

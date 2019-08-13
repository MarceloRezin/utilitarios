package com.util.utilitarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnImc;
    private Button btnConversaoDolarReal;
    private Button btnConversaoPendrive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImc = findViewById(R.id.btn_imc);
        btnImc.setOnClickListener(o -> {
            Intent it = new Intent(MainActivity.this, ImcActivity.class);
            startActivity(it);
        });

        btnConversaoDolarReal = findViewById(R.id.btn_conversao_dolar_real);
        btnConversaoDolarReal.setOnClickListener(o -> {
            Intent it = new Intent(MainActivity.this, ConversaoDolarRealActivity.class);
            startActivity(it);
        });

        btnConversaoPendrive = findViewById(R.id.btn_conversao_pendrive);
        btnConversaoPendrive.setOnClickListener(o -> {
            Intent it = new Intent(MainActivity.this, ConversaoPendriveDisqueteActivity.class);
            startActivity(it);
        });
    }
}

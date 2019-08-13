package com.util.utilitarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnImc;
    private Button btnConversao;
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

        btnConversao = findViewById(R.id.btn_conversao);
        btnConversao.setOnClickListener(o -> {
            Intent it = new Intent(MainActivity.this, ConversaoActivity.class);
            startActivity(it);
        });

        btnConversaoPendrive = findViewById(R.id.btn_conversao_pendrive);
        btnConversaoPendrive.setOnClickListener(o -> {
            Intent it = new Intent(MainActivity.this, ConversaoPendriveDisqueteActivity.class);
            startActivity(it);
        });
    }
}

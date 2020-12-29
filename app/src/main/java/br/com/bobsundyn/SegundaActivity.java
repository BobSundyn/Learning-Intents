package br.com.bobsundyn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

    Button btnFechar, btnCarro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        btnFechar = findViewById(R.id.btnFechar);
        btnCarro = findViewById(R.id.btnCarro);

        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Bundle bundle = getIntent().getExtras();
                    String carro = bundle.getString("carro");
                    int ano = bundle.getInt("ano");
                    Toast.makeText(SegundaActivity.this, "Carro: " + carro, Toast.LENGTH_SHORT).show();
                    Toast.makeText(SegundaActivity.this, "Ano: " + ano, Toast.LENGTH_SHORT).show();
                } catch (Exception exception) {
                    Toast.makeText(SegundaActivity.this, "Não foi enviado o Bundle, para esta tela", Toast.LENGTH_SHORT).show();
                    Toast.makeText(SegundaActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
package br.com.bobsundyn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSegundaTela, btnBundle, btnNavegador, btnTelefone, btnMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSegundaTela = findViewById(R.id.btnSegundaTela);
        btnBundle = findViewById(R.id.btnBundle);
        btnNavegador = findViewById(R.id.btnNavegador);
        btnTelefone = findViewById(R.id.btnTelefone);
        btnMensagem = findViewById(R.id.btnMensagem);



        btnSegundaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirSegundaActivity = new Intent(MainActivity.this, SegundaActivity.class);
                startActivity(abrirSegundaActivity);
            }
        });

        btnBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirSegundaActivity = new Intent(MainActivity.this, SegundaActivity.class);
                Bundle bundle = new Bundle();
                String carro = "Kombi";
                int ano = 1980;
                bundle.putString("carro", carro);
                //bundle.putString("carro", "Kombi");
                //"" => chave, e do lado é o valor
                bundle.putInt("ano", ano);
                //bundle.putInt("ano", 1980);
                abrirSegundaActivity.putExtras(bundle);
                startActivity(abrirSegundaActivity);
            }
        });

        btnNavegador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("http://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });

        btnTelefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 996208464"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        btnMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType(HTTP.PLAIN_TEXT_TYPE);
                intent.putExtra("Hello!", message);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

    }
}
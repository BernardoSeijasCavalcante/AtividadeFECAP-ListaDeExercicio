package br.fecapccp.question5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SelecaoTamanhoPagamento extends AppCompatActivity {

    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioButton radioButton5;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selecao_tamanho_pagamento);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radioButton1 = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        radioButton5 = findViewById(R.id.radioButton5);

        button = findViewById(R.id.button2);

        radioButton1.setChecked(true);
        radioButton4.setChecked(true);
        button.setOnClickListener(view->{
            Bundle bundle = getIntent().getExtras();

            Double custo = bundle.getDouble("custo");
            String tipo = bundle.getString("sabor");
            String tamanho = "";
            if(radioButton1.isChecked()){
                custo *= 2;
                tamanho = "Pequeno";
            }
            if(radioButton2.isChecked()){
                custo *= 3;
                tamanho = "Médio";
            }
            if(radioButton3.isChecked()){
                custo *= 4;
                tamanho = "Grande";
            }

            String formaPagamento = "Cartão";
            if(radioButton5.isChecked()){
                formaPagamento = radioButton5.getText().toString();
            }

            Intent intent = new Intent(this, ResumoDoPedido.class);
            intent.putExtra("custo", custo);
            intent.putExtra("formaPagamento", formaPagamento);
            intent.putExtra("sabor", tipo);
            intent.putExtra("tamanho", tamanho);
            startActivity(intent);
            finish();

        });
    }
}
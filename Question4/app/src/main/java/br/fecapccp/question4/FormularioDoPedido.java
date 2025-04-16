package br.fecapccp.question4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class FormularioDoPedido extends AppCompatActivity {

    private TextInputEditText text;

    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_do_pedido);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        text= findViewById(R.id.textInputEditText);

        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);

        button = findViewById(R.id.button2);

        button.setOnClickListener(view ->{
            String nome = text.getText().toString();
            String tipo = "Big King";

            if(radioButton2.isChecked()){
                tipo = radioButton2.getText().toString();
            }

            if(radioButton3.isChecked()){
                tipo = radioButton3.getText().toString();
            }

            if(radioButton4.isChecked()){
                tipo = radioButton4.getText().toString();
            }

            Intent intent = new Intent(this, ResumoDoPedido.class);
            intent.putExtra("nome", nome);
            intent.putExtra("tipo", tipo);

            startActivity(intent);
            finish();
        });
    }
}
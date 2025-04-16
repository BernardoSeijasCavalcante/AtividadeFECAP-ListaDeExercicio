package br.fecapccp.question3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class FormularioDeCadastro extends AppCompatActivity {

    private TextInputEditText textInputEditText;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_de_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textInputEditText = findViewById(R.id.textInputEditText);
        button = findViewById(R.id.button2);

        button.setOnClickListener(view->{
            String nome = textInputEditText.getText().toString();

            if(nome != null && !nome.equals("")){
                Intent intent = new Intent(getApplicationContext(), ConfirmarCadastro.class);
                intent.putExtra("nome", nome);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(this, "Digite um nome válido!", Toast.LENGTH_LONG).show();
            }

        });

    }
}
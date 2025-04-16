package br.fecapccp.question4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumoDoPedido extends AppCompatActivity {

    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_do_pedido);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.textView2);
        button = findViewById(R.id.button3);

        Bundle bundle = getIntent().getExtras();
        String nome = bundle.getString("nome");

        String tipo = bundle.getString("tipo");

        String resultado = "Seu nome: " + nome + "\n" + "Seu tipo de lanche: " + tipo + ".";

        textView.setText(resultado);

        button.setOnClickListener(view ->{
            finish();
        });

    }
}
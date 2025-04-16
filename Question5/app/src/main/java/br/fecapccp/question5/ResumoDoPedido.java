package br.fecapccp.question5;

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

        Double custo = bundle.getDouble("custo");
        String formaPagamento = bundle.getString("formaPagamento");
        String sabor = bundle.getString("sabor");
        String tamanho = bundle.getString("tamanho");

        String resultado = "Pizza de " + sabor + "\n"
                + "Tamanho " + tamanho + ";" + "\n"
                + "Forma de Pagamento: " + formaPagamento + ";" + "\n"
                + "Total: R$ " + custo + ".";

        textView.setText(resultado);
        button.setOnClickListener(view->{
            finish();
        });

    }
}
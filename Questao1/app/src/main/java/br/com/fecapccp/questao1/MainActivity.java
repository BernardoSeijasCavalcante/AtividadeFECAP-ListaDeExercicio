package br.com.fecapccp.questao1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private CheckBox checkArroz;
    private CheckBox checkPao;
    private CheckBox checkBolacha;
    private CheckBox checkFeijao;
    private CheckBox checkMandioca;
    private TextView resultado;
    private Button totalDoPedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        checkArroz = findViewById(R.id.checkArroz);
        checkPao = findViewById(R.id.checkPao);
        checkBolacha = findViewById(R.id.checkBolacha);
        checkFeijao = findViewById(R.id.checkFeijao);
        checkMandioca = findViewById(R.id.checkMandioca);

        resultado = findViewById(R.id.resultado);
        totalDoPedido = findViewById(R.id.button);

        totalDoPedido.setOnClickListener(view->{
            Double total = 0.0;
            if(checkArroz.isChecked()){
                total += 2.0;
            }
            if(checkPao.isChecked()){
                total += 2.0;
            }
            if(checkBolacha.isChecked()){
                total += 4.0;
            }
            if(checkFeijao.isChecked()){
                total += 18.0;
            }
            if(checkMandioca.isChecked()){
                total += 7.0;
            }
            resultado.setText("O Total da Compra é: " + total.toString());
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}
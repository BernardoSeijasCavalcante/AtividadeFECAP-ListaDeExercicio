package br.fecapccp.question5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SelecaoDaPizza extends AppCompatActivity {

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selecaodapizza);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        checkBox1 = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);

        button = findViewById(R.id.button);

        button.setOnClickListener(view->{
            try {
                Double custo = 0.0;
                Double portion = 1.0;
                Double portionAux = 0.0;

                String tipo = "";

                if (checkBox1.isChecked()) {
                    portionAux++;
                }
                if (checkBox2.isChecked()) {
                    portionAux++;
                }
                if (checkBox3.isChecked()) {
                    portionAux++;
                }
                if (checkBox4.isChecked()) {
                    portionAux++;
                }

                portion = 1.0 / portionAux;

                if (checkBox1.isChecked()) {
                    custo += 10.00 * portion;
                    tipo += checkBox1.getText().toString() + ";";
                }
                if (checkBox2.isChecked()) {
                    custo += 15.00 * portion;
                    tipo += checkBox2.getText().toString() + ";";
                }
                if (checkBox3.isChecked()) {
                    custo += 20.00 * portion;
                    tipo += checkBox3.getText().toString() + ";";
                }
                if (checkBox4.isChecked()) {
                    custo += 30.00 * portion;
                    tipo += checkBox4.getText().toString() + ";";
                }

                if(custo == 0.0){
                    throw new Exception("Selecione um sabor de Pizza!");
                }

                Intent intent = new Intent(this, SelecaoTamanhoPagamento.class);
                intent.putExtra("custo", custo);
                intent.putExtra("sabor", tipo);


                startActivity(intent);
            }catch(Exception e){
                Toast.makeText(this, "Selecione um sabor para a Pizza!", Toast.LENGTH_LONG).show();
            }
        });

    }
}